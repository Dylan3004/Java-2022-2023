import java.util.ArrayList;

public class ListaKursorowa2 {


    ArrayList<ListaKursorowa2.NodeT> wartosci = new ArrayList<>();
    ArrayList<ListaKursorowa2.NodeT> pusta = new ArrayList<>();
    ListaKursorowa2.NodeT head = null;

    public class NodeT {

        int index;
        int value;
        int next;
        int prev;

        public NodeT(int indeks, int value) {
            this.index = indeks;
            this.value = value;
            this.next = -1;
            this.prev = -1;
        }
    }

    public ListaKursorowa2.NodeT add(int wartosc)
    {
        ListaKursorowa2.NodeT node = new ListaKursorowa2.NodeT(wartosci.size(),wartosc);
        if(pusta.size()!=0)
        {
            node=pusta.remove(pusta.size()-1);
            node.value=wartosc;
            node.next=-1;
            node.prev=-1;
        }
        else
        {
            wartosci.add(node);
        }
        if(head==null)
        {
            head=node;
            return node;
        }
        else {
            node.next=head.index;
            head.prev=node.index;
            head=node;
        }
        return node;
    }


    public void delite ( ListaKursorowa2.NodeT node)
    {

        pusta.add(node);
        if(head==node)
        {
            if(node.next!=-1)
            {
                head=wartosci.get(node.next);
                head.prev=-1;
            }
            else {
                head=null;
            }
            return;
        }
        wartosci.get(node.prev).next=node.next;
        if(node.next!=-1)
        {
            wartosci.get(node.next).prev=node.prev;
        }

    }



    public void PrintList ()
    {
        if(head==null)
        {
            System.out.println("Lista nie przechowuje zadnej wartosci");
            return;
        }
        ListaKursorowa2.NodeT temp = head;
        while(temp!=null)
        {
            System.out.print(temp.value+",");
            if(temp.next!=-1)
            {
                temp=wartosci.get(temp.next);
            }
            else
            {

                break;
            }
        }
        System.out.println();
    }
    public int find(int wartosc)
    {
        int i =0;
        if(head==null)
        {
            System.out.println("Lista nie przechowuje zadanej wartosci");
            return -1;
        }
        ListaKursorowa2.NodeT temp = head;
        while(temp!=null)
        {
            if(temp.value==wartosc)
            {
                System.out.println("Znaleziono wartosc na pozycji "+i);
                break;

            }
            if(temp.next!=-1)
            {
                temp=wartosci.get(temp.next);
            }
            else
            {

                temp=null;
            }
            i++;
        }
        System.out.println();
        return -1;
    }
}