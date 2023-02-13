import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws BoundaryException, OutsiteTheWorldException {

            Word word = new Word(Double.parseDouble(args[0]),Double.parseDouble(args[1]));

        Robot robot = new Robot();

        while (true)
        {
            System.out.println("Przesun robota :Left , Right , Up , Down pozostale komendy :moveBack,Print robot location");
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextLine().contains("Left"))
            {
                Possition temp = robot.lista.get(robot.lista.size()-1);
                Possition possition = new Possition(temp.x-1, temp.y );
                robot.MoveTo(possition,word);
            }
            if(scanner.nextLine().contains("Right"))
            {
                Possition temp = robot.lista.get(robot.lista.size()-1);
                Possition possition = new Possition(temp.x+1, temp.y );
                robot.MoveTo(possition,word);
            }
            if(scanner.nextLine().contains("Up"))
            {
                Possition temp = robot.lista.get(robot.lista.size()-1);
                Possition possition = new Possition(temp.x, temp.y+1 );
                robot.MoveTo(possition,word);
            }
            if(scanner.nextLine().contains("Down"))
            {
                Possition temp = robot.lista.get(robot.lista.size()-1);
                Possition possition = new Possition(temp.x+1, temp.y-1 );
                robot.MoveTo(possition,word);
            }
            if(scanner.nextLine().contains("moveBack"))
            {
                robot.MoveBack();
            }
            if(scanner.nextLine().contains("Print robot location"))
            {
                System.out.println(robot.getPossition());
            }
            if(scanner.nextLine().contains("Exit"))
            {
                System.exit(1);
            }
            else
            {
                System.out.println("Unnown command");
            }
        }

    }
}