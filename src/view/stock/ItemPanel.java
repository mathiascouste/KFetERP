package view.stock;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.stock.Item;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int MAX_CHAR = 10;
    private static final int MAX_CHAR_2 = 14;
    private static final int MAX_GRID_COLS = 6;

    private Item item;
    private JTextField nbrMarch, nbrHorsMarch;
    private JLabel labelIntitule, labelPrix, labelQteMarch, labelValeur;

    private DecimalFormat df;

    public ItemPanel(Item item) {
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        df = new DecimalFormat("0.00");
        df.setMinimumFractionDigits(2); // nb de chiffres apres la virgule
        this.item = item;
        this.nbrMarch = new JTextField(String.valueOf(item.getNbrMarch()));
        this.nbrMarch.setHorizontalAlignment(JTextField.CENTER);
        this.nbrHorsMarch = new JTextField(String.valueOf(item
                .getNbrHorsMarch()));
        this.nbrHorsMarch.setHorizontalAlignment(JTextField.CENTER);
        String lblStr = item.getIntitule();
        if (lblStr.length() > MAX_CHAR) {
            lblStr = lblStr.substring(0, MAX_CHAR);
            lblStr += "...";
        } else {
            for (int i = lblStr.length(); i < MAX_CHAR_2; i++) {
                lblStr += " ";
            }
        }
        this.labelIntitule = new JLabel(lblStr, JLabel.CENTER);

        this.labelPrix = new JLabel(String.valueOf(item.getPrix()),
                JLabel.CENTER);
        this.labelQteMarch = new JLabel(
                String.valueOf(item.getQuantiteMarch()), JLabel.CENTER);
        this.labelValeur = new JLabel(df.format(item.getValeur()),
                JLabel.CENTER);
        this.nbrMarch.addKeyListener(new ClavierListener());
        this.nbrHorsMarch.addKeyListener(new ClavierListener());
        this.setLayout(new GridLayout(1, MAX_GRID_COLS));
        this.add(labelIntitule);
        this.add(labelPrix);
        this.add(labelQteMarch);
        this.add(nbrMarch);
        this.add(nbrHorsMarch);
        this.add(labelValeur);
    }

    public class ClavierListener implements KeyListener {

        public ClavierListener() {

        }

        @Override
        public void keyPressed(KeyEvent event) {

        }

        @Override
        public void keyReleased(KeyEvent event) {
            int nbMarch = 0;
            int nbHorsMarch = 0;
            if (!isNumeric(nbrMarch.getText())
                    || !isNumeric(nbrHorsMarch.getText())) {
                labelValeur.setText("0");
            } else {
                nbMarch = Integer.parseInt(nbrMarch.getText());
                nbHorsMarch = Integer.parseInt(nbrHorsMarch.getText());
                item.setNbrMarch(nbMarch);
                item.setNbrHorsMarch(nbHorsMarch);
                Double valeurPaquetPlein = item.getPrix() * nbMarch;
                Double valeurPaquetEntame = nbHorsMarch * item.getPrix()
                        / item.getQuantiteMarch();
                Double calcul = valeurPaquetPlein + valeurPaquetEntame;
                labelValeur.setText(String.valueOf(df.format(calcul)));
            }
        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        // Retourne true si le paramètre est numérique, false dans le cas
        // contraire
        private boolean isNumeric(String s) {
            try {
                Integer.parseInt(String.valueOf(s));
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public JTextField getNbrMarch() {
        return nbrMarch;
    }

    public void setNbrMarch(JTextField nbrMarch) {
        this.nbrMarch = nbrMarch;
    }

    public JTextField getNbrHorsMarch() {
        return nbrHorsMarch;
    }

    public void setNbrHorsMarch(JTextField nbrHorsMarch) {
        this.nbrHorsMarch = nbrHorsMarch;
    }

    public JLabel getLabelIntitule() {
        return labelIntitule;
    }

    public void setLabelIntitule(JLabel labelIntitule) {
        this.labelIntitule = labelIntitule;
    }

    public JLabel getLabelPrix() {
        return labelPrix;
    }

    public void setLabelPrix(JLabel labelPrix) {
        this.labelPrix = labelPrix;
    }

    public JLabel getLabelQteMarch() {
        return labelQteMarch;
    }

    public void setLabelQteMarch(JLabel labelQteMarch) {
        this.labelQteMarch = labelQteMarch;
    }

    public JLabel getLabelValeur() {
        return labelValeur;
    }

    public void setLabelValeur(JLabel labelValeur) {
        this.labelValeur = labelValeur;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }
}
