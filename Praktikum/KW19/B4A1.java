import java.util.Arrays;
import java.util.Scanner;

/*

Langaufgabe 4.1: Max-Heaps und Heap-Select
(4 Punkte)

In der Vorlesung haben Sie Max-Heaps kennengelernt, die man als Priority Queue oder zum deterministischen Sortieren in O(n log n) Zeit verwenden kann. 
Dieser Algorithmus aus der Vorlesung wurde in einem top-down-Ansatz zur Konstruktion des Heapbaums verwendet. Eine andere Methode um einen Heap zu konstruieren ist ein bottom-up Ansatz.
In dieser Aufgabe sollen Sie Heap-Sort Algorithmus implementieren die erst ein Max-Heap konstruirt der den globalen bottom-up Ansatz nutzt. 
Das bedeutet, dass neue Elemente am Ende des Arrays hinzugefügt werden und sich somit unten im Baum befinden. 
Um also nach jedem neuen Element einen korrekten Baum zu haben, müssen diese wiederholend mit ihren Eltern verglichen und wenn nötig ausgetauscht werden.
Nachdem der Max-Heap konstruiert wurde, wird mit Hilfe des Heapbaums nach dem k größten Element gesucht.

• Implementiere die Methode maxHeapifyUp(data, i), die O(log n) Zeit benötigt. 
Das Argument i ist der Index des Knoten, für den die Heap-Eigenschaft gesetzt werden soll.
Da hier der bottom-up-Ansatz verwendet wird, sollte data[0, i-1] bereits ein gerichteter Heapbaum sein.

public static void maxHeapifyUp(int [] data, int i)

• Implementieren Sie die Methode buildMaxHeap(data), welche mittels maxHeapifyUp einen Max-Heap erzeugt. 
Diese läuft in O(n log n) Zeit.

public static void buildMaxHeap(int [] data)

• Implementieren Sie die Methode extractMax(data,n), welche in O(log n) Zeit das kleinste Element aus dem Heap entfernt und ausgibt. Danach befinden sich die restlichen Heap-Elemente in data[0, n − 2], und das entfernte Maximum steht an Position data[n − 1].

public static int extractMax(int [] data, int n)

• Implementieren Sie die Methode maxHeapifyDown(data, n), die in O(log n) ausgeführt wird. 
Diese Methode stellt immer die Heap-Eigenschaft des Knotens mit dem Index 0 wieder her. 
Am Ende sollte nur data[0, n - 1] einen korrekten Max Heap darstellen.

public static int maxHeapifyDown(int [] data, int i, int n)

• Implementieren Sie die Methode heapSelect(data, k), die mithilfe der vorherigen 4 Methoden das k-kleinste Element in data findet und ausgibt. 
Die Methode darf keine Hilfsarrays verwenden. Der Inhalt von data darf beliebig permutiert werden.

public static int heapSelect(int [] data, int k)

Abschließend sollen Sie eine geeignete main-Methode schreiben, sodass Ihr Porgramm das eine Ganzzahl n und eine Liste von Ganzzahlen a0, a1, . . . , an−1 via Standard-In (Nach jedem Wert
bestätigen Sie mit der Enter-Taste), sowie ein Argument k erhält, und dann den k-kleinsten Wert der Liste ausgibt. 
Wenn es in der Liste Duplikate gibt, dann brauchen Sie diese nicht
besonders zu behandeln:
java B4A1.java 3 <Enter>
5 1 2 2 3 4 <Enter>
Input Array: [1, 2, 2, 3, 4]
The 3-smallest element is 2

Wie immer können Sie davon ausgehen, dass die Eingabe korrekt ist und müssen den Code nicht um diese Eingabe Robust gestalten.
 */

class B4A1 {
    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    /*
     * • Implementiere die Methode maxHeapifyUp(data, i),
     * die O(log n) Zeit benötigt.
     * Das Argument i ist der Index des Knoten, für den die Heap-Eigenschaft gesetzt
     * werden soll.
     * Da hier der bottom-up-Ansatz verwendet wird, sollte data[0, i-1] bereits ein
     * gerichteter Heapbaum sein.
     * 
     * public static void maxHeapifyUp(int [] data, int i)
     */

