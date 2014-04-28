package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import view.sync.SyncFrame;

import model.stock.Stock;

public final class KFet implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static KFet instance;
    private List<Journee> journees;
    private Stock stock;

    private KFet() {
        this.journees = new ArrayList<Journee>();
        this.stock = new Stock();
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

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
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
