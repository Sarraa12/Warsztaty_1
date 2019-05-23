package hello_world.gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        System.out.println("This about a number between 0 and 1000 and I will guess it in less than 10 guesses");
        int min = 0;
        int max = 1000;

        int guess = ((max - min) / 2) + min;
        Scanner sc = new Scanner(System.in);
        int i = 0;
        String response;
        do {
            System.out.println("I'm guessing: " + guess);
            response = sc.nextLine();
            if (response.equals("too much") && i < 9) {
                max = guess;
                guess = ((max - min) / 2) + min;
                i++;
            } else if (response.equals("too little") && i < 9) {
                min = guess;
                guess = ((max - min) / 2) + min;
                i++;
            } else if (!response.equals("too much") && !response.equals("to little") && !response.equals("you've guessed")) {
                System.err.println("Wrong answer");
            } else if (i >= 9) {
                System.err.println("Don't cheat");
            }
        }
        while (!response.equals("you've guessed"));

        sc.close();
        System.out.println("I won");

    }


    private static int takeAGuessFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("This is not a number");
            scanner.nextLine();

        }
        return scanner.nextInt();

    }
}
