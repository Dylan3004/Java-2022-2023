import java.io.*;
import java.util.ArrayList;

public class Beehive {

    Fifo fifo_first_to_go_in = new Fifo();

    Fifo fifo_first_to_go_out = new Fifo();

    Fifo fifo_second_to_go_in = new Fifo();

    Fifo fifo_second_to_go_out = new Fifo();

    public boolean  first_gate_thru_out_to_in = true;

    public boolean second_gate_thru_out_to_in = true;

    public boolean it_ok = true;

    public void write_to_file(String file , int wloty , int wyloty , double average, int name )
    {
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write("Pszczoła: "+name+" Liczba wlotów: "+wloty+" Liczba wylotów :"+wyloty+" Średnia czasu oczekiwania: "+average+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    protected Bee tab_of_bees_in_beehide [] = new Bee[1000];
}
