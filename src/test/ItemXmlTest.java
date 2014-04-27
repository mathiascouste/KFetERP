package test;

import model.stock.Stock;

public class ItemXmlTest {	
	public static void main(String[] args) {
		Stock st = new Stock();
		st.loadFromXml();
		System.out.println(st);
	}
}
