public class List {

    Node head;
    static class Node{

        int liczba;
        Node nastepny;
        Node(int liczba)
        {
            this.liczba=liczba;
            nastepny=null;
        }
    }

    public static List add(List list ,int liczba_dodana)
    {
        Node node_dodany = new Node(liczba_dodana);
        if(list.head==null)
        {
            list.head=node_dodany;
        }
        else
        {
            node_dodany.nastepny=list.head.nastepny;
            list.head.nastepny=node_dodany;
        }
        return list;
    }
    public static int find(List lista,int szukana)
    {
        Node node = lista.head;
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
                System.out.println("nie znaleziono elementu");
                i=-1;
                return i;
            }
            node = node.nastepny;
            i++;
        }

    }
    public static List delite(List lista,int usuwana)
    {
        Node node =lista.head;
        int i=0;
        while(true)
        {
            if(node.nastepny==null)
            {
                System.out.println("blad: Podana liczba nie znajduje sie na liscie");
                break;
            }
            if(node.nastepny.liczba==usuwana)
            {
                node.nastepny=node.nastepny.nastepny;
                System.out.println("Liczba zostala usunieta z pozycji "+i);
                break;
            }
            node=node.nastepny;
            i++;
        }
        return lista;
    }
    public static void PrintList(List list)
    {
        Node node = list.head;

        while(node.nastepny!=null)
        {
            System.out.print(node.liczba +",");
            node=node.nastepny;
        }
        System.out.println(node.liczba);
    }
}


