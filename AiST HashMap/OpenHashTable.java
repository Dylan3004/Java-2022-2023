import java.util.Arrays;

public class OpenHashTable {

    private int[] tab;
    private int[]vacium;
    private int[]values;
    int length;
    OpenHashTable(int length)
    {
        this.length=length;
        this.tab=new int[length];
        this.vacium=new int[length];
        Arrays.fill(vacium, 0);

    }
    public void put(int number)
    {

       if(vacium[number%tab.length]==0)
       {
           tab[number% tab.length]=number;
           vacium[number% tab.length]=1;

       }
       else
       {
           int i=number+1;
           int j=0;
           while(vacium[i% tab.length]!=0)
           {
               i++;
               j++;
               if(j==tab.length)
               {
                   System.out.println("Cala tablica jest pelna");
                   return;
               }
           }
           tab[i% tab.length]=number;
           vacium[i% vacium.length]=1;
       }

    }
    public void search(int number)
    {
        // ten sposób teoretycznie powinien zapewniac szybsze przeszukiwanie tablicy
        for(int i=number;i<tab.length+number;i++)
        {
            if(tab[i% tab.length]==number)
            {
                System.out.println("Znaleziono liczbę "+number+" na pozycji: "+i%tab.length);
                return;
            }
        }
        System.out.println("Nie znaleziono liczby: "+number);
    }
    public void delite(int number)
    {
        for(int i =number;i<tab.length+number;i++)
        {
            if(tab[i%tab.length]==number && !(vacium[i% tab.length]==0))
            {
                vacium[i% tab.length]=0;
                System.out.println("Poprawnie usunięto liczbę "+number+" na pozycji: "+i);
                return;
            }
        }
        System.out.println("Nie znaleziono liczby: "+number);
    }
    public void print ()
    {
        for(int i =0;i<tab.length;i++)
        {
            if(vacium[i]==1)
            {
                System.out.print(" "+tab[i]);
            }
        }
        System.out.println();
    }
    public void print_vacume()
    {
        for(int i=0;i< vacium.length;i++)
        {
            System.out.print(" "+vacium[i]);
        }
        System.out.println();
    }


}
