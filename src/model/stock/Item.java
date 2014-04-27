package model.stock;

public class Item {
    private String intitule;
    private double prix;
    private int quantiteMarch;
    private int nbrMarch;
    private int nbrHorsMarch;
    private double valeur;

    public Item() {
	this("nouveau produit", 0.0, 0);
    }

    public Item(String intitule, double prix, int quantiteMarch) {
	this.intitule = intitule;
	this.prix = prix;
	this.quantiteMarch = quantiteMarch;
    }

    private void calculate() {
	double prixUni = this.prix / this.quantiteMarch;
	this.valeur = prixUni
		* (this.quantiteMarch * this.nbrMarch + this.nbrHorsMarch);
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
	this.calculate();
    }

    public int getQuantiteMarch() {
	return quantiteMarch;
    }

    public void setQuantiteMarch(int quantiteMarch) {
	this.quantiteMarch = quantiteMarch;
	this.calculate();
    }

    public int getNbrMarch() {
	return nbrMarch;
    }

    public void setNbrMarch(int nbrMarch) {
	this.nbrMarch = nbrMarch;
	this.calculate();
    }

    public int getNbrHorsMarch() {
	return nbrHorsMarch;
    }

    public void setNbrHorsMarch(int nbrHorsMarch) {
	this.nbrHorsMarch = nbrHorsMarch;
	this.calculate();
    }

    public double getValeur() {
	return valeur;
    }

    public void setValeur(double valeur) {
	this.valeur = valeur;
    }

    public String toString() {
	String toRet = "";
	toRet += this.intitule;
	toRet += this.prix;
	toRet += this.quantiteMarch;
	toRet += this.nbrMarch;
	toRet += this.nbrHorsMarch;
	toRet += this.valeur;
	return toRet;
    }
}
