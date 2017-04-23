package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, OLETUSKASVATUS = 5;
    private int kasvatuskoko;
    private int[] lukujoukko;
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti virheellinen.");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko virheellinen.");
        }
        lukujoukko = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukujoukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujoukko.length == 0) {
                copy();
            }
            return true;
        }
        return false;
    }

    public void copy() {
        int[] uusi = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(lukujoukko, uusi);
        lukujoukko = uusi;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujoukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujoukko[i]) {
                kohta = i;
                break;
            }
        }
        if (kohta != -1) {
            return moveBack(kohta);
        }
        return false;
    }

    public boolean moveBack(int kohta) {
        int apu;
        lukujoukko[kohta] = 0;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = lukujoukko[j];
            lukujoukko[j] = lukujoukko[j + 1];
            lukujoukko[j + 1] = apu;
        }
        alkioidenLkm--;
        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder tuotos = new StringBuilder("{");
        for (int i = 0; i <= alkioidenLkm - 1; i++) {
            tuotos.append(lukujoukko[i]);
            if (i != alkioidenLkm - 1) {
                tuotos.append(", ");
            }
        }
        tuotos.append("}");
        return tuotos.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujoukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0, aTauluLength = aTaulu.length; i < aTauluLength; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0, bTauluLength = bTaulu.length; i < bTauluLength; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0, aTauluLength = aTaulu.length; i < aTauluLength; i++) {
            for (int i1 = 0, bTauluLength = bTaulu.length; i1 < bTauluLength; i1++) {
                if (aTaulu[i] == bTaulu[i1]) {
                    y.lisaa(bTaulu[i1]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0, aTauluLength = aTaulu.length; i < aTauluLength; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0, bTauluLength = b.toIntArray().length; i < bTauluLength; i++) {
            z.poista(i);
        }
        return z;
    }
}
