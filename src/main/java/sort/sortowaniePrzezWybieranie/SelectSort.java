package sort.sortowaniePrzezWybieranie;
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {

        int[] tab = {8, 10, 2, 6, 1, 6};
        System.out.println("Nie posortowane: " + Arrays.toString(tab));
        for (int i = 0; i < tab.length; i++) {

            int minIdx = i;
            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = tab[i];
            tab[i] = tab[minIdx];
            tab[minIdx] = temp;
        }
        System.out.println("Posortowane: " + Arrays.toString(tab));
    }
}
