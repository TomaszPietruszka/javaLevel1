package zajecia1.sort.AndrzejSort;

import java.util.Arrays;

public class MainClass{
    // metoda generująca tablicę testową
    private static int[] getSampleArray() {
        return new int[]{9, 6, -17, 26, 2, 0, -11, 99, 12, -1, 1, 9};
    }

    public static void main(String[] args) {
        int[] bubbleSortArray = getSampleArray();
        bubbleSort(bubbleSortArray);
        System.out.println(Arrays.toString(bubbleSortArray));

        int[] selectionSortArray = getSampleArray();
        selectionSort(selectionSortArray);
        System.out.println(Arrays.toString(selectionSortArray));

        int[] insertionSortArray = getSampleArray();
        insertionSort(insertionSortArray);
        System.out.println(Arrays.toString(insertionSortArray));

        System.out.println(fibonacciRecursive(10));
        System.out.println(fibonacciInPlace(10));
        System.out.println(fibonacciInArray(10));

        System.out.println(fibonacciRecursive(42));
        System.out.println(fibonacciInPlace(42));
        System.out.println(fibonacciInArray(42));

        int[] countingSortArray = {1, 3, 2, 1, 3, 2, 2, 3, 3, 2, 3, 1, 0, 2, 0, 1, 3, 2, 1};
        countingSort(countingSortArray);
        System.out.println(Arrays.toString(countingSortArray));

    }

    /**
     * Bubble sort, to njgorszy ze standrdowych algorytmów sortowania.
     * Kiedy widzi dwa elementy nie po kolei, zamienia je miedzy sobą.
     * Zalety: Prosty kod i proste działanie
     * Złożoność obliczeniowa: O(n^2)
     * Złożoność pamięciowa: Omega(1)
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Selection sort ma już więcej sensu, ale też nie jest rewelacyjny.
     * Znajduje najmniejszy element wśród pozostałych, i ustawia go na kolejnym miejscu.
     * Zalety: Mało zamian elementów miejscami
     * Złożoność obliczeniowa: O(n^2)
     * Złożoność pamięciowa: Omega(1)
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * Insertion sort jest trochę bardziej skomplikowany, ale też nie powala.
     * Bierze każdy kolejny element i przesuwa go w tył aż poprzedzająca go nie bedzi mniejsza.
     * Zalety: Logiczne działanie, intuicyjne życiowo
     * Złożoność obliczeniowa: O(n^2)
     * Złożoność pamięciowa: Omega(1)
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * Wygenerowanie n-tego wyrazu ciagu fibonaciego w naiwny rekurencyjny sposób.
     * Metoda wywołuje siebie samą dwa razy.
     * Złożoność obliczeniowa: O(2^n)
     * Złożoność pamięciowa: Omega(1)
     */
    public static int fibonacciRecursive(int number) {
        if (number < 2) {
            return number;
        }
        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }

    /**
     * Wygenerowanie n-tego wyrazu ciągu fibonacciego iteracyjnie.
     * Zawsze pamiętamy dwa ostatnie elementy, bo więcej nie jest potrzebne.
     * Złożoność obliczeniowa: O(n)
     * Złożoność pamięciowa: Omega(1)
     */
    public static int fibonacciInPlace(int number) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < number; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    /**
     * Wygenerowanie n-tego wyrazu ciągu fibonacciego iteracyjnie z dodatkową tablicą.
     * Mamy całą tablicę elementów ciągu gotową do reużycia.
     * Złożoność obliczeniowa: O(n)
     * Złożoność pamięciowa: Omega(1)
     */
    public static int fibonacciInArray(int number) {
        if (number < 2) {
            return 1;
        }
        int[] array = new int[number];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < number; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[number - 1];
    }

    /**
     * Counting sort nie przydaje się przy braku duplikatów elementach.
     * Liczymy ile jest wystąpień każdego elementu i odtwarzamy tablicę.
     * Złożoność obliczeniowa: O(n*m) (n - ilosć elementów, m - największy element)
     * Złożoność pamięciowa: Omega(m)
     */
    public static void countingSort(int[] array) {
        int[] counts = new int[4];
        for (int value : array) {
            counts[value]++;
        }
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < flag + 1; j++) {
                sum += counts[j];
            }
            if (i == sum) {
                flag++;
            }
            array[i] = flag;
        }
    }
}