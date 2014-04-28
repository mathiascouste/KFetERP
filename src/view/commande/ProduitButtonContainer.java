package view.commande;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.Article;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import tools.handlers.ArticleHandler;

public class ProduitButtonContainer extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final int GRID_MAX_WIDTH = 4;
    private static final int GRID_MAX_HEIGHT = 0;

    public ProduitButtonContainer() {
        this.setBackground(Color.white);
    }

    public void loadFromXml(String path) {
        SAXParserFactory fabrique = SAXParserFactory.newInstance();
        SAXParser parseur;
        try {
            parseur = fabrique.newSAXParser();
            File fichier = new File(path);
            DefaultHandler gestionnaire = new ArticleHandler();
            parseur.parse(fichier, gestionnaire);

            this.setLayout(new GridLayout(GRID_MAX_HEIGHT, GRID_MAX_WIDTH));

            for (Article art : ((ArticleHandler) gestionnaire).getAnnuaire()) {
                this.add(new ProduitButton(art.getName(), art.getImgName(), art
                        .getPrice()));
            }

        } catch (ParserConfigurationException e1) {
        } catch (SAXException e1) {
        } catch (IOException e) {
        }
    }
}
