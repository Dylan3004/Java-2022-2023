import java.util.ArrayList;

public class Robot implements Movable{

    ArrayList<Possition> lista= new ArrayList<>();

    Robot()
    {
        Possition possition = new Possition(0,0);
        lista.add(possition);
    }

    String getPossition()
    {
        Possition h =lista.get(lista.size()-1);
        String x = String.valueOf(h.y)+","+String.valueOf(h.y);
        return x;
    }
    public void MoveTo(Possition possition, Word word) throws OutsiteTheWorldException
    {
        if(possition.x <0 || possition.y <0)
        {
            throw new OutsiteTheWorldException();
        }
        lista.add(possition);

        Possition one = lista.get(lista.size()-1);
        Possition two = lista.get(lista.size()-2);
        double x = word.x;
        double y =word.y;
        if(Math.sqrt(Math.pow(2, word.GetTresure().x- one.x)*Math.pow(2,word.GetTresure().y-one.y)) < Math.sqrt(Math.pow(2,word.GetTresure().x-two.x)*Math.pow(2,word.GetTresure().y-two.y)))
        {
            System.out.println("Hot");
        }
        else
        {
            System.out.println("Cold");
        }

    }

    public void MoveBack()
    {
        lista.remove(lista.size()-1);
        System.out.println("Powrot");
    }


}
