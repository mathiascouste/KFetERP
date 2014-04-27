package view.commande;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GlobCommandePanel extends JPanel {
	ButtonZone bz;
	CommandeZone cz;

	public GlobCommandePanel() {
		this.init();
	}

	public void init() {
		this.setBackground(Color.white);
		ButtonZone bz = new ButtonZone();
		CommandeZone cz = new CommandeZone();
		this.setLayout(new BorderLayout());
		this.add(bz, BorderLayout.CENTER);
		this.add(cz, BorderLayout.EAST);
	}
}
