import java.util.Arrays;
import java.util.Scanner;

public class B2A2 {
    public static int compare_cnt = 0; // Zähler für die Vergleiche während des sortierens.

    /**
     * @param args die Parameter aus der Kommandozeile
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt(); // Größe des Arrays lesen
        int[] numbers = new int[size]; // Array initialisieren

        // Werte für das Array einlesen
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }

        mergeSort(numbers); // Sortieren des Arrays

        input.close();
    }

    /**
     * Führt den Merge-Sort-Algorithmus aus.
     *
     * @param numbers das zu sortierende Array
     */
    public static void mergeSort(int[] numbers) {
        int[] tmpArray = new int[numbers.length];
        System.arraycopy(numbers, 0, tmpArray, 0, numbers.length);

        mergeSort(numbers, tmpArray, 0, numbers.length);

        // make sure that you have implemented and compiled B2A1 (run: javac B2A1.java)
        assert B2A1.isSorted(numbers);
    }

    /**
     * Hilfsfunktion, welche die rekursiven Aufrufe ausführt.
     *
     * @param target Zielarray für die sortierte Folge
     * @param source ein zu sortierendes Array mit Integer Zahlen
     * @param left   die linke Grenze des zu sortierenden Teilarrays, inklusiv
     * @param right  die rechte Grenze des zu sortierenden Teilarrays, exklusiv
     */
    public static void mergeSort(int[] target, int[] source, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            System.out.println(left + " " + middle + " " + right);
            mergeSort(source, target, left, middle);
            mergeSort(source, target, middle + 1, right);
            // merge(target, source, left, middle, right);
        }
    }

    private static void merge(int[] target, int[] source, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            compare_cnt++;
            if (source[i] <= source[j]) {
                target[k] = source[i];
                i++;
            } else {
                target[k] = source[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            target[k] = source[i];
            i++;
            k++;
        }

        while (j <= right) {
            target[k] = source[j];
            j++;
            k++;
        }
    }

}