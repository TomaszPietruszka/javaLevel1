package sort.sortowaniePrzezZliczanie;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] tab = {1, 2, 3, 1, 2, 3, 3, 2, 2, 1, 2, 3, 2, 2};

        int[] wynik = new int[tab.length];

        int[] array = new int[3];

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 1) {
                array[0]++;
            } else if (tab[i] == 2) {
                array[1]++;
            } else if (tab[i] == 3) {
                array[2]++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i < array[0]) {
                array[0] = 1;
            } else if (i < array[1] && i > array[0]) {
                array[1] = 2;
            } else if (i < array[2] && i > array[1]) {
                array[2] = 3;

//        for(int i = 0; i < array[0]; i++) {
//            wynik[i] = 1;
//        }
//        for(int i = array[0]; i < array[2] + array[1]; i++) {
//            wynik[i] = 2;
//        }
//        for(int i = array[1] + array[0]; i < array[2] + array[1] + array[0]; i++) {
//            wynik[i] = 3;
//        }

                System.out.println("jeden: " + array[0] + " " + "dwa " + array[1] + " " + "trzy" + array[2]);

                System.out.println("posortowana" + Arrays.toString(wynik));
            }

        }
    }
}