    public static void maxHeapifyUp(int[] data, int i) {

        // die Methode ist relativ einfach: wir gehen von den Hinten bis zum Wurzel
        // des Arrays und vergleichen jedes Mal das Kind mit dem jeweiligen Parent.
        // Wann Kind größer ist, tauschen wir die Elementen mit swap um.
        // Anderfalls beenden wir die Schleife weil der Array richtig sortiert ist.
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (data[i] > data[parent]) {
                swap(data, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    /*
     * 
     * Implementieren Sie die Methode maxHeapifyDown(data, n), die in O(log n)
     * ausgeführt wird. Diese Methode stellt immer die Heap-Eigenschaft des Knotens
     * mit dem Index 0 wieder her.
     * Am Ende sollte nur data[0, n - 1] einen korrekten Max Heap darstellen.
     * 
     * public static int maxHeapifyDown(int [] data, int n)
     */

    // ! hier steht maxHeapifyDown(data, n) und dann maxHeapifyDown(int [] data, int
    // i, int n). Ich glaube die zweite Variante ist ein Fehler.

    public static void maxHeapifyDown(int[] data, int n) {
        int i = 0;

        while (i < n) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            int max = i;

            // wir stellen sicher, dass die Indices weniger als n sind
            // und vergleichen sie mit der Index des größten Elementes.
            if (leftChildIndex < n && data[leftChildIndex] > data[max]) {
                max = leftChildIndex;
            }

            // same aber für das rechte Kind
            if (rightChildIndex < n && data[rightChildIndex] > data[max]) {
                max = rightChildIndex;
            }

            // falls nach den zwei vorherigen ifs i ungleich max ist, dann swap
            // die zwei Elementen via seinen Indices: max und i mithilfe der predefined
            // swap Funktion. else return
            if (max != i) {
                swap(data, i, max);
                i = max;
            } else {
                return;
            }
        }
    }

    /*
     * Implementieren Sie die Methode buildMaxHeap(data), welche mittels
     * maxHeapifyUp einen Max-Heap erzeugt.
     * Diese läuft in O(n log n) Zeit.
     * 
     * public static void buildMaxHeap(int [] data)
     */

    public static void buildMaxHeap(int[] data) {
        // maxHeapifyUp hat die O(log n). Wir rufen die funktion n Mal auf um die
        // Heap Bedingung aufrechterhalten zu machen.
        for (int i = 1; i < data.length; i++) {
            maxHeapifyUp(data, i);
        }
    }

    /*
     * Implementieren Sie die Methode extractMax(data,n), welche in O(log n) Zeit
     * das kleinste Element aus dem Heap entfernt und ausgibt. Danach befinden sich
     * die restlichen Heap-Elemente in data[0, n − 2], und das entfernte Maximum
     * steht an Position data[n − 1].
     * 
     * public static int extractMax(int [] data, int n)
     */

    public static int extractMax(int[] data, int n) {

        // wir nehmen den Max Wert aus dem Feld heraus und das passiert in O(1)
        // aber wir müssen auch den ganzen Array wieder heapifyen via
        // maxHeapifyDown
        int max = data[0];
        data[0] = data[n - 1];
        maxHeapifyDown(data, n - 1);
        return max;
    }

    /*
     * Implementieren Sie die Methode heapSelect(data, k), die mithilfe der
     * vorherigen 4 Methoden das k-kleinste Element in data findet und ausgibt. Die
     * Methode darf keine Hilfsarrays verwenden.
     * 
     * Der Inhalt von data darf beliebig permutiert werden.
     * public static int heapSelect(int [] data, int k)
     */

    public static int heapSelect(int[] data, int k) {

        // hier wissen wir nicht, ob die Data ein korrektes Heap
        // darstellt, deswegen machen wir zuerst buildMaxHeap.
        buildMaxHeap(data);

        // Dann mithilfe von extractMax nehmen alle Elemente bis k - 1 raus
        for (int i = 0; i < k - 1; i++) {
            extractMax(data, data.length - i);
        }

        // und am Ende geben wir einfach das erste Element des Arrays zurück
        return data[0];
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
        System.out.println("The " + k + "-biggest element is " + v);

    }
}