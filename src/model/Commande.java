package model;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private List<Article> articleList;
    private double valeur;

    public Commande() {
        this.valeur = 0;
        this.articleList = new ArrayList<Article>();
    }

    public void add(Article article) {
        this.valeur += new Double(article.getPrice()).doubleValue();
        this.articleList.add(article);
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public void free() {
        this.articleList.clear();
        this.valeur = 0;

    }

    public boolean isEmpty() {
        return this.articleList.isEmpty();
    }
}
