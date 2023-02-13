public class Main {
    public static void main(String[] args) {
        //wywolnie obiektu z argumentem metody statycznej
    Pesel pesel = new Pesel(Pesel.New_Pesel(args[0]));
    Pesel.check(pesel.get());
    System.out.println(pesel.get());
    Pesel pesel1 = new Pesel(Pesel.New_Pesel(args[1]));
    Pesel.check(pesel1.get());
    System.out.println(pesel1.get());
    //sprawdzenie zgodnosci peseli
    pesel.compare(pesel1);
    }

}