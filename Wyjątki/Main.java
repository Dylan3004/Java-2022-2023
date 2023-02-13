import java.io.*;

public class Main {

    FileWriter writer = null;
    public static void main(String[] args) {

        //read(args[0],args[1],Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        int delay=0;
        int fps=0;
        int i=1;
        try{
            delay=Integer.parseInt(args[2]);
            if(delay<0)
            {
            throw new NegativeNumberExeption();
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Podane opoznienie nie jest liczba");
            return;
        }
        catch (NegativeNumberExeption e)
        {
            System.out.println("Podane opoznienie jest ujemne");
            return;
        }
        try{
            fps=Integer.parseInt(args[3]);
            if(fps<0)
            {
                throw new NegativeNumberExeption();
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Exeption:Podane liczba fps nie jest liczba");
            return;
        }
        catch (NegativeNumberExeption e)
        {
            System.out.println("Exeption:Podany fps jest ujemny");
            return;
        }


        FileWriter writer = null;
        try {
            writer = new FileWriter(args[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder input=new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line ="";
            while (true) {
                try {
                    if (((line = bufferedReader.readLine()) != null))
                    {
                        String liczba=line.substring(line.indexOf("{")+1, line.indexOf("}"));
                        String liczba1 =line.substring(line.indexOf("{",line.indexOf("{")+1)+1,line.indexOf("}",line.indexOf("}")+1));
                        String tekst= delay(liczba,liczba1, delay,fps)+line.substring(line.indexOf("}",line.indexOf("}")+1)+1);

                        writer.write(tekst+"\n");

                        input.append(line);
                    }
                    else
                    {

                        break;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Exeption:Podana klatka nie jest liczba w "+i+"linii");
                }
                catch (ArithmeticException e)
                {
                    System.out.println("Exeption:Wpisany fps jest zerem!");
                    return;
                }
                catch (NuberPositiveValueExeption e)
                {
                    System.out.println("Exeption:Podana klatka w linii "+i+" jest ujemna");
                }
                catch (CorrectNumberValueExeption e)
                {
                    System.out.println("Exeption:Podana klatka poczatkowa jest wieksza badz rowna klatce koncowej w "+i+" linii");
                }
                catch (StringIndexOutOfBoundsException e)
                {
                    System.out.println("Exeption:Podana klatka zostala niepoprawnie podana w nawiasach w "+i+" linii");
                    return;
                }
                catch (NumerExistExeption e)
                {
                    System.out.println("Exeption:Brak numeru klatki w pliku w "+i+" linii");
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
                catch (Exception e)
                {
                    System.out.println("awokado "+i);
                    //System.out.println("Exeption:Podana klatka zostala niepoprawnie podana w nawiasach w "+i+" linii");
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String delay(String in, String out,int delay, int fps) throws NumberFormatException,ArithmeticException ,NuberPositiveValueExeption,CorrectNumberValueExeption, NumerExistExeption
    {
        if(in.length()==0|| out.length()==0)
        {
           throw new NumerExistExeption();
        }
        int klatka = Integer.valueOf(in)-delay/(fps/2);
        int klatka1 = Integer.valueOf(out)+delay/(fps/2);
        String koncowy = "{"+klatka+"}"+"{"+klatka1+"}";
        if(klatka<0 || klatka1<0)
        {
            throw new NuberPositiveValueExeption();
        }
        if(klatka>=klatka1)
        {
            throw new CorrectNumberValueExeption();
        }
        return koncowy;
    }
}


