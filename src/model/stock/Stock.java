package model.stock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.handlers.StockHandler;

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
		} catch (SAXException e1) {
		} catch (IOException e) {
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
