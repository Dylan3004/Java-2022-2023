import java.util.ArrayList;
import java.util.Vector;

public class Prime {


    public static ArrayList<Integer> first(int zakres1, int zakres2)
    {
        ArrayList<Integer>lista = new ArrayList<>();
        for (int i = zakres1; i < zakres2; i++) {

            int podzielnik = 2;


            boolean liczbaPierwsza = true;

            if (i > 3) {

                while (podzielnik < i) {
                    if (i % podzielnik == 0) {

                        liczbaPierwsza = false;break;

                    }
                    podzielnik++;}

            }
            if (liczbaPierwsza) {

                //System.out.println("Liczba pierwsza: " + i);
                lista.add(i);
            }

        }
        return lista;
    }
}
