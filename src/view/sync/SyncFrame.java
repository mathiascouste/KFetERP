package view.sync;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.KFet;

import tools.ImageLoader;

public class SyncFrame extends JFrame {
	private static SyncFrame instance;
	
	public static SyncFrame getInstance() {
		if(instance==null) instance = new SyncFrame();
		return instance;
	}
	
	private JCheckBox commandeCB, tresorCB, achatVenteCB, stockCB;
	private JButton upButton, downButton;
	private JLabel title, informations;
	private JPanel buttonsPan, cBPan;
	
	private SyncFrame() {
		this.setSize(new Dimension(300,200));

		this.buttonsPan = new JPanel();
		this.buttonsPan.setLayout(new BoxLayout(this.buttonsPan,BoxLayout.LINE_AXIS));
		this.cBPan = new JPanel();
		this.cBPan.setLayout(new BoxLayout(this.cBPan,BoxLayout.PAGE_AXIS));

		this.commandeCB = new JCheckBox("Commandes");
		this.tresorCB = new JCheckBox("Tresorerie");
		this.achatVenteCB = new JCheckBox("Achats & ventes");
		this.stockCB = new JCheckBox("Stocks");
		
		
		this.upButton = new JButton(new ImageIcon(ImageLoader.getImageLoader("global").getImage("flecheup")));
		this.downButton = new JButton(new ImageIcon(ImageLoader.getImageLoader("global").getImage("flechedown")));

		this.upButton.addActionListener(new syncActionListener("up",this));
		this.downButton.addActionListener(new syncActionListener("down",this));
		
		this.title = new JLabel("Synchronisation");
		this.informations = new JLabel("");
		
		this.setLayout(new BorderLayout());

		this.add(this.title,BorderLayout.NORTH);
		this.add(this.buttonsPan,BorderLayout.CENTER);
		this.buttonsPan.add(this.upButton);
		this.buttonsPan.add(this.downButton);
		this.add(this.informations,BorderLayout.SOUTH);
		
		this.pack();
	}
	
	public class syncActionListener implements ActionListener {
		private String ac;
		private SyncFrame sf;
		public syncActionListener(String ac,SyncFrame sf) {
			this.ac = ac;
			this.sf = sf;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(this.ac.equals("up")) {
				KFet.loadKFet(sf);
			}
			if(this.ac.equals("down")) {
				KFet.saveKFet(sf);
			}
		}
		
	}
}
