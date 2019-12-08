package zajecia1.sort.zlozonoscObliczeniowaFibonacci;

public class Main {
    public static void main(String[] args) {
        System.out.println(rekurencyjnie(1));
        System.out.println(iteracyjnie(1));
    }

    private static int rekurencyjnie(int liczbaciagu) {
        if (liczbaciagu < 2) {
            return 1;
        } else return rekurencyjnie(liczbaciagu - 1) + rekurencyjnie(liczbaciagu - 2);
    }

    private static int iteracyjnie(int liczbaciagu) {
        int elementA = 0; // zmienne pomocnicze symbolizujące
        int elementB = 1; // element poprzedni B i jeszcze wcześniejszy A
        int wynik = 0; // zmienna wynik, pod którą podstawimy obliczoną wartość

        for (int i = 1; i <= liczbaciagu; i++) {
            wynik = elementA + elementB; // pod wynik podstawiamy sumę poprzednich elementów
            elementA = elementB; // modyfikujemy zmienne przechowujące
            elementB = wynik;  // dwie ostatnie wartości
        }
        return wynik; // zwracamy wynik
    }
}

