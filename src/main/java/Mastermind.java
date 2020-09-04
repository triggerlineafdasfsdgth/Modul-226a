import java.util.Random;
import java.util.Scanner;

//ES FUNKTIONIERT ENDLICH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class Mastermind {

    private final int CODE_LENGTH = 4;

    private final char[] COLORS = {'r', 'g', 'b', 'y', 's', 'w'};

    private final Random RANDOM = new Random();

    private final Scanner CONSOLE = new Scanner(System.in);

    private final char[] secretCode = new char[CODE_LENGTH];


    public static void main(String[] args) {
        Mastermind mastermind = new Mastermind();
        mastermind.play();
    }


    private void play() {
        //Generiere Zufallsfarben
        generateRandomcolors();
        //Char Array mit dem namen entry (leer)
        char[] entry = new char[CODE_LENGTH];
        //Anzahl der Versuche
        int numberofattempts = 0;
        do {
            //erhöhe numberofattempts um 1
            numberofattempts++;
            //Eingabe

            // Eingabe wird Bearbeitet    entry Array bekommt die Daten von der methode readentry()
            entry = readEntry();
            //Prüfen, ob secretCode == Char[] entry, wenn nein, wird das Ergebnis ausgegeben, sonst Schleife weiter laufen lassen
        } while (codeDoesNotMatch(entry));
        //Ausgabe und bestimmung, ob Gewonnen oder Verloren.
        printResult(numberofattempts);

    }

    //funktioniert.
    private void printResult(int numberofattempts) {
        //Wenn Zahl der Versuche über 12 ist, dann hat man Verloren.
        if (numberofattempts > 12) {
            System.out.println("Sie haben Verloren aufgrund zuvieler Versuche");
            System.out.println("Anzahl Ihrer Versuche:"+""+ numberofattempts);
            System.out.println("VERLOREN");
        }
        //Alles unter 13 Versuche führt zum Sieg.
        else {
            System.out.println("Sie Haben Gewonnen");
            System.out.println("Anzahl Ihrer Versuche:"+""+ numberofattempts);
            System.out.println("Geheimcode:"+""+secretCode[0]+secretCode[1]+secretCode[2]+secretCode[3]);
        }
    }

    private boolean codeDoesNotMatch(char[] entry) {

        //vereinfachtes Hinweissystem----------------------------------------------------------------------------

        if (entry.length > CODE_LENGTH) {
            return true;
        }

        int Zähler_Schwarz = 0;
        for (int i = 0; i < CODE_LENGTH; i++)
            if (secretCode[i] == entry[i]) {
                Zähler_Schwarz++;
            }
        if (Zähler_Schwarz == CODE_LENGTH) {
            return false;
        }
        System.out.println("Hinweiss (Schwarz = Farben und Platz die richtig sind):"+""+ Zähler_Schwarz +""+"sind richtig");
        //ist dafür Zuständig, Hinweisse für die Farben anzugeben, die richtig sind, aber an flascher stelle vorhanden sind.
        int Zähler_Weiss = 0;
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[0] == entry[i]) {
                Zähler_Weiss++;
            }
        }
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[1] == entry[i]) {
                Zähler_Weiss++;
            }
        }
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[2] == entry[i]) {
                Zähler_Weiss++;
            }
        }
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[3] == entry[i]) {
                Zähler_Weiss++;
            }
        }
        int Hinweiss_weiss = Zähler_Weiss - Zähler_Schwarz;
        if (Hinweiss_weiss > 5) {
            System.out.println("Weisser Hinweiscounter ist fehlerhaft");
        } else {
            //hab ich nur gemacht, weil ich keine Zeit mehr hatte, das System zu überarbeiten.
            System.out.println("Hinweiss (Weiss = farben die richtig sind oder doppelt vorkommen, aber am falschen Platz oder zu viele):"+""+ Hinweiss_weiss +""+"sind richtig");
        }

        //wenn Tests bestannden, gib False aus um die do While Schleife zu brechen;
        return true;
    }

    //readentry ist die Methode um am ende die Werte in das char Array Entry zu speichern und beim codedoesnotmatch zu überprüfen
    //funktioniert
    private char[] readEntry() {
        char[] entry = new char[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++)
            entry[i] = requestInput();
        return entry;
    }

    //funktioniert
    private char requestInput() {
        int eingabe;
        //Hatte keine lust, Zahlen in Buchstaben zu übersetzen. Also String zu Char.
        System.out.println("Geben sie Ihren Code ein (0 = red(r), 1 = green(g), 2 = blue(b), 3 = yellow(y), 4 = schwarz(s), 5 = weiss(w))");
        // Variable eingabe ist die eingabe für die Zahlen mit der beschränkung der länge vom Array COLOR.
        eingabe = CONSOLE.nextInt();
        //optional------------------------------------
        if (eingabe > 5) {
            System.out.println("Zahl:" + "" + eingabe + "" + "ist zu hoch, geht nur von 0 bis 5, versuchen sie es noch einmal");
            return requestInput();
        }
        //optional------------------------------------
        //Gebe Farbe aus, die aus der Int Variable engabe kommt.
        return COLORS[eingabe];


    }

    //Funktioniert
    private void generateRandomcolors() {
        //Wenn i ist gleich kleiner als 4, führe Schleife aus und erhöhe um 1 bis 4.
        for (int i = 0; i < CODE_LENGTH; i++) {
            //secretCode Array an der variable der Schleife i angebunden, Speichert jede Ausgabe von randomcolor in ein eigenes Array Segment.
            secretCode[i] = randomcolor();
        }


    }

    //Funktioniert
    private char randomcolor() {
        //Gib Buchstabe des Arraysegments durch die Zufalszahl.
        return COLORS[RANDOM.nextInt(COLORS.length)];
    }

}
//Wer die NamensDeklaration nicht auf Lingualer Ebene versteht, der soll Deepl zum übersetzen nutzen.
//Englische Namensdeklaration sind für mich eine Blockade im Hirn.
//Ich bin ein Pirat.