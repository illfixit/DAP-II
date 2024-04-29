import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Select {
    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    public static int partition(int[] data, int l, int p, int r) {
        // Das Pivot-Element an die erste Position verschieben.
        swap(data, l, p);
        int h = l + 1;
        int lpiv = data[l];

        // Jetzt partitionieren wie bei Quicksort.
        while (h <= r) {
            if (data[h] < lpiv) {
                h++;
            } else {
                swap(data, h, r--);
            }
        }

        swap(data, l, --h);

        // Rückgabewert ist die neue Position des Pivots.
        // Alle Elemente links davon sind echt kleiner.
        // Alle Elemente rechts davon sind größer-gleich.
        return h;
    }

    // Genau wie quickSelectFirst, aber mit zufälligem Pivot
    public static int quickSelect(int[] data, int l, int r, int k) {
        int p = ThreadLocalRandom.current().nextInt(l, r + 1);
        int m = partition(data, l, p, r);
        int lessPlusOne = m - l + 1;
        if (k > lessPlusOne)
            return quickSelect(data, m + 1, r, k - lessPlusOne);
        else if (k < lessPlusOne)
            return quickSelect(data, l, m - 1, k);
        else
            return data[m];
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
        int result = quickSelect(arr, 0, n - 1, k);
        System.err.println("The " + k + "-smallest element is " + result);

    }
}
