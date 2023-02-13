package pl.edu.uj.javaframe;

public class Int extends Value{
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value + (Integer)v.value;
        }else{
            result.value = (Integer)this.value + Double.valueOf(v.value.toString()).intValue();
        }


        return result;
    }
    @Override
    public Value sub (Value v)
    {
//        if(v.value instanceof Tablica1)
//        {
//            MyImaginaryInt resultimaginary = new MyImaginaryInt();
//            Tablica1 temp = (Tablica1) value;
//            Int real = (Int) this.value;
//            Int real1 = (Int) real.sub(temp.real);
//            Int imaginary =(Int) new Int().create("0").sub(temp.imaginary);
//            Int temptab[]=new Int[]{real1,imaginary};
//            Tablica1 tablica = new Tablica1(temptab);
//            resultimaginary.value = tablica;
//            return resultimaginary;
//        }
        Int result = new Int();
        if(v.value instanceof Integer)
        {
            result.value = (Integer)this.value - (Integer) v.value;
        }
        else
        {
            result.value=(Integer)this.value - Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public Value mul (Value v)
    {
        Int result = new Int();
        if(v.value instanceof Integer)
        {
            result.value = (Integer)this.value * (Integer) v.value;
        }
        else
        {
            result.value=(Integer)this.value * Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }
    //@Override
    public Value div (Value v)
    {
        Int result = new Int();
        if(Integer.valueOf(String.valueOf(v.value))==0)
        {
            System.out.println("Warning :You divide something by 0");
            result.value=(Integer)this.value ;
            return result;
        }
        if(v.value instanceof Integer)
        {
            result.value = (Integer)this.value / (Integer) v.value;
        }
        else
        {
            result.value=(Integer)this.value / Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }
    //@Override
    public Value pow (Value v)
    {
        Int result = new Int();
        if(v.value instanceof Int)
        {
            result.value = Math.pow((Integer)this.value,(Integer) v.value);
        }
        else
        {
            Double temp = Math.pow((Integer)this.value,Double.valueOf(v.value.toString()).intValue());
            Integer temp1 = temp.intValue();
            result.value=temp1;
        }
        return result;
    }
    //@Override
    public boolean eq(Value v)
    {
        if(v.value instanceof Int)
        {
            if((Integer)v.value == (Integer) this.value)
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
            if ( ((Integer)this.value ==Double.valueOf(v.value.toString()).intValue()))
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
        if(v.value instanceof Int)
        {
            if((Integer)v.value != (Integer) this.value)
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
            if ( ((Integer)this.value !=Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public boolean lte(Value v)
    {
        if(v.value instanceof Int)
        {
            if((Integer)v.value <=(Integer) this.value)
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
            if ( ((Integer)this.value <=Double.valueOf(v.value.toString()).intValue()))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    public boolean gte(Value v)
    {
        if(v.value instanceof Int)
        {
            if((Integer)v.value >=(Integer) this.value)
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
            if ( ((Integer)this.value >=Double.valueOf(v.value.toString()).intValue()))
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
    public boolean equals(Object other)
    {
        if(getClass()!= other.getClass())
        {
            return false;
        }
        else
        {
            return value.equals((Int) other);
        }
    }

}
