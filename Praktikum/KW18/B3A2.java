import java.util.Arrays;
import java.util.Scanner;

class B3A2 {
    /**********************************************************/
    /**** Kurzaufgabe 3.2: ****/

    // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

    /**********************************************************/

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        Arrays.sort(arr);
        System.err.println("Sorted input:");
        System.out.println(Arrays.toString(arr));
        System.err.println("The " + k + "-smallest permutation is:");
        /**********************************************************/
        /**** Kurzaufgabe 3.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }
}
