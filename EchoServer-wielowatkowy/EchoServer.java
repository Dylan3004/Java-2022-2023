import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(args[1]));
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6665);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
                int[] numbers = new int[2];
                String input = inputLine;
            executorService.submit(()-> {
                String temp = input.replace(")", "").replace("(", "");
                String[] string = temp.split(";");
                ArrayList<Integer> lista = Prime.first(Integer.parseInt(string[0]), Integer.parseInt(string[1]));
                String output = "";
                for (Object element : lista) {
                    output+=String.valueOf(element);
                    output+=" ";
                }
                out.println(output);
            });
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();



    }

}