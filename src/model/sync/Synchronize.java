package model.sync;

public class Synchronize {
	static public final int UP = 1;
	static public final int DOWN = 0;
	
	public static void sync(int way,
			boolean commande,
			boolean stock,
			boolean achatVente,
			boolean tresorerie,
			boolean menuPlat) {
		if(way == UP) {
			if(commande) upCommande();
			if(stock) upStock();
			if(achatVente) upAchatVente();
			if(tresorerie) upTresorerie();
			if(menuPlat) upMenuPlat();
		} else {
			if(commande) downCommande();
			if(stock) downStock();
			if(achatVente) downAchatVente();
			if(tresorerie) downTresorerie();
			if(menuPlat) downMenuPlat();
		}
	}

	private static void downMenuPlat() {
		System.out.println("downMenuPlat");
	}

	private static void upMenuPlat() {
		System.out.println("upMenuPlat");
	}

	private static void downTresorerie() {
		System.out.println("downTresorerie");
	}

	private static void downAchatVente() {
		System.out.println("downAchatVente");
	}

	private static void downStock() {
		System.out.println("downStock");
	}

	private static void downCommande() {
		System.out.println("downCommande");
	}

	private static void upTresorerie() {
		System.out.println("upTresorerie");
	}

	private static void upAchatVente() {
		System.out.println("upAchatVente");
	}

	private static void upStock() {
		System.out.println("upStock");
	}

	private static void upCommande() {
		System.out.println("upCommande");
	}
}
