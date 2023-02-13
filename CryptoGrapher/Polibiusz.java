public class Polibiusz implements Algorithm{

    String alfabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers="1234567890";


    public String crypt(String inputWord)
    {
        inputWord=inputWord.toLowerCase();
        String index = "";
    for(int i =0 ;i<inputWord.length();i++)
    {
        if(alfabet.contains(inputWord.substring(i,i+1)))
        {
            int wiersz =(int) alfabet.indexOf(inputWord.substring(i,i+1))/5+1;
            int kolumna = alfabet.indexOf(inputWord.substring(i,i+1))%5+1;
            String slowo = Integer.toString(wiersz)+Integer.toString(kolumna);
            index+=slowo;
        }
        else
        {
            index+=inputWord.substring(i,i+1);
        }
    }
        return index;
    }
    public String decrypt(String inputWord)
    {
        int i =0;
        String index ="";
        while(inputWord.length()>i)
        {
            if(numbers.contains(inputWord.substring(i,i+1)))
            {
                int wiersz = Integer.parseInt(inputWord.substring(i,i+1));
                int kolumna = Integer.parseInt(inputWord.substring(i+1,i+2));
                int numer = (wiersz-1)*5 + kolumna-1;
                index += alfabet.substring(numer,numer+1);
                i+=2;
            }
            else
            {
                index +=inputWord.substring(i,i+1);
                i++;
            }

        }
        return index;
    }
}
