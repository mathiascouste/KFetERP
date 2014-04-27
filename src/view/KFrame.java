package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.KFet;

import tools.Commander;
import view.commande.GlobCommandePanel;
import view.interfaces.KPanel;
import view.menu.GlobMenuPanel;
import view.stock.GlobStockPanel;

public class KFrame extends JFrame implements KPanel {
    private static final long serialVersionUID = 1L;

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private GlobCommandePanel commandePanel;
    private GlobMenuPanel menuPanel;
    private GlobStockPanel stockPanel;

    public KFrame() {
	Commander.getInstance().addSubscriber(this);

	this.commandePanel = new GlobCommandePanel();
	this.menuPanel = new GlobMenuPanel();
	this.stockPanel = new GlobStockPanel(KFet.getInstance().getStock());

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(new Dimension(WIDTH, HEIGHT));

	this.getContentPane().add(this.menuPanel);

	this.setLocationRelativeTo(null);
    }

    @Override
    public void readMessage(String message, Object object) {
	if (message.equals("panel=commande") && object == null) {
	    this.getContentPane().removeAll();
	    this.getContentPane().add(this.commandePanel);
	    this.pack();
	} else if (message.equals("panel=menu") && object == null) {
	    this.getContentPane().removeAll();
	    this.getContentPane().add(this.menuPanel);
	    this.pack();
	} else if (message.equals("panel=stock") && object == null) {
	    this.getContentPane().removeAll();
	    this.getContentPane().add(this.stockPanel);
	    this.pack();
	} else if (message.equals("panel=comptes") && object == null) {

	} else if (message.equals("panel=transf") && object == null) {

	} else if (message.equals("programQUIT") && object == null) {
	    this.dispose();
	}
    }

    @Override
    public void sendMessage() {
	// TODO Auto-generated method stub

    }
}
