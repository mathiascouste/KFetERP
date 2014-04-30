package tools.handlers;

import java.util.LinkedList;
import java.util.List;

import model.Article;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ArticleHandler extends DefaultHandler {
    // résultats de notre parsing
    private List<Article> annuaire;
    private Article personne;
    // flags nous indiquant la position du parseur
    private boolean inAnnuaire, inPersonne, inNom, inPrenom, inAdresse;
    // buffer nous permettant de récupérer les données
    private StringBuffer buffer;

    // simple constructeur
    public ArticleHandler() {
        super();
    }

    // détection d'ouverture de balise
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("xml")) {
            annuaire = new LinkedList<Article>();
            inAnnuaire = true;
        } else if (qName.equals("item")) {
            personne = new Article();
            try {
                int id = Integer.parseInt(attributes.getValue("id"));
                personne.setId(id);
            } catch (Exception e) {
                // erreur, le contenu de id n'est pas un entier
                throw new SAXException(e);
            }
            inPersonne = true;
        } else {
            buffer = new StringBuffer();
            if (qName.equals("nom")) {
                inNom = true;
            } else if (qName.equals("prix")) {
                inPrenom = true;
            } else if (qName.equals("img")) {
                inAdresse = true;
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
            inAnnuaire = false;
        } else if (qName.equals("item")) {
            annuaire.add(personne);
            personne = null;
            inPersonne = false;
        } else if (qName.equals("nom")) {
            personne.setName(buffer.toString());
            buffer = null;
            inNom = false;
        } else if (qName.equals("prix")) {
            personne.setPrice(buffer.toString());
            buffer = null;
            inPrenom = false;
        } else if (qName.equals("img")) {
            personne.setImgName(buffer.toString());
            buffer = null;
            inAdresse = false;
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

    public List<Article> getAnnuaire() {
        return annuaire;
    }

    public void setAnnuaire(List<Article> annuaire) {
        this.annuaire = annuaire;
    }

    public Article getPersonne() {
        return personne;
    }

    public void setPersonne(Article personne) {
        this.personne = personne;
    }

    public boolean isInAnnuaire() {
        return inAnnuaire;
    }

    public void setInAnnuaire(boolean inAnnuaire) {
        this.inAnnuaire = inAnnuaire;
    }

    public boolean isInPersonne() {
        return inPersonne;
    }

    public void setInPersonne(boolean inPersonne) {
        this.inPersonne = inPersonne;
    }

    public boolean isInNom() {
        return inNom;
    }

    public void setInNom(boolean inNom) {
        this.inNom = inNom;
    }

    public boolean isInPrenom() {
        return inPrenom;
    }

    public void setInPrenom(boolean inPrenom) {
        this.inPrenom = inPrenom;
    }

    public boolean isInAdresse() {
        return inAdresse;
    }

    public void setInAdresse(boolean inAdresse) {
        this.inAdresse = inAdresse;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
