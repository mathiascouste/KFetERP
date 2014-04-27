package view.commande;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CommandeZone extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 600;
	
	public CommandeZone() {
		JScrollPane commandeScrollPane;
		CommandePanel commandePanel;
		JourneePanel journeePanel;
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		commandePanel = new CommandePanel();
		journeePanel = new JourneePanel();
		commandeScrollPane = new JScrollPane(commandePanel);
		commandeScrollPane.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(commandeScrollPane);
		this.add(journeePanel);
	}
}
