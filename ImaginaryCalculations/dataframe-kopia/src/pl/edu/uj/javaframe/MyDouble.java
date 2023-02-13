package pl.edu.uj.javaframe;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());

        return result;

    }
    @Override
    public Value sub (Value v)
    {
        MyDouble result = new MyDouble();
//        if(v.value instanceof Tablica)
//        {
//            MyImaginaryDouble resultimaginary = new MyImaginaryDouble();
//            Tablica temp = (Tablica) value;
//            MyDouble real = (MyDouble) this.value;
//            MyDouble real1 = (MyDouble) real.sub(temp.real);
//            MyDouble imaginary =(MyDouble) new MyDouble().create("0").sub(temp.imaginary);
//            MyDouble temptab[]=new MyDouble[]{real1,imaginary};
//            Tablica tablica = new Tablica(temptab);
//            resultimaginary.value = tablica;
//            return result;
//        }
        if(v.value instanceof MyDouble)
        {
            result.value = (Double)this.value - (Double) v.value;
        }
        else
        {
            result.value=(Double)this.value - Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public Value mul (Value v)
    {
        MyDouble result = new MyDouble();
        if(v.value instanceof MyDouble)
        {
            result.value = (Double)this.value * (Double) v.value;
        }
        else
        {
            result.value=(Double)this.value * Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }
    //@Override
    public Value div (Value v)
    {
        MyDouble result = new MyDouble();
        if(Double.valueOf(String.valueOf(v.value))==0)
        {
            System.out.println("Warning :You divide something by 0");
            result.value=(Double)this.value ;
            return result;
        }
        if(v.value instanceof MyDouble)
        {

            result.value = (Double)this.value / (Double) v.value;
        }
        else
        {
            result.value=(Double)this.value / Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }
    //@Override
    public Value pow (Value v)
    {
        MyDouble result = new MyDouble();
        if(v.value instanceof MyDouble)
        {
            result.value = Math.pow((Double)this.value,(Double) v.value) ;
        }
        else
        {
            result.value=Math.pow((Double)this.value,Double.valueOf(v.value.toString()).intValue());
        }
        return result;
    }

    //@Override
    public boolean eq(Value v)
    {
        if(v.value instanceof MyDouble)
        {
            if((Double)v.value == (Double) this.value)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if ( ((Double)this.value ==Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    //@Override
    public boolean neq(Value v)
    {
        if(v.value instanceof MyDouble)
        {
            if((Double)v.value != (Double) this.value)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if ( ((Double)this.value !=Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    //@Override
    public boolean lte(Value v)
    {
        if(v.value instanceof MyDouble)
        {
            if((Double)v.value <=(Double) this.value)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if ( ((Double)this.value <=Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    //@Override
    public boolean gte(Value v)
    {
        if(v.value instanceof MyDouble)
        {
            if((Double)v.value >=(Double) this.value)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if ( ((Double)this.value >=Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    //@Override
    public int hashCode()
    {
        return value.hashCode();
    }
    //@Override
    public boolean equals(Object other)
    {
        if(getClass()!= other.getClass())
        {
            return false;
        }
        else
        {
            return value.equals((MyDouble) other);
        }
    }
}
