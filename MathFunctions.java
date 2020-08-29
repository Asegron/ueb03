/**
 * Die Klasse MathFunctions bietet mathematische Funktionen zur Berechnung von Teilersummen,
 * Prüfziffern einer ISBN-10 und Nullstellen von quadratischen Funktione
 * in Form von Klassenmethoden an.
 * 
 * @author Mert Kiran & Daniel Stelz
 * @version early access 1.1
 */
public class MathFunctions {
    /**
     * Klassenkonstanten
     */
    private static final String NEGATIV =
        "Die eingegebene Zahl ist kleiner als 0!";
    private static final String ISBN_FALSCH =
        "Die ISBN ist nicht 9-stellig!";
    private static final long MIN_ISBN = 100000000;
    private static final long MAX_ISBN = 999999999;
    private static final double ɛ = 1.0E-08;

    /**
     * Standardkonstruktor
     */
    private MathFunctions() {}

    /**
     * Diese Methode berechnet die Teilersumme einer Zahl.
     * 
     * @param zahl bekommt einen positiven Wert zugewiesen
     * @return Teilersumme
     */
    public static long berechneTeilersumme(long zahl) {
        long l, teilersumme;

        if(zahl < 0) {
            throw new IllegalArgumentException(NEGATIV);
        }

        for(l = 1, teilersumme = 0; l * l < zahl; l++) {
            if((zahl % l) == 0) {
                teilersumme += l + zahl / l;
            }
        }
        return teilersumme;
    }

    /**
     * Diese Methode berechnet die Prüfziffer einer ISBN-10
     * 
     * @param isbn bekommt einen 9-stelligen Wert zugewiesen
     * @return Prüfziffer einer ISBN-10
     */
    public static String berechneChecksummeIsbn(long isbn) {
        long summe = 0;
        int i = 9;

        if(isbn < MIN_ISBN || isbn > MAX_ISBN) {
            throw new IllegalArgumentException(ISBN_FALSCH);
        }

        while(isbn > 0) {
            summe += (isbn % 10) * i;
            isbn /= 10;
            i--;
        }

        if(summe % 11 == 10) {
            return "X";
        } else {
            return "" + summe % 11;
        }
    }

    /**
     * Diese Methode berechnet die Nullstellen einer quadratischen Gleichung
     * 
     * @param p bekommt einen Wert zugewiesen
     * @param q bekommt einen Wert zugewiesen
     * @return Nullstellen
     */
    public static String berechneNullstellen(double p, double q) {
        double diskriminante, x, x1, x2;
        String ergebnis = new String();

        diskriminante = (p / 2) * (p / 2) - q;

        if(diskriminante >= ɛ) {
            x1 = -(p / 2) + Math.sqrt(diskriminante);
            x2 = -(p / 2) - Math.sqrt(diskriminante);
            ergebnis += "Zwei Nullstellen: " + x1 + " | " + x2;
        } else {
            if(diskriminante <= -ɛ) {
                ergebnis += "Die Funktion hat komplexe Nullstellen.";
            } else{
                x = -(p / 2);
                ergebnis += "Die Funktion hat eine doppelte Nullstelle bei " + x;
            }
        }
        return ergebnis;
    }
}