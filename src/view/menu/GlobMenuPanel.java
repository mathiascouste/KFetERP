package view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class GlobMenuPanel extends JPanel { // 1000 x 600
	JLabel picLabel;
	JPanel center,bottom;
	JButton commande, stock, tresorerie, achatvente;
	JButton transf, help, print,recap,quitter;
	JLabel bottomText;
	
	public GlobMenuPanel() {
		// Picture
		this.picLabel = new JLabel(new ImageIcon(ImageLoader.getImageLoader("global").getImage("logo")));
		
		// Center Panel
		this.center = new JPanel();
		this.center.setLayout(new GridLayout(2,0));
		this.center.setSize(1000,300);
		
		this.commande = new JButton("COMMANDES");
		this.stock = new JButton("STOCK");
		this.tresorerie = new JButton("TRESORERIE");
		this.achatvente = new JButton("ACHAT/VENTE");
		
		this.commande.addActionListener(new MenuListener(0));

		this.center.add(this.commande);
		this.center.add(this.achatvente);
		this.center.add(this.stock);
		this.center.add(this.tresorerie);
		
		// Bottom Panel
		
		this.bottom = new JPanel();
		this.bottom.setLayout(new BoxLayout(this.bottom,BoxLayout.LINE_AXIS));
		this.center.setSize(1000,100);

		this.transf = new JButton(new ImageIcon(ImageLoader.getImageLoader("global").getImage("sync")));
		this.help = new JButton(new ImageIcon(ImageLoader.getImageLoader("global").getImage("help")));
		this.print = new JButton(new ImageIcon(ImageLoader.getImageLoader("global").getImage("print")));

		this.bottomText = new JLabel("© Mathias Cousté");
		
		this.recap = new JButton("RECAP");
		this.quitter = new JButton("QUITTER");

		this.transf.addActionListener(new MenuListener(2));
		this.quitter.addActionListener(new MenuListener(3));

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
		int type;
		public MenuListener(int type) {
			this.type = type;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(this.type) {
			case 0:
				System.out.println("test");
				Commander.getInstance().broadcastMessage("panel=commande", null);
				break;
			case 1:
				Commander.getInstance().broadcastMessage("panel=comptes", null);
				break;
			case 2:
				SyncFrame sf = SyncFrame.getInstance();
				sf.setVisible(true);
				//Commander.getInstance().broadcastMessage("panel=tranf", null);
				break;
			case 3:
				Commander.getInstance().broadcastMessage("programQUIT", null);
				break;
			default:
				break;
			}
		}
	}
}