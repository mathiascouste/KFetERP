package view.commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.Commander;
import view.interfaces.KPanel;

import model.Commande;
import model.Journee;
import model.KFet;

public class JourneePanel extends JPanel implements KPanel{
	private Journee journee;
	private JLabel journeeLabel, nCommandeLabel, totalLabel;
	private JButton valideJournee;
	
	public JourneePanel() {
		Commander.getInstance().addSubscriber(this);
		
		this.journee = new Journee();
		this.journeeLabel = new JLabel("Recap journee :");
		this.nCommandeLabel = new JLabel("Nombre de Commande : 0");
		this.totalLabel = new JLabel("0 €");
		this.valideJournee = new JButton("Valider journée");
		this.valideJournee.addActionListener(new valideJourneeListener());
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(journeeLabel);
		this.add(nCommandeLabel);
		this.add(totalLabel);
		this.add(valideJournee);
		
		this.refresh();
	}
	
	public void refresh() {
		this.nCommandeLabel.setText("Nombre de Commande : " + this.journee.getNombreCommande());
		this.totalLabel.setText("Gain total : " + this.journee.getNombreCommande());
		this.totalLabel.setText("Gain total : " + this.journee.getSommeTotale());
		
		this.repaint();
	}
	
	public void addCommande(Commande commande) {
		this.journee.addCommande(commande);
		this.refresh();
	}

	@Override
	public void readMessage(String message, Object object) {
		if(message.equals("validerCommande") && object!=null) {
			this.addCommande((Commande) object);
		}
		if(message.equals("validerjournee") && object==null) {
			this.journee.saveJournee();
			KFet.getInstance().addJournee(this.journee);
			this.journee = new Journee();
		}
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
	}
	
	private class valideJourneeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Commander.getInstance().broadcastMessage("validerjournee", null);
			Commander.getInstance().broadcastMessage("panel=menu", null);
		}
		
	}
}
