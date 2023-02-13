public class ROT11 implements Algorithm{

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String crypt(String inputWord)
    {
        int i =0;
        String end ="";
        for(i=0;i<inputWord.length();i++)
        {
            if(alphabet.contains(inputWord.substring(i,i+1)))
            {
                int index = alphabet.indexOf(inputWord.substring(i,i+1));
                if(index+11<alphabet.length())
                {
                    //inputWord.replace(inputWord.substring(i,i+1),alphabet.substring(index+13,index+14));
                    end+=alphabet.substring(index+11,index+12);
                    System.out.println("aa");
                }
                else
                {
                    System.out.println("bbb");
                    //inputWord.replace(inputWord.substring(i,i+1),alphabet.substring(index+13%alphabet.length(),index+14%alphabet.length()));
                    end +=alphabet.substring((index+11)%alphabet.length(),(index+12)%alphabet.length());
                }

            }
            else
            {
                end+=inputWord.substring(i,i+1);
            }
        }
        return end;
    }
    public String decrypt(String inputWord)
    {
        String end ="";
        for(int i =0;i<inputWord.length();i++)
        {
            if(alphabet.contains(inputWord.substring(i,i+1)))
            {
                int index = alphabet.indexOf(inputWord.substring(i,i+1));
                if(index-11>=0)
                {
                    //inputWord.replace(inputWord.substring(i,i+1),alphabet.substring(i-13,i-14));
                    end+=alphabet.substring(index-11,index-10);
                }
                else
                {
                    int a = alphabet.length()- Math.abs(index-11);
                    //inputWord.replace(inputWord.substring(i,i+1),alphabet.substring(a,a+1));
                    end+=alphabet.substring(a,a+1);
                }
            }
            else
            {
                end+=inputWord.substring(i,i+1);
            }
        }
        return end;
    }
}
