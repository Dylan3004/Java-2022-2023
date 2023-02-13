public class Fifo {

    Node start;
    static class Node{

        int liczba;
        Node nastepny;
        Node(int liczba)
        {
            this.liczba=liczba;
            nastepny=null;
        }
    }

    boolean is_Empty()
    {
        if(start==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void enqueue(int numer)
    {
        if(start == null)
        {
            start = new Node(numer);
        }
        else
        {
            Node temp = start;
            while (temp.nastepny!=null)
            {
                temp=temp.nastepny;
            }
            temp.nastepny=new Node(numer);
        }
    }
    void dequeue()
    {
        start=start.nastepny;
    }
    void print()
    {
        Node temp = start;
        while (temp!=null)
        {
            System.out.print(temp.liczba);
            temp=temp.nastepny;
        }
        System.out.println();
    }
}
