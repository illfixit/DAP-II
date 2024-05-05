import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class SolutionB4A2New {
    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    // Hilfsfunktion zum Berechnen von n!
    public static int fact(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void updatePremutation(int[] numbers, int[] counters) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }

    public static void shufflePermutation(int[] numbers) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }

    public static int insertionSort(int[] permutation) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return 0;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }
}
