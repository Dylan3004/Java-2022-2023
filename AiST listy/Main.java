import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        List lista = new List();
        List2 listadwukierunkowa = new List2();
        ListaKursorowa kursor = new ListaKursorowa();
        ListaKursorowa2 kursor2 = new ListaKursorowa2();
        ArrayList<List2.Node2> x = new ArrayList<>();
        ArrayList<ListaKursorowa.NodeT> y = new ArrayList<>();
        ArrayList<ListaKursorowa2.NodeT> z = new ArrayList<>();

        int operacje=100000;

        //lista wskaznikowa jednokierunkowa
        long startTime = System.currentTimeMillis();
        for(int i=0;i<operacje;i++)
        {
            List.add(lista,i);
        }
        long endTime = System.currentTimeMillis();
        List.PrintList(lista);
        long startTime1 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            List.find(lista,i);
        }
        long endTime1 = System.currentTimeMillis();
        List.PrintList(lista);
        long startTime2 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            List.delite(lista,i);
        }
        long endTime2 = System.currentTimeMillis();



        //lista wskaznikowa dwukierunkowa
        long startTime3 = System.currentTimeMillis();
        for(int i=0;i<operacje;i++)
        {
           List2.Node2 a= listadwukierunkowa.add(listadwukierunkowa,i);
           x.add(a);
        }
        long endTime3 = System.currentTimeMillis();
        long startTime4 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            List2.find(listadwukierunkowa,i);
        }
        long endTime4 = System.currentTimeMillis();
        long startTime5 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            listadwukierunkowa.delite(listadwukierunkowa,x.get(i));
        }
        long endTime5 = System.currentTimeMillis();





        //lista kursorowa jednokierunkowa
        long startTime6 = System.currentTimeMillis();
        for(int i=0;i<operacje;i++)
        {
            ListaKursorowa.NodeT b = kursor.add(kursor,i);
            y.add(b);
        }
        long endTime6 = System.currentTimeMillis();
        List.PrintList(lista);
        long startTime7 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            kursor.find(i);
        }
        long endTime7 = System.currentTimeMillis();
        long startTime8 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            kursor.delite(kursor,y.get(i));
        }
        long endTime8 = System.currentTimeMillis();





        //lista kursorowa dwukierunkowa
        long startTime9 = System.currentTimeMillis();
        for(int i=0;i<operacje;i++)
        {
            ListaKursorowa2.NodeT c = kursor2.add(i);
            z.add(c);
        }
        long endTime9 = System.currentTimeMillis();
        List.PrintList(lista);
        long startTime10 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            kursor2.find(i);
        }
        long endTime10 = System.currentTimeMillis();
        long startTime11 = System.currentTimeMillis();
        for(int i=operacje-1;i>=0;i--)
        {
            kursor2.delite(z.get(i));
        }
        long endTime11 = System.currentTimeMillis();

        System.out.println("Lista wsaznikowa add:That took " + (endTime - startTime) + " milliseconds");
        System.out.println("Lista wsaznikowa find:That took " + (endTime1 - startTime1) + " milliseconds");
        System.out.println("Lista wsaznikowa delite:That took " + (endTime2 - startTime2) + " milliseconds");
        System.out.println("Lista wsaznikowa dwustronna add:That took " + (endTime3 - startTime3) + " milliseconds");
        System.out.println("Lista wsaznikowa dwustronna find:That took " + (endTime4 - startTime4) + " milliseconds");
        System.out.println("Lista wsaznikowa dwustronna delite:That took " + (endTime5 - startTime5) + " milliseconds");
        System.out.println("Lista kursorowa add:That took " + (endTime6 - startTime6) + " milliseconds");
        System.out.println("Lista kursorowa find:That took " + (endTime7 - startTime7) + " milliseconds");
        System.out.println("Lista kursorowa delite:That took " + (endTime8 - startTime8) + " milliseconds");
        System.out.println("Lista kursorowa dwustronna add:That took " + (endTime9 - startTime9) + " milliseconds");
        System.out.println("Lista kursorowa dwustronna find:That took " + (endTime10 - startTime10) + " milliseconds");
        System.out.println("Lista kursorowa dwustrona delite:That took " + (endTime11 - startTime11) + " milliseconds");



//        List2 listadwukierunkowax = new List2();
//        List2.Node2 b=listadwukierunkowa.insert1(listadwukierunkowa,5);
//        listadwukierunkowa.insert1(listadwukierunkowa,3);
//        List2.Node2 a =listadwukierunkowa.insert1(listadwukierunkowa,3);
//        listadwukierunkowax.insert1(listadwukierunkowa,3);
//        listadwukierunkowa.insert1(listadwukierunkowa,4);
//        listadwukierunkowa.delite(listadwukierunkowa,b);
//        listadwukierunkowax.find(listadwukierunkowax,3);
//        List2.PrintList(listadwukierunkowa);
//
//        ListaKursorowa2 kursor = new ListaKursorowa2();
//        kursor.insert(4);
//        kursor.insert(5);
//        kursor.insert(6);
//        ListaKursorowa2.NodeT a = kursor.insert(7);
//        kursor.insert(8);
//        kursor.PrintList();
//        kursor.delite(a);
//        kursor.PrintList();
//        kursor.find(4);
    }
}