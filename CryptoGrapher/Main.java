public class Main {
    public static void main(String[] args) {

//        ROT11 a = new ROT11();
//        String ma =a.crypt("ala ma kota zzz 654333");
//        System.out.println(ma);
//        System.out.println(a.decrypt(ma));
//        Polibiusz z = new Polibiusz();
//        String b =z.crypt("ala ma kota ddd wsqdwqsd zzz");
//        System.out.println(b);
//        System.out.println(z.decrypt(b));
            if(args[2].equals("rot"))
            {
                ROT11 c = new ROT11();
                if(args[3].equals("crypt"))
                {
                    cryptographer a = new cryptographer();
                    a.cryptfile(args[0],args[1],c);
                }
                else if (args[3].equals("decrypt"))
                {
                    cryptographer a = new cryptographer();
                    a.decryptfile(args[0],args[1],c);
                }
                else {
                    System.out.println("blad");
                }

            }
            else if(args[2].equals("Polibiusz"))
            {
                Polibiusz b = new Polibiusz();
                if(args[3].equals("crypt"))
                {
                    cryptographer a = new cryptographer();
                    a.cryptfile(args[0],args[1],b);
                }
                else if (args[3].equals("decrypt"))
                {
                    cryptographer a = new cryptographer();
                    a.decryptfile(args[0],args[1],b);
                }
                else {
                    System.out.println("blad");
                }
            }
            else
            {
                System.out.println("Błędne wywołnie programu");
            }

    }
}