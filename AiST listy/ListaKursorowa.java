import java.util.ArrayList;

public class ListaKursorowa {

    ArrayList<NodeT> wartosci= new ArrayList<>();
    ArrayList<NodeT> pusta=new ArrayList<>() ;
    NodeT head=null;


    public class NodeT{

        int index;
        int value;
        int next;
       public NodeT(int indeks , int value )
        {
            this.index=indeks;
            this.value=value;
            this.next=-1;
        }
    }


    public NodeT add(ListaKursorowa list , int wartosc)
    {
        NodeT node = new NodeT(wartosci.size(),wartosc);
        if(pusta.size()!=0)
        {
            node=pusta.remove(pusta.size()-1);
            node.value=wartosc;
            node.next=-1;
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
            head=node;
        }
        return node;
    }
    public void delite (ListaKursorowa list , NodeT node)
    {
        if(head==null)
        {
            System.out.println("Lista nie przechowuje zadnej wartosci");
            return;
        }
        NodeT temp = head;
        NodeT wczesniejszy = null;

        if(temp==node)
        {
            if(wartosci.size()==1)
            {
                wartosci.remove(wartosci.size()-1);
                head=null;
            }
            else {
                pusta.add(temp);
                if(temp.next!=-1)
                {
                    head=wartosci.get(temp.next);
                    temp.next=-1;
                }
                else {
                    head=null;
                }

            }
            return;
        }
        while(temp!=null)
        {
            if(temp==node)
            {
                wczesniejszy.next= temp.next;
                pusta.add(temp);
                return;
            }
            wczesniejszy=temp;
            if(temp.next!=-1)
            {
                temp=wartosci.get(temp.next);
            }
            else
            {
                break;
            }

        }



    }
    public void PrintList ()
    {
        if(head==null)
        {
            System.out.println("Lista nie przechowuje zadnej wartosci");
            return;
        }
        NodeT temp = head;
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
        NodeT temp = head;
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
