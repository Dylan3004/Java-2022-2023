import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        Calculate calculate = new Calculate();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
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
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;
        System.out.println("aaa");
        String ciag = "";
        int z =0;
        int math =0;
        String prev ="";
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      while ((ciag = in.readLine()) != null) {

          System.out.println(ciag);
          int g =0;
          for(int i =0;i<ciag.length();i++)
          {
              z=i;
              while(calculate.isANuber(ciag.substring(z,i+1)))
              {
                  if(z==i)
                  {
                      calculate.heap.add(Double.valueOf(ciag.substring(z,i+1)));
                  }
                  calculate.heap.set(calculate.heap.size()-1,Double.valueOf(ciag.substring(z,i+1)));
                  if(i==ciag.length()-1)
                  {
                      break;
                  }
                  i++;
//                  for(int j=0;j<calculate.heap.size();j++)
//                  {
////                      System.out.println("iteracja "+g++);
////                      System.out.println("poziom"+j);
////                      System.out.println(calculate.heap.get(j));
////                      System.out.println("Heap");
//                      //calculate.print_heap();
//                  }
              }
              if(ciag.charAt(i) == '+' || ciag.charAt(i) == '-' || ciag.charAt(i) == '*' || ciag.charAt(i) == '/' )
              {
                  calculate.heap_character.add(ciag.substring(i,i+1));
              }
              System.out.println(i);
              if(i+4<ciag.length())
              {
                  if( ciag.substring(i,i+4).equals("sqrt") )
                  {
                      calculate.heap_character.add("sqrt");
                      i+=3;
                  }
              }
              System.out.println(calculate.heap.size());
              System.out.println(calculate.heap_character.size());
              System.out.println();
              calculate.calculation();
          }
          ciag = calculate.heap.get(0).toString();
            out.println(ciag);
            calculate.heap.clear();
            calculate.heap_character.clear();

        }


        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }


}