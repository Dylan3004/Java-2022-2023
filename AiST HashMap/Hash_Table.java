import java.util.ArrayList;
import java.util.List;

public class Hash_Table {

    private int deaph ;
    private List<Integer>[] data ;

    Hash_Table(int size )
    {
        this.data = new ArrayList[size];
        this.deaph=0;
    }
    public int hash(int number )
    {
        return number%data.length;
    }
    public void put(int number)
    {
        int index =hash(number);
        if(data[index]!=null)
        {
            data[index].add(number);
            deaph++;
            return;
        }
        data[index]= new ArrayList<>();
        data[index].add(number);
    }
    public void search(int number)
    {
        int j=0;
        int index = hash(number);
        if(data[index]==null)
        {
            System.out.println("Nie ma takiej liczby na liscie");
            return;
        }
        boolean is_it=false;
        for(int i =0;i<data[index].size();i++)
        {
            j =i;
            if (data[index].get(i).equals(number)) {
                is_it = true;
                break;
            }
        }
        if(is_it)
        {
            System.out.println("Liczba jest w tablicy w komorce: "+index+" i glebokosci: "+j);
        }
        else
        {
            System.out.println("Liczby nie ma w tablicy");
        }
    }
    public void delite(int number)
    {
        int j=0;
        int index = hash(number);
        if(data[index]==null)
        {
            System.out.println("Nie ma takiej liczby na liscie");
            return;
        }
        boolean is_it=false;
        for(int i =0;i<data[index].size();i++)
        {
            j=i;
            if (data[index].get(i).equals(number)) {
                data[index].remove(i);
                is_it = true;
                break;
            }
        }
        if(is_it)
        {
            System.out.println("Liczba "+number+" zostala poprawnie usunieta z komorki: "+index+"oraz glebokosci: "+j );
        }
        else
        {
            System.out.println("Liczby nie ma w tablicy");
        }
    }
    public void print()
    {
        for(int i=0;i<data.length;i++)
        {
            if(data[i]!=null)
            {
                System.out.println("Komorka:"+i);
                for(int j=0;j<data[i].size();j++)
                {
                    System.out.print(" ,"+data[i].get(j));
                }
            }
            System.out.println();
        }
    }


}
