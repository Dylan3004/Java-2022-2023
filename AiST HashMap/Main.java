import java.sql.Time;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int random =0;
        int wielkosc = 1000000;
        int[]tablica = new int[wielkosc];

        for(int i=0;i<wielkosc;i++)
        {
            random=new Random().nextInt(wielkosc);
            tablica[(i+10)%wielkosc]=random;
        }
        Hash_Table hash_table = new Hash_Table(wielkosc/10);
        double start4 = System.currentTimeMillis();
        for(int i=0;i<wielkosc;i++)
        {

            hash_table.put(tablica[i]);

        }
        double end4 = System.currentTimeMillis();
        hash_table.print();
        double start5 = System.currentTimeMillis();
        for(int i =0;i<wielkosc;i++)
        {
            hash_table.search(tablica[new Random().nextInt(wielkosc)]);
        }
        double end5 = System.currentTimeMillis();
        double start6 = System.currentTimeMillis();

        for(int i=wielkosc;i>0;i--)
        {
            hash_table.delite(tablica[new Random().nextInt(wielkosc)]);
        }
        double end6 = System.currentTimeMillis();
        System.out.println("baba jaga");
        hash_table.print();
        OpenHashTable openHashTable = new OpenHashTable(wielkosc);
        double start1 = System.currentTimeMillis();
        for(int i=0;i<wielkosc;i++)
        {
            openHashTable.put(tablica[i]);
        }
        double end1 = System.currentTimeMillis();
        double start2 = System.currentTimeMillis();
        for(int i =0;i<wielkosc;i++)
        {
            openHashTable.search(tablica[new Random().nextInt(wielkosc)]);
        }
        double end2 = System.currentTimeMillis();
        double start3 = System.currentTimeMillis();
        for(int i=0;i<wielkosc;i++)
        {
            openHashTable.delite(tablica[new Random().nextInt(wielkosc)]);
        }
        double end3 = System.currentTimeMillis();




        System.out.println("Czas funkcji haszujacej wglab");
        System.out.println("Funkcja zajela: "+(end4-start4)+" milisekund" );
        System.out.println("Funkcja zajela: "+(end5-start5)+" milisekund" );
        System.out.println("Funkcja zajela: "+(end6-start6)+" milisekund" );
        System.out.println();
        System.out.println("Czas funkcji haszujacej tablicowej");
        System.out.println("Funkcja zajela: "+(end1-start1)+" milisekund" );
        System.out.println("Funkcja zajela: "+(end2-start2)+" milisekund" );
        System.out.println("Funkcja zajela: "+(end3-start3)+" milisekund" );
    }
}