package view.commande;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Article;

import tools.Commander;
import tools.ImageLoader;
import view.interfaces.KPanel;

public class ProduitButton extends JPanel implements KPanel{
	// Data
	private Article article;
	private String name,imgName,price;
	
	// View
	private JLabel nameP, priceP;
	private JButton button;

	
	public ProduitButton(String name, String imgName, String price) {
		this(new Article(name,imgName,price));
	}
	
	public ProduitButton(Article article) {
		Commander.getInstance().addSubscriber(this);
		
		this.setArticle(article);
		this.name = article.getName();
		this.imgName = article.getImgName();
		this.price = article.getPrice();
		
		this.init();
	}
	
	
	private void init() {
		this.setBackground(Color.white);
		this.nameP = new JLabel(name);
		this.button = new JButton(new ImageIcon(ImageLoader.getImageLoader("buttons").getImage(imgName)));
		this.button.addActionListener(new ProduitButtonListener(this));
		this.priceP = new JLabel(price);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.add(this.nameP);
		this.add(this.button);
		this.add(this.priceP);
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	private class ProduitButtonListener implements ActionListener {
		private ProduitButton pB;
		public ProduitButtonListener(ProduitButton pb) {
			this.pB = pb;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pB.sendMessage();
		}
	}

	@Override
	public void readMessage(String message, Object object) {
	}

	@Override
	public void sendMessage() {
		Commander.getInstance().broadcastMessage("addArticleToCommande", this.article);
	}
}
