public class Main {
    public static void main(String[] args) {

        String jeden="2x^3+17x^0";
        String dwa = "3.45x^3+0.4334x^2";
        String trzy ="81x^4-33x^3+44x^2+12x^1-80x^0";
        String cztery="23x^0-12x^1";
        Polynomial polynomial1 = new Polynomial(jeden);
        System.out.println();
        Polynomial polynomial2 = new Polynomial(dwa);
        System.out.println();
        Polynomial polynomial3 = new Polynomial(trzy);
        System.out.println();
        Polynomial polynomial4 = new Polynomial(cztery);
        System.out.println();

//        StringBuilder builder = new StringBuilder();
//        for (String str: args)
//        {
//            builder.append(str).append(" ");
//        }
//        String ciag = builder.toString();
//        Polynomial polynomial = new Polynomial(ciag);
//        polynomial.show();
        double[] tablica1 =polynomial1.mul(polynomial2.tab);
        double[] tablica2 =polynomial2.sub(polynomial3.tab);
        double[] tablica3 = polynomial3.add(polynomial4.tab);
        double wynik = polynomial3.horner(13);
        System.out.println();
        System.out.println("Mnożenie");
        for (double v : tablica1) {
            System.out.print(v + ",");
        }
        System.out.println();
        System.out.println("Odejmowanie");
        for (double v : tablica2) {
            System.out.print(v + ",");
        }
        System.out.println();
        System.out.println("Dodawanie");
        for (double v : tablica3) {
            System.out.print(v + ",");
        }
        System.out.println();
        System.out.println("Wartość w punkcie");
        System.out.println(wynik);
//        for(int i=0;i< tablica.length;i++)
//        {
//            System.out.println(tablica[i]);
//        }
         //polynomial1.showstring();
         //polynomial1.show();
         //double[] wynik = polynomial1.mul(polynomial2.tab);
//         for(int i=0;i< wynik.length;i++)
//         {
//             System.out.println(wynik[i]);
//         }
        //System.out.println(polynomial1.horner(3));
    }
}