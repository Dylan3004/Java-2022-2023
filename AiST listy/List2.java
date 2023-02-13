public class List2 {


    Node2 head;
    static class Node2{

        int liczba;
        Node2 nastepny;
        Node2 wczesniejszy;
        Node2(int liczba)
        {
            this.liczba=liczba;
            nastepny=null;
            wczesniejszy=null;
        }
    }

    public Node2 add(List2 lista, int liczba_dodana)
    {
        Node2 node = lista.head;
        Node2 dodany = new Node2(liczba_dodana);
        if(lista.head==null)
        {
            lista.head=dodany;
            return dodany;

        }
        else
        {
            dodany.nastepny=lista.head;
            lista.head.wczesniejszy=dodany;
            lista.head=dodany;
        }
        return dodany;

    }
    public List2 delite (List2 lista,Node2 node)
    {


        if(node== lista.head)
        {
            lista.head=node.nastepny;
            return lista;
        }
        node.wczesniejszy.nastepny=node.nastepny;
        if(node.nastepny != null)
        {
            node.nastepny.wczesniejszy=node.wczesniejszy;
        }

        return lista;
    }

    public static int find(List2 lista,int szukana)
    {
        Node2 node = lista.head;
        int i=0;
        while(true)
        {
            if(node.liczba==szukana)
            {
                System.out.println("Znaleziono liczbe na pozycji "+i+" w liscie");
                return i;
            }
            if(node.nastepny==null)
            {
                System.out.println("nie znaleziono elementu error");
                return i=-1;
            }
            node = node.nastepny;
            i++;
        }

    }

    public static void PrintList(List2 list)
    {
        List2.Node2 node = list.head;

        while(node.nastepny!=null)
        {
            System.out.print(node.liczba +",");
            node=node.nastepny;
        }
        System.out.println(node.liczba);
    }
}
