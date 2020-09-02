import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    private static final int CODE_LENGTH = 4;

    private static final char[] COLORS = {'r', 'g', 'b', 'y', 's', 'w'};

    private static final Random RANDOM = new Random();

    private static final Scanner CONSOLE = new Scanner(System.in);

    private static final char[] secretCode = new char[CODE_LENGTH];


    public static void main(String[] args) {

        Mastermind mastermind = new Mastermind();
        mastermind.play();
    }


    private void play() {
        //Generiere Zufallsfarben
        generateRandomcolors();
        //Char Array mit dem namen entry (leer)
        char[] entry;
        //Anzahl der Versuche
        int numberofattempts = 0;
        do {
            //erhöhe numberofattempts um 1
            numberofattempts++;
            //Eingabe
            requestInput();
            // Eingabe wird Bearbeitet    entry Array bekommt die Daten von der methode readentry()
            entry = readEntry();
            //Prüfen, ob secretCode == Char[] entry, wenn ja, wird das Ergebnis ausgegeben, sonst Schleife weiter laufen lassen
        } while (codeDoesNotMatch(entry));
        //Ausgabe und bestimmung, ob Gewonnen oder Verloren.
        printResult(numberofattempts);

    }

    //funktioniert.
    private void printResult(int numberofattempts) {
        //Wenn Zahl der Versuche über 12 ist, dann hat man Verloren.
        if (numberofattempts > 12) {
            System.out.println("Sie haben Verloren aufgrund zuvieler Versuche");
            System.out.println("Anzahl Ihrer Versuche:" + numberofattempts);
            System.out.println("VERLOREN");
        }
        //Alles unter 13 Versuche fürht zum Sieg.
        else {
            System.out.println("Sie Haben Gewonnen");
            System.out.println("Anzahl Ihrer Versuche:" + numberofattempts);
        }
    }

    private boolean codeDoesNotMatch(char[] entry) {
        //Wenn länge von entry über 4, gibt true aus
        if (entry.length > CODE_LENGTH)
            return true;
        // Wenn secretCode nicht mit entry übereinstimmt, gib true aus.
        for (int i = 0; i < CODE_LENGTH ; i++) {
            //Wenn secretCode Array Segment Wert ungleich Wert vom gleichen Char[] entry Segment, dann true ausgeben.
            if (secretCode[i] != entry[i]) ;
            return true;
        }
        //Präzieseren Abgleich um Hinweise zu geben, das hier ist noch das Modell für einfache Hinweise, will es noch überarbeiten wenn Zeit.
        //deklaration von Hinweiscounter.
        int Hinweiscounter = 0;
        //Wenn abgleichSegment0 = true, dann Hinweiscounter um 1 erhöhen, ansosnten ignorieren.
        if (abgleichSegment0(entry))
            ++Hinweiscounter;

        if (abgleichSegment1(entry))
            ++Hinweiscounter;

        if (abgleichSegment2(entry))
            ++Hinweiscounter;

        if (abgleichSegment3(entry))
            ++Hinweiscounter;
        //Ausgabe der Hinweise.
        System.out.println("Hinweis:"+Hinweiscounter+"Farben sind richtig");

        //wenn Tests bestannden, gib False aus um die do While Schleife zu brechen;
        return false;
    }

    private boolean abgleichSegment3(char[] entry) {
        if (secretCode[3] == entry[3])
            return true;

        return false;
    }

    private boolean abgleichSegment2(char[] entry) {
        if (secretCode[2] == entry[2])
            return true;

        return false;
    }


    private boolean abgleichSegment1(char[] entry) {
        if (secretCode[1] == entry[1])
            return true;

        return false;
    }


    private boolean abgleichSegment0(char[] entry) {
        if (secretCode[0] == entry[0])
            return true;

        return false;
    }


    //Punkt 1 habe ich, Punkts 2 auch, Punkt 3 nicht, punkt 4 nicht
    //"länge,unerlaubte zahlen, farbenabgleich(zahlenabgleich, hinweise durch abgleich, hinweise anzeigen");

    //readentry ist die Methode um am ende die Werte in das char Array Entry zu speichern und beim codedoesnotmatch zu überprüfen
    private char[] readEntry() {


        return
    }
    //funtioneirt aufgrund von irgendetwas nicht = Process finished with exit code 1
    private char requestInput() {

        //Arraycounter um jede einzelne Zahl (Buchstabe) in ein eigenes Segment vom Array zu speichern (char)
        int Arraycounter = 0;
        //Wenn i ist gleich kleiner als 4, führe Schleife aus und erhöhe um 1 bis 4.
        for (int i = 0; i < CODE_LENGTH; i++) {
            //Hatte keine lust, Zahlen in Buchstaben zu übersetzen. Also String zu Char.
            System.out.println("Geben sie Ihren Code ein (0 = red(r), 1 = green(g), 2 = blue(b), 3 = yellow(y), 4 = schwarz(s), 5 = weiss(w))");
            //readEntry mit dem Char Array Segment, bestimmt durch Arraycounter, gleich Farbe die durch die Zhaleneingabe bestimmt wird
            readEntry()[Arraycounter] = COLORS[CONSOLE.nextInt()];
            //erhöhung von int Arraycounter um 1
            Arraycounter++;
        }
        //gibt Farbe aus die ins Char Array gespeichert wird, durch die Zahlen der Eingabe
        return COLORS[CONSOLE.nextInt()];


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
        //deklaration von randomcolor
        int randomcolor = 0;
        //Wenn i ist gleich kleiner als 4, führe Schleife aus und erhöhe um 1 bis 4.
        for (int i = 0; i < CODE_LENGTH; i++)
            //randomcolor = Zufallszahlengenerator der ein zufällige Zahl im bereich zwischen 0 bis 5 ausgibt.
            randomcolor = RANDOM.nextInt(COLORS.length);
        //Gib Buchstabe des Arraysegments durch die Zufalszahl.
        return COLORS[randomcolor];
    }

}
//Wer die NamensDeklaration nicht auf Lingualer Ebene versteht, der soll Deepl zum übersetzen nutzen.