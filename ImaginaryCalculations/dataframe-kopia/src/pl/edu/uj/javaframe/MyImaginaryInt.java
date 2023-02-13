package pl.edu.uj.javaframe;

public class MyImaginaryInt extends Int {

    MyImaginaryInt() {

    }

    @Override
    public Value add(Value v) {
        MyImaginaryInt complex = new MyImaginaryInt();
        if (v.value instanceof Tablica) {
            Tablica1 temp = (Tablica1) value;
            Tablica1 temp1 = (Tablica1) v.value;
            Int real = (Int) temp.real.add(temp1.real);
            Int imaginary = (Int) temp.imaginary.add((temp1.imaginary));
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;
        } else {
            Tablica1 temp = (Tablica1) value;
            Int real = (Int) temp.real.add(v);
            complex.value = new Int[]{real, temp.imaginary};
            return complex;
        }
    }

    @Override
    public Value create(String stringvalue) {
        MyImaginaryInt complex = new MyImaginaryInt();

        if (stringvalue.contains("i")) {
            Int im = (Int) new Int().create(stringvalue.substring(stringvalue.indexOf("i") + 1));
            Int re = (Int) new Int().create(stringvalue.substring(0, stringvalue.indexOf("i")));
            Int tab[] = new Int[]{re, im};
            Tablica1 tablica = new Tablica1(tab);
            complex.value = tablica;
            return complex;
        }
        else {
            Int re = (Int) new Int().create(stringvalue);
            Int tab[] = new Int[]{re, (Int) new Int().create("0")};
            Tablica1 tablica = new Tablica1(tab);
            complex.value = tablica;
            return complex;

        }
    }
    public String toString()
    {
        Tablica1 temp = (Tablica1) value;
        return temp.ImaginarytoString();

    }
    @Override
    public Value sub(Value v) {
        MyImaginaryInt complex = new MyImaginaryInt();
        if (v.value instanceof Tablica1) {
            Tablica1 temp = (Tablica1) value;
            Tablica1 temp1 = (Tablica1) v.value;
            Int real = (Int) temp.real.sub(temp1.real);
            Int imaginary = (Int) temp.imaginary.sub((temp1.imaginary));
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;
        } else {
            Tablica1 temp = (Tablica1) value;
            Int real = (Int) temp.real.sub(v);
            complex.value = new Int[]{real, temp.imaginary};
            return complex;
        }
    }
    @Override
    public Value mul (Value v)
    {
        MyImaginaryInt complex = new MyImaginaryInt();
        if(v.value instanceof Tablica1 )
        {
            Tablica1 temp = (Tablica1) value;
            Tablica1 temp1 = (Tablica1) v.value;
            Int sub = (Int) temp.real.mul(temp1.real);// real * real
            Int aaa = (Int) temp.imaginary;//imaginary
            Int real = (Int) sub.sub(aaa.mul((temp1.imaginary)));//real * real - imaginary * imaginary
            Int ima1 = (Int) temp.imaginary.mul(temp1.real); // imaginary * real
            Int ima2 = (Int) temp1.imaginary.mul(temp.real); // real* imaginary
            Int imaginary = (Int) ima1.add(ima2);// imaginary * real + real* imaginary
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;
        }
        else if (v.value instanceof Int)
        {
            Tablica1 temp = (Tablica1) value;
            Int real = (Int) temp.real.mul(v);
            Int imaginary =(Int) temp.imaginary.mul(v);
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;

        }
        else
        {
            System.out.println("There is no possibility to multiply this types");
            return v;
        }
    }
    @Override
    public Value div (Value v)
    {
        MyImaginaryInt complex = new MyImaginaryInt();
        if(v.value instanceof Tablica1)
        {
            Tablica1 temp = (Tablica1) value;
            Tablica1 temp1 = (Tablica1) v.value;
            Int sub = (Int) temp.real.mul(temp1.real);// real * real1 a*c
            Int aaa = (Int) temp.imaginary;//imaginary b
            Int pow =(Int) temp1.imaginary.mul(temp1.imaginary); //d*d
            Int pow2 = (Int) temp1.real.mul(temp1.real); //c*c
            Int pow3 = (Int) pow.add(pow2);
            Int xxx = (Int) sub.add(aaa.mul((temp1.imaginary)));//real * real1 + imaginary * imaginary1 ac + bd
            Int ima1 = (Int) temp.imaginary.mul(temp1.real); // imaginary * real1 b*c
            Int aaaa = (Int) temp.real.mul(temp1.imaginary); // a*d
            Int ima2 = (Int) temp1.imaginary.mul(temp.real); // real* imaginary1 a*d
            Int ima3 = (Int) ima1.sub(aaaa);
            Int imaginary = (Int) ima3.div(pow3);
            Int real = (Int) xxx.div(pow3);
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;
        } else if (v.value instanceof Int)
        {
            Tablica1 temp = (Tablica1) value;
            Int sub = (Int) temp.real.mul(v);// a*c
            Int ima1 = (Int) temp.imaginary.mul(v);// b*c
            Int pow2 = (Int) v.mul(v);
            Int real = (Int) sub.div(pow2);
            Int imaginary= (Int) ima1.div(pow2);
            Int temptab[] = new Int[]{real, imaginary};
            Tablica1 tablica = new Tablica1(temptab);
            complex.value = tablica;
            return complex;
        }
        else
        {
            System.out.println("There is no possibility to multiply this types");
            return v;
        }
    }
    @Override
    public Value pow(Value v)
    {
        Tablica1 temp = (Tablica1) value;
        MyImaginaryInt complex = new MyImaginaryInt();
        Integer iterator =(Integer) v.value;
        Int real = temp.real;
        Int imaginary = temp.imaginary;
        for(int i = 0;i<iterator;i++)
        {
            real =(Int) real.mul(temp.real);
            imaginary = (Int) imaginary.mul(temp.imaginary);
        }
        Int temptab[] = new Int[]{real, imaginary};
        Tablica1 tablica = new Tablica1(temptab);
        complex.value = tablica;
        return complex;
    }


    @Override
    public boolean lte (Value v)
    {
        System.out.println("This operation is not allowed for imaginary numbers");
        return false;
    }
    @Override
    public boolean gte (Value v)
    {
        System.out.println("This operation is not allowed for imaginary numbers");
        return false;
    }
    @Override
    public boolean eq (Value v)
    {
        System.out.println("This operation is not allowed for imaginary numbers");
        return false;
    }
    @Override
    public boolean neq (Value v)
    {
        System.out.println("This operation is not allowed for imaginary numbers");
        return false;
    }
    @Override
    public boolean equals (Object other)
    {
        if(getClass()!= other.getClass())
        {
            return false;
        }
        else
        {
            return value.equals((MyImaginaryInt) other);
        }
    }

    @Override
    public int hashCode ()
    {
        return value.hashCode();
    }

}
