import java.util.Random;

public class Word {

    double x;
    double y;

    Treasure k;
    Word(double x,double y) throws BoundaryException
    {
        if(x<=0 || y<=0)
        {
            System.out.println("Zle podany parametr");
            throw  new BoundaryException()  ;
        }
        this.x=x;
        this.y=y;
        Random xx = new Random();
        Random yy = new Random();
        k = new Treasure(xx.nextDouble()*x,yy.nextDouble()*y);
    }
    Word()
    {
        this.x=100;
        this.y=100;
        Random xx = new Random();
        Random yy = new Random();
        Treasure k = new Treasure((xx.nextDouble()%1)*x,(yy.nextDouble()%1)*y);
    }
    public Treasure GetTresure()
    {
        return this.k;
    }

}
