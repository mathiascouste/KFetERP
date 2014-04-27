package test;

import model.stock.Stock;

public abstract class ItemXmlTest {
    public static void main(String[] args) {
	Stock st = new Stock();
	st.loadFromXml();
    }
}
