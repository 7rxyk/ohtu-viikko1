package ohtu;

import java.util.ArrayList;

public class Sovelluslogiikka {
 
    private int tulos;
    private ArrayList<Integer> tulokset = new ArrayList<>();
    
    public void edellinen() {
        this.tulos = this.tulokset.get(this.tulokset.size() - 1);
    }
 
    public void plus(int luku) {
        tulos += luku;
        this.tulokset.add(tulos);
    }
     
    public void miinus(int luku) {
        tulos -= luku;
        this.tulokset.add(tulos);
    }
 
    public void nollaa() {
        tulos = 0;
        this.tulokset.add(tulos);
    }
 
    public int tulos() {
        return tulos;
    }
}