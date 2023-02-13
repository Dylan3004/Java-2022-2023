public class StosWsk {


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

    void push(int numer)
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
    void pop()
    {
        while(true)
        {
            if(start.nastepny==null)
            {
                start=null;
                break;
            }
            Node temp = start;
            Node ontop = start;
            while(temp.nastepny!=null)
            {
                temp=temp.nastepny;
            }
            while(ontop.nastepny!=temp)
            {
                ontop=ontop.nastepny;
            }
            ontop.nastepny=null;
            break;
        }


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
