package view.stock;

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
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT_TITRE = 50;
	private static final int HEIGHT_SCROLL = 400;
	
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
		
		this.titre.setSize(WIDTH,HEIGHT_TITRE);
		
		this.stockPanel = new StockPanel(this.stock);
		
		this.sP = new JScrollPane(stockPanel);
		this.sP.setSize(WIDTH,HEIGHT_SCROLL);
		
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
		int winWidth = 1000;
		int winHeight = 600;
		Stock st = new Stock();
		st.loadFromXml();
		GlobStockPanel sp = new GlobStockPanel(st);
		
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(sp);
		f.setSize(winWidth,winHeight);
		f.pack();
		f.setVisible(true);
	}
	
	public class QuitListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Commander.getInstance().broadcastMessage("panel=menu", null);
		}
		
	}

	public JLabel getTitre() {
		return titre;
	}

	public void setTitre(JLabel titre) {
		this.titre = titre;
	}

	public JScrollPane getsP() {
		return sP;
	}

	public void setsP(JScrollPane sP) {
		this.sP = sP;
	}

	public StockPanel getStockPanel() {
		return stockPanel;
	}

	public void setStockPanel(StockPanel stockPanel) {
		this.stockPanel = stockPanel;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public AddItemPanel getAddItemPanel() {
		return addItemPanel;
	}

	public void setAddItemPanel(AddItemPanel addItemPanel) {
		this.addItemPanel = addItemPanel;
	}

	public JButton getSaveNquit() {
		return saveNquit;
	}

	public void setSaveNquit(JButton saveNquit) {
		this.saveNquit = saveNquit;
	}

	public JButton getQuit() {
		return quit;
	}

	public void setQuit(JButton quit) {
		this.quit = quit;
	}
}
