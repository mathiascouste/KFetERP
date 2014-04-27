package view.stock;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import model.stock.Item;
import model.stock.Stock;

public class StockPanel extends Panel {
	private Stock stock;
	
	public StockPanel(Stock stock) {
		super();
		this.stock = stock;
		init();
	}

	private void init() {
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		for(Item item : this.stock.getStocks()) {
			ItemPanel it = new ItemPanel(item);
			this.add(it);
		}
	}
	
	public static void main(String [] args) {
		Stock st = new Stock();
		st.loadFromXml();
		StockPanel sp = new StockPanel(st);
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(sp);
		f.pack();
		f.setVisible(true);
	}
}
