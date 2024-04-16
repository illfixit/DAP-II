import java.util.Arrays;
import java.util.Scanner;

class B1A1 {

    public static void main(String[] args) {

        /*
         * (b) Schreibe ein Programm, das eine Ganzzahl n und dann eine Liste L von n
         * Ganzzahlen über Standard-In empfängt und in einem Array vom Typ int []
         * ablegt. (2 Punkte)
         */

        if (args.length != 1) {
            System.out.println("Exactly one argument is required.");
            return;
        }

        /*
         * (c) Schreibe ein Programm, das eine Ganzzahl n und Liste L der Ganzzahlen ℓ0,
         * ℓ1, · · · , ℓn−1 über Standard-In sowie eine positive Ganzzahl k als Argument
         * erhält. Das Programm soll den kleinsten Wert k in der Liste als Ergebnis
         * ausgeben. Dazu können Sie Ihre Lösung der Teilaufgabe (b) und die Methode
         * Arrays.sort(...) aus der Bibliothek java.util.Arrays verwenden, die ein Array
         * aufsteigend sortiert. (2 Punkte).
         * Beispiel:
         * { echo 25; seq 13 37 | shuf;} | java B1A1.java 3
         * The 3-smallest value is 15.
         */

        int[] array = readArray();
        int k = Integer.parseInt(args[0]);
        Arrays.sort(array);
        System.out.println("The " + k + "-smallest value is " + array[k - 1] + ".");
    }

    public static int[] readArray() {
        Scanner input = new Scanner(System.in);

        // System.out.println("Bitte geben Sie die Anzahl der Elemente ein:");
        int n = input.nextInt();
        int[] array = new int[n];
        // System.out.println("Bitte geben Sie die Elemente ein:");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        input.close();

        return array;
    }
}
