package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.handlers.StockHandler;
import view.sync.SyncFrame;

import model.stock.Item;
import model.stock.Stock;

public final class KFet implements Serializable {

    private static final long serialVersionUID = 1L;
    private static KFet instance;
    private Journees journees;
    private Stock stock;

    private KFet() {
        this.journees = new Journees();
        this.stock = new Stock();
    }
    
    public void loadFromXml() {
        this.stock.loadFromXml();
        this.journees.loadFromXml();
    }

    public static KFet getInstance() {
        if (instance == null) {
            instance = new KFet();
        }
        return instance;
    }

    public void addJournee(Journee journee) {
        this.journees.add(journee);
    }

    public String toString() {
        return "";
    }

    public static void loadKFet(SyncFrame f) {

    }

    public static void saveKFet(SyncFrame f) {

    }

    public Journees getJournees() {
        return journees;
    }

    public void setJournees(Journees journees) {
        this.journees = journees;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public static void setInstance(KFet instance) {
        KFet.instance = instance;
    }
}
