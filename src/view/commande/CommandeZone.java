package view.commande;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CommandeZone extends JPanel {
	private JScrollPane commandeScrollPane;
	private CommandePanel commandePanel;
	private JourneePanel journeePanel;
	
	public CommandeZone() {
		this.setPreferredSize(new Dimension(400,600));

		this.commandePanel = new CommandePanel();
		this.journeePanel = new JourneePanel();
		this.commandeScrollPane = new JScrollPane(this.commandePanel);
		this.commandeScrollPane.setPreferredSize(new Dimension(400,400));

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(this.commandeScrollPane);
		this.add(this.journeePanel);
	}
}
