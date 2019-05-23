package hello_world.kostka_do_gry;

import java.util.Random;


public class Main4 {


    private static final int[] SUPPORTED_NUMBERS_OF_SIDES

            = {3, 4, 6, 8, 10, 12, 20, 100};


    public static void main(String[] args) {

        String code = "100D5+10";

        int numberOfThrows = getNumberOfThrows(code);

        int numberOfSides = getNumberOfSides(code);

        int numberToAdd = getNumberToAdd(code);


        if (numberOfSidesIsNotSupported(numberOfSides)) {

            throw new IllegalArgumentException("unsupported number of sides!");

        }


        int sum = sumAllTheThrows(numberOfThrows, numberOfSides);


        System.out.println(sum + numberToAdd);

    }


    private static int sumAllTheThrows(int numberOfThrows, int numberOfSides) {

        Random random = new Random();

        int sum = 0;

        for (int i = 0; i < numberOfThrows; i++) {

            int number = random.nextInt(numberOfSides);

            sum += number;

        }

        return sum;

    }


    private static boolean numberOfSidesIsNotSupported(int numberOfSides) {

        for (int supportedNumberOfSides : SUPPORTED_NUMBERS_OF_SIDES) {

            if (supportedNumberOfSides == numberOfSides) {

                return true;

            }

        }

        return false;

    }


    private static int getNumberToAdd(String code) {

        String[] splitCode = code.split("D");

        String yPlusZ = splitCode[1];

        String[] yPlusZsplit = yPlusZ.split("(?=[+-])");

        return yPlusZsplit.length == 1 ? 0 : Integer.valueOf(yPlusZsplit[1]);

    }


    private static int getNumberOfSides(String code) {

        String[] splitCode = code.split("D");

        String yPlusZ = splitCode[1];

        String[] yPlusZsplit = yPlusZ.split("(?=[+-])");

        return Integer.valueOf(yPlusZsplit[0]);

    }


    private static int getNumberOfThrows(String code) {

        String[] splitCode = code.split("D");

        return splitCode[0].isEmpty() ? 1 : Integer.valueOf(splitCode[0]);

    }

}


//
//    Napisz funkcję, która:
//
//        przyjmie w parametrze taki kod w postaci String,
//        rozpozna wszystkie dane wejściowe:
//        rodzaj kostki,
//        liczbę rzutów,
//        modyfikator,
//        wykona symulację rzutów i zwróci wynik.
//
//        Typy kostek występujące w grach:
//
//        D3, D4, D6, D8, D10, D12, D20, D100.


//    W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko tych dobrze znanych,
// sześciennych. Jedną z popularniejszych kości jest np. kostka dziesięciościenna, a nawet stuścienna!
//
//        Ponieważ w grach kośćmi rzuca się często, pisanie za każdym razem np. "rzuć dwiema kostkami
// dziesięciościennymi, a do wyniku dodaj 20", byłoby żmudne, czasochłonne i marnowałoby ogromne ilości papieru.
//
//        W takich sytuacjach używa się kodu skracającego polecenie np.:
//
//        "rzuć 2D10+20".


//    Kod takiej kostki wygląda następująco:
//        xDy+z
//
//        gdzie:
//
//        y – rodzaj kostek, których należy użyć (np. D6, D10),
//        x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
//        z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
//
//        Przykłady:
//
//        2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
//        D6 – zwykły rzut kostką sześcienną,
//        2D3 – rzut dwiema kostkami trójściennymi,
//        D12-1 – rzut kością D12, od wyniku odejmij 1.

