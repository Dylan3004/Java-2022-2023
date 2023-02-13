package pl.edu.uj.javaframe;

public class Tablica {

    MyDouble imaginary;
    MyDouble real;

    Tablica(MyDouble[] MyDouble)
    {
        this.real = MyDouble[0];
        this.imaginary = MyDouble[1];
    }

    @Override
    public String toString() {
        return real.toString();
    }
    public String ImaginarytoString ()
    {
        return real + "i" + imaginary;
    }
}
