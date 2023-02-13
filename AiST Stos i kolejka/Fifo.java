public class Fifo {


    int [] tab ;
    int ostatniNumerek;
    int index;
    int ilosc_elementow;
    Fifo(int [] tab)
    {
        this.tab=tab;
        ostatniNumerek=-1;
        ilosc_elementow=0;
        index=0;
    }

    void enqueue(int liczba)
    {
        this.tab[(ostatniNumerek+1)%tab.length]=liczba;
        ilosc_elementow++;
        ostatniNumerek=ostatniNumerek+1 % tab.length;
    }
    void dequeue()
    {
        this.tab[index% tab.length]=0;
        index=(index+1) % tab.length;
        ilosc_elementow--;

    }
    void print()
    {
        for(int i =index%tab.length;i<ilosc_elementow+index;i++)
        {
            System.out.print(tab[i%tab.length]+",");
        }
        System.out.println();
    }
}
