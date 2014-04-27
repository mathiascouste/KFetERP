package view.commande;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tools.Commander;

public class ButtonZone extends JPanel {
	private ProduitButtonContainer menuContainer;
	private ProduitButtonContainer platContainer;
	private JLabel menuLabel;
	private JLabel platLabel;
	private JButton validerButton;
	private JScrollPane menuScrollPane;
	private JScrollPane platScrollPane;
	
	public ButtonZone() {
		this.setPreferredSize(new Dimension(600,600));
		this.menuContainer = new ProduitButtonContainer();
		this.platContainer = new ProduitButtonContainer();
		this.menuContainer.loadFromXml("./data/menu.xml");
		this.platContainer.loadFromXml("./data/plat.xml");
		this.menuLabel = new JLabel("Menus :");
		this.platLabel = new JLabel("Plats :");
		this.validerButton = new JButton("VALIDER LA COMMANDE");
		this.validerButton.addActionListener(new ValiderButtonListener());
		
		this.menuScrollPane = new JScrollPane(this.menuContainer);
		this.menuScrollPane.setPreferredSize(new Dimension(600,250));
		this.platScrollPane = new JScrollPane(this.platContainer);
		this.platScrollPane.setPreferredSize(new Dimension(600,450));

		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		this.add(this.menuLabel);
		this.add(this.menuScrollPane);
		this.add(this.platLabel);
		this.add(this.platScrollPane);
		this.add(this.validerButton);
	}
	
	private class ValiderButtonListener implements ActionListener {
		public ValiderButtonListener() {
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Commander.getInstance().broadcastMessage("validerCommande", null);
		}
	}
}
