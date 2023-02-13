import java.util.ArrayList;

public class Calculate {

    ArrayList<Double> heap = new ArrayList<>();

    ArrayList<String> heap_character = new ArrayList<>();


    boolean isANuber(String num) throws NumberFormatException
    {
        try{
            Double.valueOf(num);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    public void calculation()
    {
        if(heap.size()>=2 && heap_character.size()>=1)
        {
            if(heap_character.get(0).equals("+"))
            {
                addy();
                heap_character.remove(0);
            }
            else if (heap_character.get(0).equals("-"))
            {
                sub();
                heap_character.remove(0);
            }
            else if (heap_character.get(0).equals("*"))
            {
                mul();
                heap_character.remove(0);
            }
            else if (heap_character.get(0).equals("/"))
            {
                div();
                heap_character.remove(0);
            }
        }
        if(heap.size()==1 && heap_character.size()==1 && heap_character.get(0).equals("sqrt"))
        {
            sqrt();
            heap_character.remove(0);
        }
    }

    void addy()
    {
        double temp= heap.get(heap.size()-2) + heap.get(heap.size()-1);
        heap.set((heap.size()-2),temp);
        heap.remove(heap.size()-1);
    }
    void sub()
    {
        double temp= heap.get(heap.size()-2)- heap.get(heap.size()-1);
        heap.set((heap.size()-2),temp);
        heap.remove(heap.size()-1);
    }
    void mul()
    {
        double temp= heap.get(heap.size()-2)* heap.get(heap.size()-1);
        heap.set((heap.size()-2),temp);
        heap.remove(heap.size()-1);
    }
    void div() throws ArithmeticException
    {
        try {
            double temp = heap.get(heap.size() - 2) / heap.get(heap.size() - 1);
            heap.set((heap.size() - 2), temp);
            heap.remove(heap.size() - 1);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Dzielisz przez zero");
            System.exit(-1);
        }
    }
    void pow()
    {
        double temp= Math.pow(heap.get(heap.size()-2),heap.get(heap.size()-1));
        heap.set((heap.size()-2),temp);
        heap.remove(heap.size()-1);
    }
    void sqrt()
    {
        double temp= Math.sqrt(heap.get(heap.size()-1));
        heap.set((heap.size()-1),temp);

    }
    void print()
    {
        System.out.println(this.heap.get(0));
    }
    void printall()
    {
        for(int i=0;i<heap.size();i++)
        {
            System.out.println(heap.get(i));
        }
    }
    void print_heap()
    {
        for(int i=0;i<heap_character.size();i++)
        {
            System.out.println(heap_character.get(i));
        }
    }


}

