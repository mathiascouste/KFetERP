package tools.handlers;

import java.util.LinkedList;
import java.util.List;

import model.Journee;
import model.stock.Item;
import model.time.Date;
import model.time.InvalidDateException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JourneesHandler extends DefaultHandler {
    // résultats de notre parsing
    private List<Journee> journees;
    private Journee journee;
    // flags nous indiquant la position du parseur
    private boolean inJournees, inJournee, inArticle, inNom, inNombre, inDate;
    // buffer nous permettant de récupérer les données
    private StringBuffer buffer;
    private StringBuffer nom;
    private StringBuffer nombre;
    private Date date;

    // simple constructeur
    public JourneesHandler() {
        super();
    }

    // détection d'ouverture de balise
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("xml")) {
            journees = new LinkedList<Journee>();
            inJournees = true;
        } else if (qName.equals("journee")) {
            journee = new Journee();
            inJournee = true;
        } else if (qName.equals("article")) {
            journee = new Journee();
            inJournee = true;
        } else {
            buffer = new StringBuffer();
            if (qName.equals("nom")) {
                inNom = true;
            } else if (qName.equals("nombre")) {
                inNombre = true;
            } else if (qName.equals("date")) {
                inDate = true;
            } else {
                // erreur, on peut lever une exception
                throw new SAXException("Balise " + qName + " inconnue.");
            }
        }
    }

    // détection fin de balise
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("xml")) {
            inJournees = false;
        } else if (qName.equals("journee")) {
            journees.add(journee);
            inJournee = false;
        } else if (qName.equals("article")) {
            journee.getArticles().put(nom.toString(), new Integer(nombre.toString()));
            journee.setDate(date);
            buffer = null;
            inArticle = false;
        } else if (qName.equals("nom")) {
            nom = new StringBuffer(buffer.toString());
            buffer = null;
            inNom = false;
        } else if (qName.equals("nombre")) {
            nombre = new StringBuffer(buffer.toString());
            buffer = null;
            inNombre = false;
        } else if (qName.equals("date")) {
            try {
                date = new Date(buffer.toString());
            } catch (InvalidDateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            buffer = null;
            inNombre = false;
        } else {
            // erreur, on peut lever une exception
            throw new SAXException("Balise " + qName + " inconnue.");
        }
    }

    // détection de caractères
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String lecture = new String(ch, start, length);
        if (buffer != null) {
            buffer.append(lecture);
        }
    }

    // début du parsing
    public void startDocument() throws SAXException {
    }

    // fin du parsing
    public void endDocument() throws SAXException {
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }

    public Journee getJournee() {
        return journee;
    }

    public void setJournee(Journee journee) {
        this.journee = journee;
    }

    public boolean isInJournees() {
        return inJournees;
    }

    public void setInJournees(boolean inJournees) {
        this.inJournees = inJournees;
    }

    public boolean isInJournee() {
        return inJournee;
    }

    public void setInJournee(boolean inJournee) {
        this.inJournee = inJournee;
    }

    public boolean isInArticle() {
        return inArticle;
    }

    public void setInArticle(boolean inArticle) {
        this.inArticle = inArticle;
    }

    public boolean isInNom() {
        return inNom;
    }

    public void setInNom(boolean inNom) {
        this.inNom = inNom;
    }

    public boolean isInNombre() {
        return inNombre;
    }

    public void setInNombre(boolean inNombre) {
        this.inNombre = inNombre;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
