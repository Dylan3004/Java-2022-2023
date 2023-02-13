package pl.edu.uj.javaframe;

public class Tablica1 {
    Int imaginary;
    Int real;

    Tablica1(Int[] Int)
    {
        this.real = Int[0];
        this.imaginary = Int[1];
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
