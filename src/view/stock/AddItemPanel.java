package view.stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.stock.Stock;

public class AddItemPanel extends JPanel{
	private JTextField intitule, prixMarch, quantMarch, nbrMarch, nbrHorsMarch;
	private JButton ajouter;
	
	private Stock stock;
	
	public AddItemPanel(Stock stock) {
		super();
		this.stock = stock;

		this.intitule = new JTextField("intitule");
		this.intitule.addFocusListener(new EmptyWhenFocusedListener(this.intitule));
		this.prixMarch = new JTextField("prixMarch");
		this.prixMarch.addFocusListener(new EmptyWhenFocusedListener(this.prixMarch));
		this.quantMarch = new JTextField("quantMarch");
		this.quantMarch.addFocusListener(new EmptyWhenFocusedListener(this.quantMarch));
		this.nbrMarch = new JTextField("nbrMarch");
		this.nbrMarch.addFocusListener(new EmptyWhenFocusedListener(this.nbrMarch));
		this.nbrHorsMarch = new JTextField("nbrHorsMarch");
		this.nbrHorsMarch.addFocusListener(new EmptyWhenFocusedListener(this.nbrHorsMarch));
		
		this.ajouter = new JButton("Ajouter");
		
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		this.add(this.intitule);
		this.add(this.prixMarch);
		this.add(this.quantMarch);
		this.add(this.nbrMarch);
		this.add(this.nbrHorsMarch);
		this.add(this.ajouter);
	}
	
	public class EmptyWhenFocusedListener implements FocusListener {
		private JTextField tf;
		
		public EmptyWhenFocusedListener(JTextField tf) {
			this.tf = tf;
		}

		@Override
		public void focusGained(FocusEvent arg0) {
			this.tf.setText("");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
		}
		
	}
}
