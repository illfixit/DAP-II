import java.util.Arrays;
import java.util.Scanner;

class MinHeap {

    // AUFGABE 1: HEAP SELECT
    // ********************************************************
    // ********************************************************************************

    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    // Stellt die Heapeigenschaft für data[i] her
    public static void minHeapify(int[] data, int i, int n) {
        // Nicht existierende Kinder repräsentieren wir durch den größtmöglichen Wert
        // (alternativ kann die Existenz der Kinder auch per "if" abgefragt werden)
        // In der VL sind Arrays ab 1 indiziert, in Java ab 0.
        // Die Kinder sind daher 2i+1 und 2i+2 (in der VL: 2i und 2i+1)
        int child1 = ((2 * i + 1) < n) ? data[2 * i + 1] : Integer.MAX_VALUE;
        int child2 = ((2 * i + 2) < n) ? data[2 * i + 2] : Integer.MAX_VALUE;
        // Wenn linkes Kind kleiner als data[i]
        if (data[i] > child1) {
            // Erst prüfen ob rechtes Kind noch kleiner ist.
            // Dann Elter mit kleinerem Kind tauschen, und
            // rekursiv Heapeigenschaft für das Kind herstellen.
            // (Elter wird im Heap "nach unten gedrückt").
            if (child1 > child2) {
                swap(data, i, 2 * i + 2);
                minHeapify(data, 2 * i + 2, n);
            } else {
                swap(data, i, 2 * i + 1);
                minHeapify(data, 2 * i + 1, n);
            }
        }
        // Linkes Kind war größer, aber rechtes könnte kleiner sein.
        // Dann wieder tauschen und rekursiv weitermachen.
        if (data[i] > child2) {
            swap(data, i, 2 * i + 2);
            minHeapify(data, 2 * i + 2, n);
        }
        // Ansonsten gibt es nichts zu tun.
    }

    // In der VL sind Arrays ab 1 indiziert, in Java ab 0.
    // Daher reicht es, wenn wir bei data.length/2-1 anfangen.
    public static void buildMinHeap(int[] data) {
        // All Positionen größer-gleich data.length/2 sind Blätter,
        // und müssen daher nicht beachtet werden.
        // (minHeapify macht für Blätter nichts)
        for (int i = data.length / 2 - 1; i >= 0; --i) {
            minHeapify(data, i, data.length);
        }
    }

    public static int extractMin(int[] data, int n) {
        // Dummy Rückgabewert für ungültige Aufrufe
        if (n < 1)
            return Integer.MAX_VALUE;
        swap(data, 0, n - 1);
        minHeapify(data, 0, n - 1);
        return data[n - 1];
    }

    public static int heapSelect(int[] data, int k) {
        // Erst Heap konstruieren,
        buildMinHeap(data);
        // dann k-1 kleinste Elemente entfernen,
        for (int i = 0; i < k - 1; ++i) {
            extractMin(data, data.length - i);
        }
        // danach ist das k-kleinste Element das Minimum des Heaps.
        return extractMin(data, data.length - (k - 1));
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.print("Input Array: ");
        System.out.println(Arrays.toString(arr));

        int v = heapSelect(arr, k);
        System.out.println("The " + k + "-smallest element is " + v);

    }
}