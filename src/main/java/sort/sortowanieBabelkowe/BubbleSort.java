package sort.sortowanieBabelkowe;

public class BubbleSort {
    public static void main(String[] args) {
        int[] tab = {1, 2, 3, 4, 5,};
        int i;
        int j;
        int temp;

        boolean sort = false;
        for (i = 0; i < tab.length - 1 &&!sort; i++) {
            sort = true;
            for (j = 0; j < tab.length - 1; j++)
                if (tab[j] > tab[j + 1]) {
                } else {
                    sort = false;
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                }
        }
        System.out.println("Posortowana tablica: ");
        for (i = 0; i < tab.length; i++) System.out.print(tab[i] + " ");
    }
}
