package view.commande;

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
    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int MENU_HEIGHT = 250;
    private static final int PLAT_HEIGHT = 450;

    public ButtonZone() {

	ProduitButtonContainer menuContainer;
	ProduitButtonContainer platContainer;
	JLabel menuLabel;
	JLabel platLabel;
	JButton validerButton;
	JScrollPane menuScrollPane;
	JScrollPane platScrollPane;

	setPreferredSize(new Dimension(WIDTH, HEIGHT));
	menuContainer = new ProduitButtonContainer();
	platContainer = new ProduitButtonContainer();
	menuContainer.loadFromXml("./data/menu.xml");
	platContainer.loadFromXml("./data/plat.xml");
	menuLabel = new JLabel("Menus :");
	platLabel = new JLabel("Plats :");
	validerButton = new JButton("VALIDER LA COMMANDE");
	validerButton.addActionListener(new ValiderButtonListener());

	menuScrollPane = new JScrollPane(menuContainer);
	menuScrollPane.setPreferredSize(new Dimension(WIDTH, MENU_HEIGHT));
	platScrollPane = new JScrollPane(platContainer);
	platScrollPane.setPreferredSize(new Dimension(WIDTH, PLAT_HEIGHT));

	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

	this.add(menuLabel);
	this.add(menuScrollPane);
	this.add(platLabel);
	this.add(platScrollPane);
	this.add(validerButton);
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
