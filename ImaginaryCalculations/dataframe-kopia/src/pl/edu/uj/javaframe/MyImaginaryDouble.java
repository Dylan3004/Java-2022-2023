package pl.edu.uj.javaframe;

public class MyImaginaryDouble extends MyDouble{

    //MyDouble imaginary;


    MyImaginaryDouble()
    {

    }
    @Override
    public Value add(Value v)
    {
        MyImaginaryDouble complex = new MyImaginaryDouble();
        if(v.value instanceof Tablica)
        {
            Tablica temp = (Tablica) value;
            Tablica temp1 = (Tablica) v.value;
            MyDouble real =(MyDouble) temp.real.add(temp1.real);
            MyDouble imaginary = (MyDouble) temp.imaginary.add((temp1.imaginary));
            MyDouble temptab[]=new MyDouble[]{real,imaginary};
            Tablica tablica = new Tablica(temptab);
            complex.value=tablica;
            return complex;

        }
        else {
            Tablica temp = (Tablica) value;
            MyDouble real =(MyDouble) temp.real.add(v);
            complex.value=new MyDouble[]{real,temp.imaginary};
            return complex;
        }
    }
    @Override
     public Value create(String stringvalue)
    {
        MyImaginaryDouble complex = new MyImaginaryDouble();

        if (stringvalue.contains("i"))
        {
            MyDouble im =(MyDouble) new MyDouble().create(stringvalue.substring(stringvalue.indexOf("i")+1));
            MyDouble re = (MyDouble) new MyDouble().create(stringvalue.substring(0,stringvalue.indexOf("i")));
            MyDouble tab[]= new MyDouble[]{re,im};
            Tablica tablica = new Tablica(tab);
            complex.value=tablica;
            return complex;
        }
        else
        {
            MyDouble re = (MyDouble) new MyDouble().create(stringvalue);
            MyDouble tab[]= new MyDouble[]{re,(MyDouble) new MyDouble().create("0")};
            Tablica tablica = new Tablica(tab);
            complex.value=tablica;
            return complex;

        }
    }
    public String toString()
    {
        Tablica temp = (Tablica) value;
        return temp.ImaginarytoString();

    }

    @Override
    public Value sub(Value v) {
        MyImaginaryDouble complex = new MyImaginaryDouble();
        if (v.value instanceof Tablica) {
            Tablica temp = (Tablica) value;
            Tablica temp1 = (Tablica) v.value;
            MyDouble real = (MyDouble) temp.real.sub(temp1.real);
            MyDouble imaginary = (MyDouble) temp.imaginary.sub((temp1.imaginary));
            MyDouble temptab[] = new MyDouble[]{real, imaginary};
            Tablica tablica = new Tablica(temptab);
            complex.value = tablica;
            return complex;
        } else {
            Tablica temp = (Tablica) value;
            MyDouble real = (MyDouble) temp.real.sub(v);
            complex.value = new MyDouble[]{real, temp.imaginary};
            return complex;
        }
    }
    @Override
    public Value mul (Value v)
    {
        MyImaginaryDouble complex = new MyImaginaryDouble();
        if(v.value instanceof Tablica )
        {
            Tablica temp = (Tablica) value;
            Tablica temp1 = (Tablica) v.value;
            MyDouble sub = (MyDouble) temp.real.mul(temp1.real);// real * real
            MyDouble aaa = (MyDouble) temp.imaginary;//imaginary
            MyDouble real = (MyDouble) sub.sub(aaa.mul((temp1.imaginary)));//real * real - imaginary * imaginary
            MyDouble ima1 = (MyDouble) temp.imaginary.mul(temp1.real); // imaginary * real
            MyDouble ima2 = (MyDouble) temp1.imaginary.mul(temp.real); // real* imaginary
            MyDouble imaginary = (MyDouble) ima1.add(ima2);// imaginary * real + real* imaginary
            MyDouble temptab[] = new MyDouble[]{real, imaginary};
            Tablica tablica = new Tablica(temptab);
            complex.value = tablica;
            return complex;
        }
        else if (v.value instanceof Int)
        {
            Tablica temp = (Tablica) value;
            MyDouble real = (MyDouble) temp.real.mul(v);
            MyDouble imaginary =(MyDouble) temp.imaginary.mul(v);
            MyDouble temptab[] = new MyDouble[]{real, imaginary};
            Tablica tablica = new Tablica(temptab);
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
        MyImaginaryDouble complex = new MyImaginaryDouble();
        if(v.value instanceof Tablica)
        {
            Tablica temp = (Tablica) value;
            Tablica temp1 = (Tablica) v.value;
            MyDouble sub = (MyDouble) temp.real.mul(temp1.real);// real * real1 a*c
            MyDouble aaa = (MyDouble) temp.imaginary;//imaginary b
            MyDouble pow =(MyDouble) temp1.imaginary.mul(temp1.imaginary); //d*d
            MyDouble pow2 = (MyDouble) temp1.real.mul(temp1.real); //c*c
            MyDouble pow3 = (MyDouble) pow.add(pow2);
            MyDouble xxx = (MyDouble) sub.add(aaa.mul((temp1.imaginary)));//real * real1 + imaginary * imaginary1 ac + bd
            MyDouble ima1 = (MyDouble) temp.imaginary.mul(temp1.real); // imaginary * real1 b*c
            MyDouble aaaa = (MyDouble) temp.real.mul(temp1.imaginary); // a*d
            MyDouble ima2 = (MyDouble) temp1.imaginary.mul(temp.real); // real* imaginary1 a*d
            MyDouble ima3 = (MyDouble) ima1.sub(aaaa);
            MyDouble imaginary = (MyDouble) ima3.div(pow3);
            MyDouble real = (MyDouble) xxx.div(pow3);
            MyDouble temptab[] = new MyDouble[]{real, imaginary};
            Tablica tablica = new Tablica(temptab);
            complex.value = tablica;
            return complex;
        } else if (v.value instanceof Int)
        {
            Tablica temp = (Tablica) value;
            MyDouble sub = (MyDouble) temp.real.mul(v);// a*c
            MyDouble ima1 = (MyDouble) temp.imaginary.mul(v);// b*c
            MyDouble pow2 = (MyDouble) v.mul(v);
            MyDouble real = (MyDouble) sub.div(pow2);
            MyDouble imaginary= (MyDouble) ima1.div(pow2);
            MyDouble temptab[] = new MyDouble[]{real, imaginary};
            Tablica tablica = new Tablica(temptab);
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
        Tablica temp = (Tablica) value;
        MyImaginaryDouble complex = new MyImaginaryDouble();
        Double iterator =(Double) v.value;
        MyDouble real = temp.real;
        MyDouble imaginary = temp.imaginary;
        for(int i = 0;i<iterator;i++)
        {
            real =(MyDouble) real.mul(temp.real);
            imaginary = (MyDouble) imaginary.mul(temp.imaginary);
        }
        MyDouble temptab[] = new MyDouble[]{real, imaginary};
        Tablica tablica = new Tablica(temptab);
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
    public int hashCode()
    {
        return value.hashCode();
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
            return value.equals((MyImaginaryDouble) other);
        }
    }
}
