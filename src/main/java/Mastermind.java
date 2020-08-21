import java.awt.*;
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
        generateRandomcolors();
        char[] entry;
        int numberofattempts = 0;
        do {
            numberofattempts++;
            requestInput();
            entry = readEntry();
        } while (codeDoesNotMatch(entry));
        printResult(numberofattempts);

    }

    private void printResult(int numberofattempts) {
        System.out.println("");
        System.out.println("");
    }

    private boolean codeDoesNotMatch(char[] entry) {
        if ()


    }

    private char[] readEntry() {


        return new char[0];
    }

    private void requestInput() {



    }

    private void generateRandomcolors() {
        for (int i = 0; i < CODE_LENGTH; i++) {
            secretCode[i] = randomcolor();
        }


    }

    private char randomcolor() {
        int randomcolor = 0;
        for (int i = 0; i < CODE_LENGTH; i++)
            randomcolor = RANDOM.nextInt(COLORS.length);
        return COLORS[randomcolor];
    }

}