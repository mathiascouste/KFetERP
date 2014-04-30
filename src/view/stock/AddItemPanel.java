package view.stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.stock.Item;
import model.stock.Stock;

public class AddItemPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextField intitule, prixMarch, quantMarch, nbrMarch, nbrHorsMarch;
    private JButton ajouter;

    private Stock stock;

    public AddItemPanel(Stock stock) {
        super();
        this.stock = stock;

        this.intitule = new JTextField("intitule");
        this.intitule.addFocusListener(new EmptyWhenFocusedListener(
                this.intitule));
        this.prixMarch = new JTextField("prixMarch");
        this.prixMarch.addFocusListener(new EmptyWhenFocusedListener(
                this.prixMarch));
        this.quantMarch = new JTextField("quantMarch");
        this.quantMarch.addFocusListener(new EmptyWhenFocusedListener(
                this.quantMarch));
        this.nbrMarch = new JTextField("nbrMarch");
        this.nbrMarch.addFocusListener(new EmptyWhenFocusedListener(
                this.nbrMarch));
        this.nbrHorsMarch = new JTextField("nbrHorsMarch");
        this.nbrHorsMarch.addFocusListener(new EmptyWhenFocusedListener(
                this.nbrHorsMarch));

        this.ajouter = new JButton("Ajouter");
        this.ajouter.addActionListener(new AjouterListener(this));

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.add(this.intitule);
        this.add(this.prixMarch);
        this.add(this.quantMarch);
        this.add(this.nbrMarch);
        this.add(this.nbrHorsMarch);
        this.add(this.ajouter);
    }

    public class AjouterListener implements ActionListener {
        private AddItemPanel aip;

        public AjouterListener(AddItemPanel aip) {
            this.aip = aip;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            this.aip.ajouter();
        }
    }

    public class EmptyWhenFocusedListener implements FocusListener {
        private JTextField tf;

        public EmptyWhenFocusedListener(JTextField tf) {
            this.tf = tf;
        }

        @Override
        public void focusGained(FocusEvent arg0) {
            this.tf.setText("");
        }

        @Override
        public void focusLost(FocusEvent arg0) {
        }

    }

    public void ajouter() {
        Item item = new Item(this.intitule.getText(),
                Double.valueOf(this.prixMarch.getText()),
                Integer.valueOf(this.quantMarch.getText()));
        item.setNbrMarch(Integer.valueOf(this.nbrMarch.getText()));
        item.setNbrHorsMarch(Integer.valueOf(this.nbrHorsMarch.getText()));
        this.stock.getStocks().add(item);
    }

    public JTextField getIntitule() {
        return intitule;
    }

    public void setIntitule(JTextField intitule) {
        this.intitule = intitule;
    }

    public JTextField getPrixMarch() {
        return prixMarch;
    }

    public void setPrixMarch(JTextField prixMarch) {
        this.prixMarch = prixMarch;
    }

    public JTextField getQuantMarch() {
        return quantMarch;
    }

    public void setQuantMarch(JTextField quantMarch) {
        this.quantMarch = quantMarch;
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

    public JButton getAjouter() {
        return ajouter;
    }

    public void setAjouter(JButton ajouter) {
        this.ajouter = ajouter;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
