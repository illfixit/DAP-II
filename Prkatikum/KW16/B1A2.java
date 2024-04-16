import java.util.Arrays;
import java.util.Scanner;

/*
 Schreiben Sie ein Programm, das eine Ganzzahl n und Liste L der Ganzzahlen ℓ0, ℓ1, · · · , ℓn−1 via Standard-In als Eingabe erhält, und alle Permutationen von ℓ0, ℓ1, · · · , ℓn−1 ausgibt (eine Permutation pro Ausgabezeile). Am Ende soll die Anzahl der Permutationen ausgegeben werden. Beispiel:
{ echo 3; seq 11 3 17; } | java B1A2.java
[11, 14, 17]
[11, 17, 14]
[14, 11, 17]
[14, 17, 11]
[17, 11, 14]
[17, 14, 11]
Es gibt 6 Permutationen der Eingabe.
 */

class B1A2 {

    static int count = 0;

    public static void main(String[] args) {

        int[] array = readArray();

        System.out.println("Es gibt " + printPermutations(array, 0) + " Permutationen der Eingabe.");
        // System.out.println("Es gibt " + printPermutations(array, 1) + " Permutationen
        // der Eingabe.");
        // System.out.println("Es gibt " + printPermutations(array, 2) + " Permutationen
        // der Eingabe.");

        // System.out.println("Es gibt " + printPermutations(array, 3) + " Permutationen
        // der Eingabe.");

    }

    // Das Argument d gibt an, wie viele Positionen im Array bereits festgelegt sind
    private static int printPermutations(int[] array, int d) {

        // wir starten bei d = 0
        // ([5,11,14,17], 0)

        // printPermutations([5,11,14,17], 3) (Rückgabewert: 1)
        // arr.length = 4, d = 3, Rückgabewert: 1
        if (d == array.length - 1) {
            System.out.println(Arrays.toString(array));
            return 1;
        }

        for (int i = d; i < array.length; i++) {

            System.out.println("d: " + d + ", i: " + i);

            swap(array, d, i);

            printPermutations(array, d + 1);

        }

        return factorial(array.length - d);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    private static int[] readArray() {
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
