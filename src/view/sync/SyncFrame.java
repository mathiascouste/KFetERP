package view.sync;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.sync.Synchronize;

public final class SyncFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;
	
	private static SyncFrame instance;
	
	public static SyncFrame getInstance() {
		if(instance==null) {
			instance = new SyncFrame();
		}
		return instance;
	}
	
	private JCheckBox commandeCB, tresorCB, achatVenteCB, stockCB, menuPlatCB;
	private JButton upButton, downButton;
	private JLabel titre;
	private JPanel buttonsPan;
	
	private SyncFrame() {
		this.setSize(new Dimension(WIDTH,HEIGHT));

		this.buttonsPan = new JPanel();
		this.buttonsPan.setLayout(new BoxLayout(this.buttonsPan,BoxLayout.LINE_AXIS));

		this.commandeCB = new JCheckBox("Commandes");
		this.tresorCB = new JCheckBox("Tresorerie");
		this.achatVenteCB = new JCheckBox("Achats & ventes");
		this.stockCB = new JCheckBox("Stocks");
		this.menuPlatCB = new JCheckBox("Menu & Plat");
		
		
		this.upButton = new JButton("Synchro  vers  serveur");
		this.downButton = new JButton("Synchro depuis serveur");

		this.upButton.addActionListener(new SyncActionListener(Synchronize.UP,this));
		this.downButton.addActionListener(new SyncActionListener(Synchronize.DOWN,this));
		
		this.titre = new JLabel("Synchronisation");
		
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));

		this.add(this.titre);

		this.add(this.commandeCB);
		this.add(this.tresorCB);
		this.add(this.achatVenteCB);
		this.add(this.stockCB);
		this.add(this.menuPlatCB);

		this.add(this.buttonsPan);
		
		this.buttonsPan.add(this.upButton);
		this.buttonsPan.add(this.downButton);
		
		this.pack();
	}
	
	public class SyncActionListener implements ActionListener {
		private int way;
		private SyncFrame sf;
		public SyncActionListener(int way,SyncFrame sf) {
			this.way = way;
			this.sf = sf;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Synchronize.sync(way,
					sf.getCommandeCB().isSelected(),
					sf.getStockCB().isSelected(),
					sf.getAchatVenteCB().isSelected(),
					sf.getTresorCB().isSelected(),
					sf.getMenuPlatCB().isSelected()
				);
		}
		
	}

	public JCheckBox getCommandeCB() {
		return commandeCB;
	}

	public void setCommandeCB(JCheckBox commandeCB) {
		this.commandeCB = commandeCB;
	}

	public JCheckBox getTresorCB() {
		return tresorCB;
	}

	public void setTresorCB(JCheckBox tresorCB) {
		this.tresorCB = tresorCB;
	}

	public JCheckBox getAchatVenteCB() {
		return achatVenteCB;
	}

	public void setAchatVenteCB(JCheckBox achatVenteCB) {
		this.achatVenteCB = achatVenteCB;
	}

	public JCheckBox getStockCB() {
		return stockCB;
	}

	public void setStockCB(JCheckBox stockCB) {
		this.stockCB = stockCB;
	}

	public JCheckBox getMenuPlatCB() {
		return menuPlatCB;
	}

	public void setMenuPlatCB(JCheckBox menuPlatCB) {
		this.menuPlatCB = menuPlatCB;
	}

	public JButton getUpButton() {
		return upButton;
	}

	public void setUpButton(JButton upButton) {
		this.upButton = upButton;
	}

	public JButton getDownButton() {
		return downButton;
	}

	public void setDownButton(JButton downButton) {
		this.downButton = downButton;
	}

	public JLabel getTitre() {
		return titre;
	}

	public void setTitle(JLabel titre) {
		this.titre = titre;
	}

	public JPanel getButtonsPan() {
		return buttonsPan;
	}

	public void setButtonsPan(JPanel buttonsPan) {
		this.buttonsPan = buttonsPan;
	}
}
