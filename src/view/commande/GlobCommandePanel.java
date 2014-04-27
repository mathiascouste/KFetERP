package view.commande;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class GlobCommandePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ButtonZone bz;
	private CommandeZone cz;

	public GlobCommandePanel() {
		this.setBackground(Color.white);
		this.bz = new ButtonZone();
		this.cz = new CommandeZone();
		this.setLayout(new BorderLayout());
		this.add(bz, BorderLayout.CENTER);
		this.add(cz, BorderLayout.EAST);
	}

	public ButtonZone getBz() {
		return bz;
	}

	public void setBz(ButtonZone bz) {
		this.bz = bz;
	}

	public CommandeZone getCz() {
		return cz;
	}

	public void setCz(CommandeZone cz) {
		this.cz = cz;
	}
}
