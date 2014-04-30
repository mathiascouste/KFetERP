package model.sync;

import model.KFet;

public abstract class Synchronize {
    public static final int UP = 1;
    public static final int DOWN = 0;

    public static void sync(int way, boolean commande, boolean stock,
	    boolean achatVente, boolean tresorerie, boolean menuPlat) {
        
	if (way == UP) {
	    up(commande,stock,achatVente,tresorerie,menuPlat);
	} else {
	    down(commande,stock,achatVente,tresorerie,menuPlat);
	}
    }

    private static void down(boolean commande, boolean stock,
            boolean achatVente, boolean tresorerie, boolean menuPlat) {
        if (commande) {
            downCommande();
            KFet.getInstance().getJournees().loadFromXml();
            }
            if (stock) {
            downStock();
            KFet.getInstance().getStock().loadFromXml();
            }
            if (achatVente) {
            downAchatVente();
            }
            if (tresorerie) {
            downTresorerie();
            }
            if (menuPlat) {
            downMenuPlat();
            }
    }

    private static void up(boolean commande, boolean stock, boolean achatVente,
            boolean tresorerie, boolean menuPlat) {
        if (commande) {
            upCommande();
            }
            if (stock) {
            upStock();
            }
            if (achatVente) {
            upAchatVente();
            }
            if (tresorerie) {
            upTresorerie();
            }
            if (menuPlat) {
            upMenuPlat();
            }
    }

    private static void downMenuPlat() {
    }

    private static void upMenuPlat() {
    }

    private static void downTresorerie() {
    }

    private static void downAchatVente() {
    }

    private static void downStock() {
    }

    private static void downCommande() {
    }

    private static void upTresorerie() {
    }

    private static void upAchatVente() {
    }

    private static void upStock() {
    }

    private static void upCommande() {
    }
}
