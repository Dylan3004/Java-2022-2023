public class Polynomial {

    public double[] tab;

    //final public String[] tablica_znakow ={"1","2","3","4","5","6","7","8","9","0",","};

    public String numbersstring;
    public String marksstring;

    Polynomial(String string) {
        int max_pozition=0;
        double[] first_tab =new double[100];
        String replace = string.replace("^"," ");
        marksstring = replace.replace("x","");
        //System.out.println(marksstring);
        int z;
        int k;
        String temp;
        String temp1;
        for(int i=0;i<marksstring.length();)
        {
            temp="";
            temp1="";
            z=i;
            while(marksstring.charAt(i)!=' ' )
            {
                temp=marksstring.substring(z,i+1);
                //System.out.println(temp);
                i++;
            }
            k=i+1;
            while (marksstring.charAt(i)!='+' && marksstring.charAt(i)!='-' )
            {
                //System.out.println("to jest i: "+i);
                temp1=marksstring.substring(k,i+1);
                try
                {
                    if(Integer.parseInt(temp1)>max_pozition)
                    {
                        max_pozition=Integer.parseInt(temp1);
                    }
                }
                catch (NumberFormatException e)
                {

                }
                //System.out.println(temp1);
                if(i+1<marksstring.length())
                {
                    i++;
                }
                else
                {
                    break;
                }
            }
            if(temp1.equals(""))
            {
                first_tab[0]+=Double.parseDouble(temp);
            }
            else
            {
                first_tab[Integer.parseInt(temp1)]+=Double.parseDouble(temp);
            }

            // koniec stringa
            if(i+1==marksstring.length())
            {
                //System.out.println();
                break;
            }


        }
        tab=new double[max_pozition+1];
        for(int i=0;i<=max_pozition;i++)
        {
            tab[i]=first_tab[i];
            System.out.println(tab[i]);
        }

    }
    public double[] add (double[]tab2)
    {
        double[]temp;
        System.out.println(tab.length);
        System.out.println(tab2.length);
        if(tab.length>tab2.length)
        {
            System.out.println("aaa");
            temp=new double[tab.length];
            for(int i=0;i< tab2.length;i++)
            {
                temp[i]=tab[i]+tab2[i];
            }
            for(int i= tab2.length;i< tab.length;i++)
            {
                temp[i]=tab[i];
            }
        }
        else
        {
            temp=new double[tab2.length];
            for(int i=0;i< tab.length;i++)
            {
                temp[i]=tab[i]+tab2[i];
            }
            for(int i= tab.length;i< tab2.length;i++)
            {
                temp[i]=tab2[i];
            }
        }
//        tab=new double[temp.length];
//        System.arraycopy(temp, 0, tab, 0, temp.length);
        return temp;
    }
    public double[] sub (double[]tab2)
    {
        double[]temp;
        if(tab.length>tab2.length)
        {
            temp=new double[tab.length];
            for(int i=0;i<tab2.length;i++)
            {
                temp[i]=tab[i]-tab2[i];
            }
            for(int i= tab2.length;i< tab.length;i++)
            {
                temp[i]=tab[i];
            }
        }
        else
        {
            temp=new double[tab2.length];
            for(int i=0;i<tab.length;i++)
            {
                temp[i]=tab[i]-tab2[i];
            }
            for(int i= tab.length;i< tab2.length;i++)
            {
                temp[i]=-tab2[i];
            }
        }
//        tab=new double[temp.length];
//        System.arraycopy(temp, 0, tab, 0, temp.length);
        return temp;
    }
    public double[] mul (double[]tab2)
    {
        double[]temp=new double[tab.length+ tab2.length-1];
        for(int i=0;i<tab.length;i++)
        {
            for(int j=0;j<tab2.length;j++)
            {
                temp[j+i]+=tab[i]*tab2[j];
            }
        }
        for(int i=0;i< temp.length;i++)
        {
            System.out.println(temp[i]+"x^"+(i));
        }
//        tab=new double[temp.length];
//        System.arraycopy(temp, 0, tab, 0, temp.length);
        System.out.println();
        return temp;
    }
    public double horner(double x) {
        double wynik = tab[tab.length - 1];
        for (int i = tab.length - 2; i >= 0; i--)
        {
            wynik = wynik * x + tab[i];
        }
        return wynik;
    }


//    boolean isNumber(String string )
//    {
//        boolean result = false;
//        for(int i =0;i<tablica_znakow.length;i++)
//        {
//            if(tablica_znakow[i].equals(string));
//            {
//                result=true;
//                break;
//            }
//        }
//        return result;
//    }
    public void showstring()
    {
        System.out.println(numbersstring);
        System.out.println(marksstring);
    }

    public void show()
    {
        for (double v : tab) {
            System.out.println(v);
        }
    }
//
}