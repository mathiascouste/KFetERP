package view.stock;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.stock.Item;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel {

    private Item item;
    private JTextField nbrMarch, nbrHorsMarch;
    private JLabel labelIntitule, labelPrix, labelQteMarch, labelValeur;

    DecimalFormat df;

    public ItemPanel(Item item) {
	df = new DecimalFormat("0.00");
	df.setMinimumFractionDigits(2); // nb de chiffres apres la virgule
	this.item = item;
	this.nbrMarch = new JTextField(String.valueOf(item.getNbrMarch()));
	this.nbrMarch.setHorizontalAlignment(JTextField.CENTER);
	this.nbrHorsMarch = new JTextField(String.valueOf(item
		.getNbrHorsMarch()));
	this.nbrHorsMarch.setHorizontalAlignment(JTextField.CENTER);
	this.labelIntitule = new JLabel(item.getIntitule(), JLabel.CENTER);
	this.labelPrix = new JLabel(String.valueOf(item.getPrix()),
		JLabel.CENTER);
	this.labelQteMarch = new JLabel(
		String.valueOf(item.getQuantiteMarch()), JLabel.CENTER);
	this.labelValeur = new JLabel(df.format(item.getValeur()),
		JLabel.CENTER);
	this.nbrMarch.addKeyListener(new ClavierListener());
	this.nbrHorsMarch.addKeyListener(new ClavierListener());
	this.setLayout(new GridLayout(1, 6));
	this.add(labelIntitule);
	this.add(labelPrix);
	this.add(labelQteMarch);
	this.add(nbrMarch);
	this.add(nbrHorsMarch);
	this.add(labelValeur);
    }

    public class ClavierListener implements KeyListener {

	public ClavierListener() {

	}

	@Override
	public void keyPressed(KeyEvent event) {

	}

	@Override
	public void keyReleased(KeyEvent event) {
	    int nbMarch = 0;
	    int nbHorsMarch = 0;
	    if (!isNumeric(nbrMarch.getText())
		    || !isNumeric(nbrHorsMarch.getText())) {
		labelValeur.setText("0");
		if (!isNumeric(nbrMarch.getText())) {
		    // nbrMarch.setText("");
		}
		if (!isNumeric(nbrHorsMarch.getText())) {
		    // nbrHorsMarch.setText("");
		}
	    } else {
		nbMarch = Integer.parseInt(nbrMarch.getText());
		nbHorsMarch = Integer.parseInt(nbrHorsMarch.getText());
		item.setNbrMarch(nbMarch);
		item.setNbrHorsMarch(nbHorsMarch);
		Double valeurPaquetPlein = item.getPrix() * nbMarch;
		Double valeurPaquetEntame = nbHorsMarch * item.getPrix()
			/ item.getQuantiteMarch();
		Double calcul = valeurPaquetPlein + valeurPaquetEntame;
		labelValeur.setText(String.valueOf(df.format(calcul)));
	    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	    // TODO Auto-generated method stub

	}

	// Retourne true si le paramètre est numérique, false dans le cas
	// contraire
	private boolean isNumeric(String s) {
	    try {
		Integer.parseInt(String.valueOf(s));
	    } catch (NumberFormatException e) {
		return false;
	    }
	    return true;
	}
    }

    // TODO Pour tester, à supprimer
    public static void main(String[] args) {
	Item item = new Item();
	item.setIntitule("Carotte");
	item.setNbrHorsMarch(0);
	item.setNbrMarch(10);
	item.setPrix(1.35);
	item.setQuantiteMarch(10);
	item.setValeur(13.5);
	JFrame frame = new JFrame("TEST ITEMPANEL");
	JPanel pane = new JPanel();
	pane.add(new ItemPanel(item));
	frame.setContentPane(pane);
	frame.pack(); // Adapte la fenêtre au contenu
	frame.setMinimumSize(new Dimension(250, 65));
	frame.setVisible(true);
	frame.setLocationRelativeTo(null); // Centre la fenêtre
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
