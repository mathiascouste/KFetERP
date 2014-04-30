package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.stock.Item;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.handlers.JourneesHandler;
import tools.handlers.StockHandler;

public class Journees {
    private static final String PATH = "./date/journees.data";
    private List<Journee> journees;
    
    public Journees() {
        this.journees = new ArrayList<Journee>();
    }

    public void loadFromXml() {
        SAXParserFactory fabrique = SAXParserFactory.newInstance();
        SAXParser parseur;
        try {
            parseur = fabrique.newSAXParser();
            File fichier = new File(PATH);
            DefaultHandler gestionnaire = new JourneesHandler();
            parseur.parse(fichier, gestionnaire);

                journees.clear();

                for (Journee journee : ((JourneesHandler) gestionnaire).getJournees()) {
                    journees.add(journee);
                }

            } catch (ParserConfigurationException e1) {
            } catch (SAXException e1) {
            } catch (IOException e) {
        }
        }

    public void add(Journee journee) {
        this.journees.add(journee);
    }

}
