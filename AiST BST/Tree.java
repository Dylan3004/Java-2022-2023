import java.util.ArrayList;

public class Tree {

    Node root;
    static class Node{

        int liczba;
        Node left;
        Node right;
        Node(int liczba)
        {
            this.liczba=liczba;
            left=null;
            right=null;
        }
    }

    public void insert (int dodana)
    {
        if(root==null)
        {
            root=new Node(dodana);
        }
        else
        {
            Node temp = root;
            while (true)
            {
                if(temp.liczba>dodana)
                {
                    if(temp.right==null)
                    {
                        temp.right=new Node(dodana);
                        break;
                    }
                    else
                    {
                        temp=temp.right;
                    }
                }
                else
                {
                    if(temp.left==null)
                    {
                        temp.left=new Node(dodana);
                        break;
                    }
                    else
                    {
                        temp=temp.left;
                    }
                }
            }
        }
    }

    public boolean search(int szukana)
    {
        int i = 0;
        int j = 0;
        Node temp = root;
        if(temp.liczba==szukana)
        {
            return true;
        }
        else
        {
            while (true)
            {
                if (temp.liczba>szukana)
                {
                    i++;
                    if(temp.right==null)
                    {
                        return false;
                    }
                    temp=temp.right;
                }
                else if (temp.liczba<szukana)
                {
                    j++;
                    if(temp.left==null)
                    {
                        return false;
                    }
                    temp=temp.left;
                }
                else
                {
                    System.out.println("i:"+i +"j:"+ j);
                    return true;
                }
            }
        }
    }

    public void delete (int liczba) {
        // father of temp zapisac i iterowac go za kazdym razem jak temp jest iterowany 
        ArrayList<String>lista = new ArrayList<>();
        lista.add("Początek");
        Node temp = root;
        Node temp_father = root;
        int z = 0;
        if (root==null)
        {
            System.out.println("Drzewo jest puste wiec nie mozna niczego z niego usunac");
            return;
        }
        if(temp.liczba==liczba && temp.right==null && temp.left==null)
        {
            root=null;
            return;
        }
        else {
            while (true)
            {
                if (temp.liczba>liczba)
                {
                    if(z!=0)//sprawdzam czy zostal wykonany pierwszy krok przez tempa
                    {// zabieram poprzednia wartosc z listy zeby przejsc poprzedni krok temp , za pomoca temp_father
                        if(lista.get(0).equals("left"))
                        {
                            temp_father=temp_father.left;
                        }
                        if(lista.get(0).equals("right"))
                        {
                            temp_father=temp_father.right;
                        }
                    }//nadpisuje aktualny krok tempa
                    lista.set(0,"right");
                    if(temp.right==null)
                    {
                        System.out.println("nie ma takiej liczby");
                        return ;
                    }
                    temp=temp.right;
                    z++;
                }
                else if (temp.liczba<liczba)
                {
                    if(z!=0)
                    {
                        if(lista.get(0).equals("left"))
                        {
                            temp_father=temp_father.left;
                        }
                        if(lista.get(0).equals("right"))
                        {
                            temp_father=temp_father.right;
                        }
                    }
                    lista.set(0,"left");
                    if(temp.left==null)
                    {
                        System.out.println("nie ma takiej liczby");
                        return ;
                    }
                    temp=temp.left;
                    z++;
                }
                //znaleziona
                else {
                    Node temp1 = temp;
                    if (temp1.left != null) {
                        temp1 = temp1.left;
                        if(temp1.right!=null)
                        {
                            while (temp1.right.right != null) {
                                temp1 = temp1.right;
                            }
                            temp.liczba = temp1.right.liczba;
                            temp1.right = null;
                        }
                       else
                        {
                            temp.liczba=temp1.liczba;
                            temp.left=temp1.left;
                        }

                        break;
                    } else if (temp1.right != null) {
                        temp1 = temp1.right;
                        //System.out.println(temp1.right.liczba);
                        if(temp1.left!=null)
                        {
                            while (temp1.left.left != null) {
                                temp1 = temp1.left;
                            }
                            temp.liczba = temp1.left.liczba;
                            temp1.left = null;
                        }
                        else
                        {
                            temp.liczba=temp1.liczba;
                            temp.right=temp1.right;
                        }
                        break;
                    }
                    else {
                        if(lista.get(0).equals("left"))
                        {
                            temp_father.left=null;
                        }
                        if(lista.get(0).equals("right"))
                        {
                            temp_father.right=null;
                        }
                        return;
                    }

                }
            }

        }

    }
    // print pokazuje tylko prosta coraz to większych i mniejszych elementów
    public void print()
    {
        if(root==null)
        {
            System.out.println("Lista jest pusta");
            return;
        }
        //ArrayList<Node>lista = new ArrayList<>();
        Node temp = root;
        Node temp1 = root;
        System.out.print(temp.liczba+",");
        while (temp.right!=null)
        {
            temp=temp.right;
            System.out.print(temp.liczba+",");
        }
        while (temp1.left!=null)
        {
            temp1=temp1.left;
            System.out.print(temp1.liczba+",");
        }
        System.out.println();
    }

}


