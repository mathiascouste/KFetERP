package view.stock;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tools.Commander;

import model.stock.Stock;

public class GlobStockPanel extends JPanel {
	private JLabel titre;
	private JScrollPane sP;
	private StockPanel stockPanel;
	private Stock stock;
	private AddItemPanel addItemPanel;
	private JButton saveNquit;
	private JButton quit;
	
	public GlobStockPanel(Stock stock) {		
		super();
		this.stock = stock;
		this.titre = new JLabel("STOCKS");
		
		this.titre.setSize(1000,50);
		
		this.stockPanel = new StockPanel(this.stock);
		
		this.sP = new JScrollPane(stockPanel);
		this.sP.setSize(1000,400);
		
		this.addItemPanel = new AddItemPanel(this.stock);

		this.saveNquit = new JButton("Sauver et Quitter");
		this.quit = new JButton("Quitter");
		this.quit.addActionListener(new QuitListner());
		
		init();
	}

	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(this.titre);
		this.add(sP);
		this.add(addItemPanel);
		this.add(saveNquit);
		this.add(quit);
	}

	public static void main(String [] args) {
		Stock st = new Stock();
		st.loadFromXml();
		GlobStockPanel sp = new GlobStockPanel(st);
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(sp);
		f.setSize(1000,600);
		f.pack();
		f.setVisible(true);
	}
	
	public class QuitListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Commander.getInstance().broadcastMessage("panel=menu", null);
		}
		
	}
}
