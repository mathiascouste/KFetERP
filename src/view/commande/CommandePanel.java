package view.commande;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import tools.Commander;
import view.interfaces.KPanel;

import model.Article;
import model.Commande;

public class CommandePanel extends JPanel implements KPanel{
	private Commande commande;
	private JLabel commandeLabel,value;
	private JList list;
	private JButton freeButton;
	
	public CommandePanel() {
		Commander.getInstance().addSubscriber(this);
		this.commande = new Commande();
		this.commandeLabel = new JLabel("Commande :");
		this.value = new JLabel("Value :");
		this.list = new JList(this.commande.getArticleList().toArray());
		this.freeButton = new JButton("Vider");
		this.freeButton.addActionListener(new FreeButtonListener(this));
		
		this.refresh();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(commandeLabel);
		this.add(list);
		this.add(value);
		this.add(freeButton);
	}
	
	public void refresh() {
		this.value.setText("Value : " + this.commande.getValeur());
		this.list.setListData(this.commande.getArticleList().toArray());
		this.repaint();
	}
	
	public void addToCommande(Article article) {
		this.commande.add(article);
		this.refresh();
	}
	public Commande nextCommande() {
		Commande toRet = this.commande;
		this.commande = new Commande();
		this.refresh();
		return toRet;
	}

	@Override
	public void readMessage(String message, Object object) {
		if(message.equals("addArticleToCommande")) {
			Article article = (Article) object;
			this.addToCommande(article);
		}
		if(message.equals("validerCommande") && object == null) {
			if(!this.commande.isEmpty()) {
				Commander.getInstance().broadcastMessage(message, this.nextCommande());
			}
		}
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}
	
	private class FreeButtonListener implements ActionListener{
		CommandePanel commandePanel;
		public FreeButtonListener(CommandePanel commandePanel) {
			this.commandePanel = commandePanel;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.commandePanel.freeCommande();
		}
		
	}

	public void freeCommande() {
		this.commande.free();
		this.refresh();
	}
}
