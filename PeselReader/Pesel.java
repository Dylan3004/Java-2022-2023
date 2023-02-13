

import java.util.Random;
import java.util.Scanner;

public class Pesel {
    String pesel;


    Pesel(String pesel){
        this.pesel=pesel;
    }
    static boolean check(String pesel)
    {
        //input
        int tempint;
        int tempint2;
        int suma = 0;


            for(int i = 0; i< pesel.length()-1; i++)
            {
                //algorytm na zgodnosc cyfr peselu
                tempint =Integer.parseInt(pesel.substring(i,i+1));
                //System.out.println(tempint);
                tempint2 =tempint*((1+(2*i))%10);
                suma+=tempint2;
                //System.out.println(suma);
            }
            //sprawdzenie cyfry jednosci powstalej z zastosowania algorytmu i ostatniej cyfry
            if(((suma)%10)!=Integer.parseInt(pesel.substring(10,11)))
            {
                System.out.println((suma)%10+" =//= "+ pesel.substring(10,11));
                System.out.println("Pesel jest nieprawidlowy");

                return false;
            }
            else
            {
                System.out.println((suma)%10+" = "+ pesel.substring(10,11));
                System.out.println("Pesel jest prawidlowy");

                return true;
            }

    }
    static String New_Pesel(String temp) {
        //System.out.print("Wpisz Pesel:");
        boolean good_pesel = false;
        //String temp = null;
        while (!good_pesel) {
            //Scanner scaner = new Scanner(System.in);
            //temp = scaner.nextLine();

            if (temp.length() != 11) {
                System.out.println("Nieprawidlowa ilosc cyfr");
            } else {
                good_pesel = true;
            }


        }
        return temp;

    }
    boolean compare(Pesel pesel1)
    {
        String temp3 = pesel1.get();
        if(0==pesel.compareTo(temp3))
        {
            System.out.println("Pesele sa takie same");
            return true;
        }
        else
        {
            System.out.println("Pesele sa rozne");
            return false;
        }
    }
    String get()
    {
        return pesel;
    }

}
