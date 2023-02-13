import java.util.ArrayList;

public class Calculate {

    ArrayList<Double> heap = new ArrayList<>();


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
    void add()
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

}
