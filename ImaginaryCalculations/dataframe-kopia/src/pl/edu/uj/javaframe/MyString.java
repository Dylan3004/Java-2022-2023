package pl.edu.uj.javaframe;

public class MyString extends Value {
    @Override
    public Value create(String val) {
        MyString v = new MyString();
        v.value = val;
        return v;
    }

    @Override
    public Value add(Value v) {
        return null;
    }

    @Override
    public Value sub(Value v) {
        return null;
    }

    @Override
    public Value mul(Value v) {
        return null;
    }
    @Override
    public Value div (Value v) {return null;}
    public  Value pow (Value v) {return null;}
    public boolean eq (Value v) {
        if(this.value.toString()==value.toString())
        {
            return true;
        }
        return false;
    }
    public boolean lte (Value v) {return true;}
    public boolean gte (Value v) {return true;}
    public boolean neq (Value v) {
        if(this.value.toString()==value.toString())
        {
            return false;
        }
        return true;
    }
    public boolean equals(Object other) {
        if(getClass()!=other.getClass())
        {
            return false;
        }
        return value.equals((MyString)other);
    }
    public int hashCode () {return value.hashCode();}
}
