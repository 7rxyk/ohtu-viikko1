package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;

    }

    @Override
    public void suorita() {
        sovellus.miinus(Integer.parseInt(this.syotekentta.getText()));
        this.tuloskentta.setText("" + sovellus.tulos());
        this.syotekentta.setText("");

    }

    @Override
    public void peru() {
        sovellus.edellinen();
        this.tuloskentta.setText("" + sovellus.tulos());
    }
}
