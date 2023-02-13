import java.io.*;

public class cryptographer {

    public void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm)
    {
        String input ="";
        try {
            FileReader read = new FileReader(path_to_file_in);
            try {
                int data = read.read();
                while(data!=-1)
                {
                    input += (char)data;
                    data = read.read();
                }
                read.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        try {
            FileWriter write = new FileWriter(path_to_file_out);
            write.write(algorithm.crypt(input));
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm)
    {
        String input ="";
        try {
            FileReader read = new FileReader(path_to_file_in);
            try {
                int data = read.read();
                while(data!=-1)
                {
                  input += (char)data;
                  data = read.read();
                }
                read.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



        try {
            FileWriter write = new FileWriter(path_to_file_out);
            write.write(algorithm.decrypt(input));
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
