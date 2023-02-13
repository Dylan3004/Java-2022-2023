import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Beehive Beehave = new Beehive();
        File file= new File("resoults.txt");
        boolean resoult ;
        try {
            resoult= file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(resoult)
        {
            System.out.println("Done");
        }
        else
        {
            System.out.println("Error");
        }
        System.out.println("How many bees do you want?");
        Scanner scanner = new Scanner(System.in);
        String number_string = scanner.nextLine();
        int number = Integer.parseInt(number_string);
        Thread[] threads = new Thread[number];
        for(int i=0;i<number;i++)
        {
            threads[i] =  new Thread(new MyThread(Beehave));
            threads[i].start();
        }

    }
}