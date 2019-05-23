package hello_world.lotto;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        System.out.println("Enter six numbers:");
        StringBuilder sb = new StringBuilder();
        int chosenNumber;
        int chosenNumbers[] = new int[6];

        for (int i = 0; i < chosenNumbers.length; ) {
            chosenNumber = takeAGuessFromUser();
            if (chosenNumber < 1 || chosenNumber > 49) {
                System.out.println("Enter a proper number.");
            } else if (Arrays.binarySearch(chosenNumbers, chosenNumber) > -1) {
                System.out.println("Taka liczba została już podana");
            } else {
                chosenNumbers[0] = chosenNumber;
                Arrays.sort(chosenNumbers);
                i++;
            }
        }
        for (int i = 0; i < chosenNumbers.length; i++) {
            if (chosenNumbers[i] == chosenNumbers.length) {
                System.out.println(chosenNumbers[i]);
            } else {
                System.out.print(chosenNumbers[i] + ",");
            }

        }
        getAndCheck(chosenNumbers);
    }

    private static int takeAGuessFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("This is not a number");
            scanner.nextLine();
        }
        return scanner.nextInt();

    }

    static void getAndCheck (int[] chosenNumbers) {
        Random r = new Random();
        int[] intTab = new int [chosenNumbers.length];
        int founds = 0;

        System.out.println("\nChosen numbers: ");
        for (int i = 0; i < chosenNumbers.length; i++) {
            intTab[i] = r.nextInt(49);
            if ((intTab[0] == 0) || ArrayUtils.indexOf(intTab, intTab[i]) < 0) {
                intTab[i] += 1;
            }
            System.out.print(intTab[i] + " ");
            if (Arrays.binarySearch(chosenNumbers,intTab[i]) > -1) {
                founds++;
            }
        }
        System.out.println("\nYou've got " + founds + " numbers correct.");
    }
}
