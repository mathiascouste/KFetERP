package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.time.Date;
import model.time.InvalidDateException;

public class Journee {
    private static final int MAXLENGHT = 8;

    private int nombreCommande;
    private double sommeTotale;
    private List<Commande> commandes;
    private Map<String, Integer> articles;
    private Date date;

    public Journee() {
        this.nombreCommande = 0;
        this.sommeTotale = 0;
        this.commandes = new ArrayList<Commande>();
        this.articles = new HashMap<String, Integer>();
        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = new Date(dateFormat.format(c.getTime()));
        } catch (InvalidDateException e) {
        }        
    }
    
    public void toXml() {
        StringBuilder s = new StringBuilder();
        s.append("<journee id=\"0\">\n");
        s.append("<date>");
        s.append(date.toString());
        s.append("</date>\n");
        s.append("<nombreCommande>");
        s.append(nombreCommande);
        s.append("</nombreCommande>\n");
        s.append("<sommeTotale>");
        s.append(sommeTotale);
        s.append("</sommeTotale>\n");
        for(Entry<String, Integer> entry : articles.entrySet()) {
            String a = entry.getKey();
            Integer valeur = entry.getValue();
            s.append("<");
            s.append(entry.getKey());
            s.append(">");
        }

    }

    public void addCommande(Commande commande) {
        this.nombreCommande++;
        this.sommeTotale += commande.getValeur();
        this.commandes.add(commande);
        this.addArticles(commande);
    }

    private void addArticles(Commande commande) {
        for (Article a : commande.getArticleList()) {
            if (this.articles.containsKey(a.toString())) {
                Integer i = this.articles.get(a);
                i++;
                this.articles.put(a.getName(), i);
            } else {
                this.articles.put(a.getName(), 1);
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

    public void saveJournee() {
        String path = "./save/" + date.getDay() + "_" + (date.getMonth()) + "_"
                + (date.getYear()) + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(this.toString());

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioe) {
        }
    }

    public String toString() {
        String toRet = "";
        toRet += "##########    Recapitulatif journée      ##########\n";
        toRet += "Date : " + date.getDay() + "/" + (date.getMonth()) + "/"
                + (date.getYear()) + "\n";
        toRet += "Nombre de commande : " + this.nombreCommande + "\n";
        toRet += "Chiffre de la journée : " + this.sommeTotale + "\n";
        toRet += "-----------------Articles-----------------\n";
        for (java.util.Map.Entry<String, Integer> entry : this.articles
                .entrySet()) {
            String cle = entry.getKey();
            int valeur = entry.getValue().intValue();
            toRet += "\t" + cle + "\t";
            if (cle.length() < MAXLENGHT) {
                toRet += "\t";
            }
            toRet += ":\t" + valeur + "\n";
        }
        toRet += "-----------------Articles-----------------\n";
        toRet += "##########    Recapitulatif journée      ##########\n";
        return toRet;
    }

    public Map<String, Integer> getArticles() {
        return articles;
    }

    public void setArticles(Map<String, Integer> articles) {
        this.articles = articles;
    }

    public static int getMaxlenght() {
        return MAXLENGHT;
    }
}
