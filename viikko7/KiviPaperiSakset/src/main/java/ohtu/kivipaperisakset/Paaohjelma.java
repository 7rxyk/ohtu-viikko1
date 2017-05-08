package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            kysy();
            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                a();
            } else if (vastaus.endsWith("b")) {
                b();
            } else if (vastaus.endsWith("c")) {
                c();
            } else {
                break;
            }
        }
    }

    public static void kysy() {
        System.out.println("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

    public static void a() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
    }

    public static void b() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSTekoaly yksinpeli = new KPSTekoaly();
        yksinpeli.pelaa();
    }

    public static void c() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
        pahaYksinpeli.pelaa();
    }
}
