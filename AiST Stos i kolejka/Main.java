public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] a = new int[10];
        Stos stos = new Stos(a);
        int b =0;
        System.out.println("Stos tablicowy");
        for(int i =0;i<10;i++)
        {
            stos.push(b);
            stos.print();
            b++;
        }
       for(int i =0;i<10;i++)
        {
            stos.pop();
            stos.print();
        }
        stos.print();
        System.out.println("Stos wskaźnikowy");
        StosWsk stosWsk = new StosWsk();
        for(int i =0;i<20;i++)
        {
            stosWsk.push(i);
            stosWsk.print();
        }
        for(int i =0;i<20;i++)
        {
            stosWsk.pop();
            stosWsk.print();
        }
        int [] m = new int[10];
        Fifo fifo = new Fifo(m);
        System.out.println("Fifo tablicowe z modulo");
        for(int i=0;i<10;i++)
        {
            fifo.enqueue(i);
            fifo.print();
        }
        for(int i=0;i<5;i++)
        {
            fifo.dequeue();
            fifo.print();
        }
        for(int i=0;i<5;i++)
        {
            fifo.enqueue(i);
            fifo.print();
        }
        System.out.println();
        System.out.println("Fifo wskaźnikowe");
        FifoWsk fifo1 = new FifoWsk();
        for(int i =0;i<10;i++)
        {
            fifo1.enqueue(i);
            fifo1.print();
        }
        for(int i =0;i<10;i++)
        {
            fifo1.dequeue();
            fifo1.print();
        }
    }
}