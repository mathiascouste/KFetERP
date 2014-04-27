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

public class JourneePanel extends JPanel implements KPanel {
    private static final long serialVersionUID = 1L;

    private Journee journee;
    private JLabel nCommandeLabel, totalLabel;

    public JourneePanel() {
	JLabel journeeLabel;
	JButton valideJournee;

	Commander.getInstance().addSubscriber(this);

	this.journee = new Journee();
	journeeLabel = new JLabel("Recap journee :");
	this.nCommandeLabel = new JLabel("Nombre de Commande : 0");
	this.totalLabel = new JLabel("0 €");
	valideJournee = new JButton("Valider journée");
	valideJournee.addActionListener(new ValideJourneeListener());

	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

	this.add(journeeLabel);
	this.add(this.nCommandeLabel);
	this.add(this.totalLabel);
	this.add(valideJournee);
    }

    public void refresh() {
	this.nCommandeLabel.setText("Nombre de Commande : "
		+ this.journee.getNombreCommande());
	this.totalLabel.setText("Gain total : "
		+ this.journee.getNombreCommande());
	this.totalLabel
		.setText("Gain total : " + this.journee.getSommeTotale());

	this.repaint();
    }

    public void addCommande(Commande commande) {
	this.journee.addCommande(commande);
	this.refresh();
    }

    @Override
    public void readMessage(String message, Object object) {
	if (message.equals("validerCommande") && object != null) {
	    this.addCommande((Commande) object);
	}
	if (message.equals("validerjournee") && object == null) {
	    this.journee.saveJournee();
	    KFet.getInstance().addJournee(this.journee);
	    this.journee = new Journee();
	}
    }

    @Override
    public void sendMessage() {
	// TODO Auto-generated method stub
    }

    private class ValideJourneeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    Commander.getInstance().broadcastMessage("validerjournee", null);
	    Commander.getInstance().broadcastMessage("panel=menu", null);
	}

    }
}
