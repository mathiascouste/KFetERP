package model.sync;

public abstract class Synchronize {
    public static final int UP = 1;
    public static final int DOWN = 0;

    public static void sync(int way, boolean commande, boolean stock,
            boolean achatVente, boolean tresorerie, boolean menuPlat) {
        if (way == UP) {
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
        } else {
            if (commande) {
                downCommande();
            }
            if (stock) {
                downStock();
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
