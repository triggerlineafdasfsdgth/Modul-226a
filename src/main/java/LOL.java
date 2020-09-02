
import java.util.Scanner;

public class LOL {

    public static double Addition (double Operant1, double Operant2){
        double ergebnis;
        ergebnis = Operant1 + Operant2;
        return ergebnis;
    }

    public static double Subtrahieren (double Operant1, double Operant2){
        double ergebnis;
        ergebnis = Operant1 - Operant2;
        return ergebnis;
    }

    public static double Multiplikation (double Operant1, double Operant2){
        double ergebnis;
        ergebnis = Operant1 * Operant2;
        return ergebnis;
    }

    public static double Division (double Operant1, double Operant2){
        double ergebnis;
        ergebnis = Operant1 / Operant2;
        return ergebnis;
    }

    public static void main(String[] args) {
        Scanner eingabezahl = new Scanner(System.in);
        Scanner Operator = new Scanner(System.in);



        double zahl1 = eingabezahl.nextDouble();
        double zahl2 = eingabezahl.nextDouble();
        double zahl3 = Operator.nextDouble();

        System.out.println("Bitte geben sie Ihre Zahl ein");
        eingabezahl.nextInt();

        System.out.println("Bitte geben sie Ihre 2.Zahl ein");
        eingabezahl.nextInt();

        System.out.println("Geben sie eine Zahl ein für die Operanten");
        Operator.nextInt();

        switch ((int) zahl3) {
            case 1 -> {
                System.out.println("Ergebnis =" + Addition(zahl1, zahl2));
                break;
            }
            case 2 -> {
                System.out.println("Ergebnis =" + Subtrahieren(zahl1, zahl2));
                break;
            }
            case 3 -> {
                System.out.println("Ergebnis =" + Multiplikation(zahl1, zahl2));
                break;
            }
            case 4 -> {
                System.out.println("Ergebnis =" + Division(zahl1, zahl2));
                break;
            }
            default -> System.out.println("Geben sie eine Zahl bei operator zwischen 1 und 4 UND NICHT DARèBER, DARUNTER ODER SONST EIN SCHEISS!!!");
        }
    }
}
