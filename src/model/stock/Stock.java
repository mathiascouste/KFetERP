package model.stock;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.Article;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.handlers.ArticleHandler;
import tools.handlers.StockHandler;
import view.commande.ProduitButton;

public class Stock {
	private List<Item> stocks;
	private final String path = "./data/stock.xml";
	
	public Stock() {
		this.stocks = new ArrayList<Item>();
	}
	
	public void loadFromXml() {
		SAXParserFactory fabrique = SAXParserFactory.newInstance();
		SAXParser parseur;
		try {
			parseur = fabrique.newSAXParser();
			File fichier = new File(path);
			DefaultHandler gestionnaire = new StockHandler();
			parseur.parse(fichier, gestionnaire);
			
			stocks.clear();
			
			for(Item item : ((StockHandler) gestionnaire).getStocks()) {
				stocks.add(item);
			}
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String toRet = "Stock\n";
		for(Item item : stocks) {
			toRet += item + "\n";
		}
		
		return toRet;
	}

	public List<Item> getStocks() {
		return stocks;
	}

	public void setStocks(List<Item> stocks) {
		this.stocks = stocks;
	}

	public String getPath() {
		return path;
	}
}
