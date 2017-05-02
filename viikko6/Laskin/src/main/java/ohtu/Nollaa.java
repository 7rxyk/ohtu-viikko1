package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }

    @Override
    public void suorita() {
        sovellus.nollaa();
        this.tuloskentta.setText("" + sovellus.tulos());
        this.syotekentta.setText("");

    }

    @Override
    public void peru() {
        sovellus.edellinen();
        this.tuloskentta.setText("" + sovellus.tulos());
    }
}
