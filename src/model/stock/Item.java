package model.stock;

public class Item {
	private String intitule;
	private double prix;
	private int quantiteMarch;
	private int nbrMarch;
	private int nbrHorsMarch;
	private double valeur;
	
	public Item() {
		this("nouveau produit" ,0.0,0);
	}
	
	public Item(String intitule, double prix, int quantiteMarch) {
		this.intitule = intitule;
		this.prix = prix;
		this.quantiteMarch = quantiteMarch;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantiteMarch() {
		return quantiteMarch;
	}

	public void setQuantiteMarch(int quantiteMarch) {
		this.quantiteMarch = quantiteMarch;
	}

	public int getNbrMarch() {
		return nbrMarch;
	}

	public void setNbrMarch(int nbrMarch) {
		this.nbrMarch = nbrMarch;
	}

	public int getNbrHorsMarch() {
		return nbrHorsMarch;
	}

	public void setNbrHorsMarch(int nbrHorsMarch) {
		this.nbrHorsMarch = nbrHorsMarch;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
}
