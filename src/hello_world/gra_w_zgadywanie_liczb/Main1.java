package hello_world.gra_w_zgadywanie_liczb;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {


        int num = (int) (1 + Math.random() * 100);

        while (true) {
            System.out.println("Zgadnij liczbę:");

            int guessedNumber = takeAGuessFromUser();
//
            if (guessedNumber < num) {
                System.out.println("za mało!");

            } else if (guessedNumber > num){
                System.out.println("za dużo!");
            } else {
                System.out.println("zgadłeś");
                break;
            }
        }
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




//    Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100. Następnie:
//
//     1 wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
//      2  sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To nie jest liczba", po czym wrócić do pkt. 1;
//       3 jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za mało!", po czym wrócić do pkt. 1;
//      4  jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za dużo!", po czym wrócić do pkt. 1;
//      5  jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!", po czym zakończyć działanie programu.
//
//
