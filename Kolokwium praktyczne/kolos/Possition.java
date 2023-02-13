public class Possition {
    double x;
    double y;


    Possition(double x , double y)
    {
        this.x=x;
        this.y=y;
    }

     public String toString()
    {
      String re = String.valueOf(x)+","+String.valueOf(y);
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
