package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journee {
	private static final int FRSTYR = 1900;
	private static final int MAXLENGHT = 8;
	
	private int nombreCommande;
	private double sommeTotale;
	private List<Commande> commandes;
	private Map<Article, Integer> articles;
	
	public Journee() {
		this.nombreCommande = 0;
		this.sommeTotale = 0;
		this.commandes = new ArrayList<Commande>();
		this.articles = new HashMap<Article,Integer>();
	}
	
	public void addCommande(Commande commande) {
		this.nombreCommande++;
		this.sommeTotale += commande.getValeur();
		this.commandes.add(commande);
		this.addArticles(commande);
	}

	private void addArticles(Commande commande) {
		for(Article a : commande.getArticleList()) {
			if(this.articles.containsKey(a)) {
				Integer i = this.articles.get(a);
				i++;
				this.articles.put(a, i);
			} else {
				this.articles.put(a, 1);
			}
		}
	}

	public int getNombreCommande() {
		return nombreCommande;
	}

	public void setNombreCommande(int nombreCommande) {
		this.nombreCommande = nombreCommande;
	}

	public double getSommeTotale() {
		return sommeTotale;
	}

	public void setSommeTotale(double sommeTotale) {
		this.sommeTotale = sommeTotale;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@SuppressWarnings("deprecation")
	public void saveJournee() {
		Date d = new Date();
		String path = "./save/"+d.getDay()+"_"+(d.getMonth()+1)+"_"+(d.getYear()+FRSTYR)+".txt";
		try {
			FileWriter fileWriter = new FileWriter(path, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(this.toString());

			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException ioe) {
		}
	}
	
	@SuppressWarnings("deprecation")
	public String toString() {
		String toRet = "";
		Date d = new Date();
		toRet += "##########    Recapitulatif journée      ##########\n";
		toRet += "Date : " + d.getDate() + "/" + (d.getMonth()+1) + "/" + (d.getYear()+FRSTYR)+"\n";
		toRet += "Nombre de commande : " + this.nombreCommande + "\n";
		toRet += "Chiffre de la journée : " + this.sommeTotale + "\n";
		toRet += "-----------------Articles-----------------\n";
		for(java.util.Map.Entry<Article, Integer> entry : this.articles.entrySet()) {
		    Article cle = entry.getKey();
		    int valeur = entry.getValue().intValue();
		    toRet += "\t"+cle.getName()+"\t";
		    if(cle.getName().length() < MAXLENGHT) {
		    	toRet += "\t";
		    }
		    toRet += ":\t" + valeur + "\n";
		}
		toRet += "-----------------Articles-----------------\n";
		toRet += "##########    Recapitulatif journée      ##########\n";
		return toRet;
	}
}
