package tools.handlers;

import java.util.LinkedList;
import java.util.List;

import model.stock.Item;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StockHandler extends DefaultHandler {
    // résultats de notre parsing
    private List<Item> stocks;
    private Item item;
    // flags nous indiquant la position du parseur
    private boolean inStock, inItem, inIntitule, inQuantiteMarch, inPrixMarch,
            inNbrMarch, inNbrHorsMarch;
    // buffer nous permettant de récupérer les données
    private StringBuffer buffer;

    // simple constructeur
    public StockHandler() {
        super();
    }

    // détection d'ouverture de balise
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (qName.equals("xml")) {
            stocks = new LinkedList<Item>();
            inStock = true;
        } else if (qName.equals("item")) {
            item = new Item();
            inItem = true;
        } else {
            buffer = new StringBuffer();
            if (qName.equals("intitule")) {
                inIntitule = true;
            } else if (qName.equals("prixMarch")) {
                inPrixMarch = true;
            } else if (qName.equals("quantiteMarch")) {
                inQuantiteMarch = true;
            } else if (qName.equals("nbrMarch")) {
                inNbrMarch = true;
            } else if (qName.equals("nbrHorsMarch")) {
                inNbrHorsMarch = true;
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
            inStock = false;
        } else if (qName.equals("item")) {
            stocks.add(item);
            inItem = false;
        } else if (qName.equals("intitule")) {
            item.setIntitule(buffer.toString());
            buffer = null;
            inIntitule = false;
        } else if (qName.equals("quantiteMarch")) {
            item.setQuantiteMarch(Integer.valueOf(buffer.toString()));
            buffer = null;
            inQuantiteMarch = false;
        } else if (qName.equals("prixMarch")) {
            item.setPrix(Double.valueOf(buffer.toString()));
            buffer = null;
            inPrixMarch = false;
        } else if (qName.equals("nbrMarch")) {
            item.setNbrMarch(Integer.valueOf(buffer.toString()));
            buffer = null;
            inNbrMarch = false;
        } else if (qName.equals("nbrHorsMarch")) {
            item.setNbrHorsMarch(Integer.valueOf(buffer.toString()));
            buffer = null;
            inNbrHorsMarch = false;
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

    public List<Item> getStocks() {
        return stocks;
    }

    public void setStocks(List<Item> stocks) {
        this.stocks = stocks;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isInItem() {
        return inItem;
    }

    public void setInItem(boolean inItem) {
        this.inItem = inItem;
    }

    public boolean isInIntitule() {
        return inIntitule;
    }

    public void setInIntitule(boolean inIntitule) {
        this.inIntitule = inIntitule;
    }

    public boolean isInQuantiteMarch() {
        return inQuantiteMarch;
    }

    public void setInQuantiteMarch(boolean inQuantiteMarch) {
        this.inQuantiteMarch = inQuantiteMarch;
    }

    public boolean isInPrixMarch() {
        return inPrixMarch;
    }

    public void setInPrixMarch(boolean inPrixMarch) {
        this.inPrixMarch = inPrixMarch;
    }

    public boolean isInNbrMarch() {
        return inNbrMarch;
    }

    public void setInNbrMarch(boolean inNbrMarch) {
        this.inNbrMarch = inNbrMarch;
    }

    public boolean isInNbrHorsMarch() {
        return inNbrHorsMarch;
    }

    public void setInNbrHorsMarch(boolean inNbrHorsMarch) {
        this.inNbrHorsMarch = inNbrHorsMarch;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
