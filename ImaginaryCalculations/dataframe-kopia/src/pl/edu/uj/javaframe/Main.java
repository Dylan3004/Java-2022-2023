package pl.edu.uj.javaframe;
import java.util.HashSet;

import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        DataFrame df = new DataFrame(new Class[] {MyImaginaryDouble.class, Int.class}, new String[] {"kol1","kol2"});

        df.addRow(new String[]{"12i3","23"});
        df.addRow(new String[]{"1244i4","23"});
        df.addRow(new String[]{"1244i6","2553"});
        df.addRow(new String[]{"12i9","2300"});

        MyImaginaryDouble im1 = (MyImaginaryDouble) new MyImaginaryDouble().create("12i3");
        MyImaginaryDouble im2 = (MyImaginaryDouble) new MyImaginaryDouble().create("5i3");
        MyImaginaryDouble im3 = (MyImaginaryDouble) new MyImaginaryDouble().create("5");
        MyDouble re = (MyDouble) new MyDouble().create("5");
        Int in =(Int) new Int().create("7");
        Int inn =(Int) new Int().create("2");
        MyDouble xx = (MyDouble) new MyDouble().create("2.55");
        MyDouble x = (MyDouble) new MyDouble().create("4.15");
        MyImaginaryInt aaa= (MyImaginaryInt) new MyImaginaryInt().create("21i3");
        MyImaginaryInt aaaa= (MyImaginaryInt) new MyImaginaryInt().create("21i3");
        System.out.println("Int:");
        System.out.println("Odejmowanie:"+ inn.sub(in));
        System.out.println("Mnozenie:"+ inn.mul(in));
        System.out.println("Dzielenie:"+ inn.div(in));
        System.out.println("Potegowanie:"+ inn.pow(in));
        System.out.println("eq:"+ inn.eq(in));
        System.out.println("lte:"+ inn.lte(in));
        System.out.println("gte:"+ inn.gte(in));
        System.out.println("neq:"+ inn.neq(in));
        System.out.println("equals:"+ inn.equals(in));
        System.out.println("HashCode:"+ inn.hashCode());
        System.out.println();
        System.out.println("MyDouble:");
        System.out.println("Odejmowanie:"+ x.sub(xx));
        System.out.println("Mnozenie:"+ x.mul(xx));
        System.out.println("Dzielenie:"+ x.div(xx));
        System.out.println("Potegowanie:"+ x.pow(xx));
        System.out.println("eq:"+ x.eq(xx));
        System.out.println("lte:"+ x.lte(xx));
        System.out.println("gte:"+ x.gte(xx));
        System.out.println("neq:"+ x.neq(xx));
        System.out.println("equals:"+ x.equals(xx));
        System.out.println("HashCode:"+ x.hashCode());
        System.out.println();




        System.out.println("MyImaginaryInt:");
        System.out.println("Odejmowanie:"+ aaa.sub(aaaa));
        System.out.println("Odejmowanie:"+ inn.sub(aaaa));
        System.out.println("Mnozenie:"+ aaa.mul(aaaa));
        System.out.println("Dzielenie:"+ aaa.div(aaa));
        System.out.println("Potegowanie:"+ aaa.pow(in));
        System.out.println("eq:"+ aaa.eq(aaaa));
        System.out.println("lte:"+ aaa.lte(aaaa));
        System.out.println("gte:"+ aaa.gte(aaaa));
        System.out.println("neq:"+ aaa.neq(aaaa));
        System.out.println("equals:"+ aaa.equals(aaaa));
        System.out.println("HashCode:"+ aaa.hashCode());
        System.out.println();
        System.out.println("MyImaginaryDouble:");
        System.out.println("Odejmowanie:"+ im1.sub(im2));
        System.out.println("Mnozenie:"+ im1.mul(im2));
        System.out.println("Dzielenie:"+ im1.div(im2));
        System.out.println("Potegowanie:"+ im1.pow(re));
        System.out.println("eq:"+ im1.eq(im2));
        System.out.println("lte:"+ im1.lte(im2));
        System.out.println("gte:"+ im1.gte(im2));
        System.out.println("neq:"+ im1.neq(im2));
        System.out.println("equals:"+ im1.equals(im2));
        System.out.println("HashCode:"+ im1.hashCode());
        System.out.println();
        //aaaa.mul(aaa).print();
        //System.out.println(in.hashCode());
        System.out.println();

        im1.print();
        System.out.println();
        im2.print();
        System.out.println();
        re.add(im2).print();
        System.out.println();
        System.out.println("------------------------------");
        df.print();
        System.out.println(im2.toString());
//      INSTRUKCJE DO ĆWICZEŃ I

//      Dopisz metodę print w klasie DataFrame wypisującą zawartość dataframe
//      df.print();

//      Dodaj klasę ImaginaryDouble oraz ImaginaryInt, które dziedziczą po odpowiednio klasach Int i Double . Powinne one być tworzone ze Stringów postaci "<CzęśćRzeczywissta>i<CzęśćUrojona>", np "12i3".

//      Nadpisz metody create i add w klasach ImaginaryDoubgle oraz ImaginaryInt. Pamiętaj, że do liczb urojonych możemy też dodawać inne typy (np. Int, Double).
//      Przetestuj wyniki operacji:
        //        ImaginaryInt.create("12i4").add(Int.create("10"))
        //        Int.create("10").add(ImaginaryInt.create("12i4")))
        //        ImaginaryInt.create("12i4").add(ImaginaryInt.create("10i10"))

//      Nadpisz metodę public String toString() w kasach ImaginaryDouble i ImaginaryInt, tak aby poprawnie wyświetlała liczby urojone do postaci Stringa




        }


}