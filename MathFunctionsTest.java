import java.util.*;

/**
 * Diese Klasse testet interaktiv die Fachklasse MathFunctions.
 * 
 * @author Mert Kiran & Daniel Stelz
 * @version early access 1.1
 */
public class MathFunctionsTest {
    private Scanner input = new Scanner(System.in);

    /**
     * Klassenkonstanten
     */
    private static final int TEILERSUMME    = 1;
    private static final int ISBN           = 2;
    private static final int NULLSTELLEN    = 3;
    private static final int ENDE           = 0;

    /**
     * Hauptschleife des Testprogramms.
     * Gibt Errormeldungen in Form von Exceptions aus.
     */
    public void start() {
        int funktion = -1;

        while(funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch(IllegalArgumentException e) {
                System.out.println(e);
            } catch(InputMismatchException e) {
                System.out.println(e);
                input.nextLine();
            } catch(Exception e) {
                System.out.println(e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Main-Methode zum Erzeugen des ArtikelDialog-Objektes
     * und zum Anstarten der Testschleife.
     */
    public static void main(String[] args) {
        new MathFunctionsTest().start();
    }

    /**
     * Mit dieser Methode wird die Auswahl an Funktionen angezeigt
     * 
     * @return auszuführende Funktion
     */
    private int einlesenFunktion() {
        System.out.print(
            TEILERSUMME     + ": Teilersumme berechnen | " +
            ISBN            + ": Prüfziffer einer ISBN-10 berechnen | " +
            NULLSTELLEN     + ": Nullstellen bestimmen | " +
            ENDE            + ": Beenden -> ");

        return input.nextInt();
    }

    /**
     * Die ausgewählte Funktion wird mit dieser Methode ausgeführt.
     * Enthält Die Methoden für Teilersumme, ISBN, Nullstellen und Beendung des Programmes.
     * 
     * @param funktion
     */
    private void ausfuehrenFunktion(int funktion) {
        long zahl, isbn9;
        double p, q;

        if(funktion == TEILERSUMME) {
            System.out.println("Eine positive Zahl eingeben: ");
            zahl = input.nextLong();
            System.out.println("Die Teilersumme lautet: " + MathFunctions.berechneTeilersumme(zahl));

        } else if(funktion == ISBN) {
            System.out.println("Die ersten 9 Ziffern einer ISBN-10 eingeben: ");
            isbn9 = input.nextLong();
            System.out.println("Die Prüfziffer lautet: " + MathFunctions.berechneChecksummeIsbn(isbn9));

        } else if(funktion == NULLSTELLEN) {
            System.out.println("Einen Wert für p eingeben: ");
            p = input.nextDouble();
            System.out.println("Einen Wert für q eingeben: ");
            q = input.nextDouble();
            System.out.println(MathFunctions.berechneNullstellen(p, q));

        } else if(funktion == ENDE) {
            System.out.println("Programmende!");

        } else {
            System.out.println("Falsche Eingabe!");
        }
    }
}