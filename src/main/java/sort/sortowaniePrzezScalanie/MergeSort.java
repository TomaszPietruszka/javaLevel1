package sort.sortowaniePrzezScalanie;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] tab = {6, 5, 4, 5, 6, 7, 8};
        divideArrays(tab);
    }

    static int[] divideArrays(int[] tablica) {
        int dlugosctablicy = tablica.length /2;
        int[] tab1 = new int[tablica.length / 2];
        int[] tab2 = new int[tablica.length- dlugosctablicy ];

        if (tablica.length > 2) {
            for (int i = 0; i < tablica.length / 2; i++) {
                tab1[i] = tablica[i];
            }
            for (int i = tablica.length / 2; i < tablica.length; i++) {
                tab2[i - tablica.length / 2] = tablica[i];
            }
            tab1 = divideArrays(tab1);
            tab2 = divideArrays(tab2);


        } else if (tablica.length == 2) {
            if (tablica[0] > tablica[1]) {
                int temp = tablica[0];
                tablica[0] = tablica[1];
                tablica[1] = temp;
            }
            return tablica;
        } else {
            return tablica;
        }

        System.out.println(Arrays.toString(tab1));
        System.out.println(Arrays.toString(tab2));
        return tablica;
    }
}
