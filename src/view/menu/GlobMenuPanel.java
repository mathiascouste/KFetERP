package view.menu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.Commander;
import tools.ImageLoader;
import view.sync.SyncFrame;

public class GlobMenuPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	private static final int HEIGHT_CENTER = 300;
	private static final int HEIGHT_BOTTOM = 100;
	
	private JLabel picLabel;
	private JPanel center,bottom;
	private JButton commande, stock, tresorerie, achatvente;
	private JButton transf, help, print,recap,quitter;
	private JLabel bottomText;
	
	private final ImageLoader imgL = ImageLoader.getImageLoader("global");
	
	public GlobMenuPanel() {
		this.setSize(WIDTH,HEIGHT);
		
		// Picture
		this.picLabel = new JLabel(new ImageIcon(imgL.getImage("logo")));
		
		// Center Panel
		this.center = new JPanel();
		this.center.setLayout(new GridLayout(2,0));
		this.center.setSize(WIDTH,HEIGHT_CENTER);
		
		this.commande = new JButton("COMMANDES");
		this.stock = new JButton("STOCK");
		this.tresorerie = new JButton("TRESORERIE");
		this.achatvente = new JButton("ACHAT/VENTE");

		this.commande.addActionListener(new MenuListener(MenuListener.COMMANDE));
		this.tresorerie.addActionListener(new MenuListener(MenuListener.COMPTE));
		this.stock.addActionListener(new MenuListener(MenuListener.STOCK));

		this.center.add(this.commande);
		this.center.add(this.achatvente);
		this.center.add(this.stock);
		this.center.add(this.tresorerie);
		
		// Bottom Panel
		
		this.bottom = new JPanel();
		this.bottom.setLayout(new BoxLayout(this.bottom,BoxLayout.LINE_AXIS));
		this.bottom.setSize(WIDTH,HEIGHT_BOTTOM);

		this.transf = new JButton(new ImageIcon(imgL.getImage("sync")));
		this.help = new JButton(new ImageIcon(imgL.getImage("help")));
		this.print = new JButton(new ImageIcon(imgL.getImage("print")));

		this.bottomText = new JLabel("© Mathias Cousté");
		
		this.recap = new JButton("RECAP");
		this.quitter = new JButton("QUITTER");

		this.transf.addActionListener(new MenuListener(MenuListener.SYNC));
		this.quitter.addActionListener(new MenuListener(MenuListener.QUITTER));

		this.bottom.add(this.transf);
		this.bottom.add(this.help);
		this.bottom.add(this.print);
		this.bottom.add(this.bottomText);
		this.bottom.add(this.recap);
		this.bottom.add(this.quitter);
		
		// Adding to panel
		this.setLayout(new BorderLayout());
		
		this.add(this.picLabel,BorderLayout.NORTH);
		this.add(this.center,BorderLayout.CENTER);
		this.add(this.bottom,BorderLayout.SOUTH);
	}
	
	private class MenuListener implements ActionListener {
		public static final int COMMANDE = 0;
		public static final int COMPTE = 1;
		public static final int SYNC = 2;
		public static final int QUITTER = 3;
		public static final int STOCK = 4;
		
		private int type;
		
		public MenuListener(int type) {
			this.type = type;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(this.type) {
			case 0:
				Commander.getInstance().broadcastMessage("panel=commande", null);
				break;
			case 1:
				Commander.getInstance().broadcastMessage("panel=comptes", null);
				break;
			case 2:
				SyncFrame sf = SyncFrame.getInstance();
				sf.setVisible(true);
				break;
			case 3:
				Commander.getInstance().broadcastMessage("programQUIT", null);
				break;
			case 4:
				Commander.getInstance().broadcastMessage("panel=stock", null);
				break;
			default:
				break;
			}
		}
	}

	public JLabel getPicLabel() {
		return picLabel;
	}

	public void setPicLabel(JLabel picLabel) {
		this.picLabel = picLabel;
	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}

	public JButton getCommande() {
		return commande;
	}

	public void setCommande(JButton commande) {
		this.commande = commande;
	}

	public JButton getStock() {
		return stock;
	}

	public void setStock(JButton stock) {
		this.stock = stock;
	}

	public JButton getTresorerie() {
		return tresorerie;
	}

	public void setTresorerie(JButton tresorerie) {
		this.tresorerie = tresorerie;
	}

	public JButton getAchatvente() {
		return achatvente;
	}

	public void setAchatvente(JButton achatvente) {
		this.achatvente = achatvente;
	}

	public JButton getTransf() {
		return transf;
	}

	public void setTransf(JButton transf) {
		this.transf = transf;
	}

	public JButton getHelp() {
		return help;
	}

	public void setHelp(JButton help) {
		this.help = help;
	}

	public JButton getPrint() {
		return print;
	}

	public void setPrint(JButton print) {
		this.print = print;
	}

	public JButton getRecap() {
		return recap;
	}

	public void setRecap(JButton recap) {
		this.recap = recap;
	}

	public JButton getQuitter() {
		return quitter;
	}

	public void setQuitter(JButton quitter) {
		this.quitter = quitter;
	}

	public JLabel getBottomText() {
		return bottomText;
	}

	public void setBottomText(JLabel bottomText) {
		this.bottomText = bottomText;
	}

	public ImageLoader getImgL() {
		return imgL;
	}
}