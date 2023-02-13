public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(4);
        tree.print();
        tree.insert(3);
        tree.print();
        tree.insert(8);
        tree.print();
        tree.insert(1);
        tree.print();
        tree.insert(16);
        tree.print();
        tree.insert(32);
        tree.print();
        tree.insert(12);
        tree.print();
        tree.insert(10);
        tree.print();
        tree.insert(2);
        tree.print();


        System.out.println();
        tree.delete(8);
        tree.print();
        tree.delete(4);
        tree.print();
        tree.delete(16);
        tree.print();
        if(tree.search(32) )
        {
            System.out.println("Jest");
        }
        else
        {
            System.out.println("Nie ma");
        }
        if(tree.search(2) )
        {
            System.out.println("Jest");
        }
        else
        {
            System.out.println("Nie ma");
        }
        System.out.println();
        tree.delete(3);
        tree.print();
        tree.delete(12);
        tree.print();
        tree.delete(10);
        tree.print();
        tree.delete(1);
        tree.print();
        tree.delete(2);
        tree.print();
        tree.delete(32);
        tree.print();
        tree.delete(20);
    }

}