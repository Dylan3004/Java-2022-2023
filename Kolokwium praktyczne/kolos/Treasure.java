public class Treasure extends Possition{

    Treasure(double x , double y)
    {
        super(x,y);
    }


    public String toString()
    {
        String re = String.valueOf(x)+" "+String.valueOf(y);
        return re;
    }
    void SetX(double x)
    {
        this.x=x;
    }
    void  SetY(double y)
    {
        this.y=y;
    }
    double GetX()
    {
        return this.x;
    }
    double GetY()
    {
        return this.y;
    }

}



