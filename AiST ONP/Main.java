import com.sun.jdi.Value;

public class Main {
    public static void main(String[] args) {
        //tworzenie stringa do obslugi
        StringBuilder builder = new StringBuilder();
        for (String str: args)
        {
            builder.append(str).append(" ");
        }
        String ciag = builder.toString();
        String sqrt = "sqrt";
        boolean end = true;
        Calculate calculate = new Calculate();
        int numbers_index = -1;

        //petla idaca po stringu
        for (int i = 0; i < ciag.length(); i++) {
            int z = i;
            end=true;
            while (end) {
                //sprawdzanie czy podany znak jest liczba lub . zeby mozna bylo obslozyc typ double
                if (calculate.isANuber(ciag.substring(i, i + 1)) || ciag.charAt(i) == '.') {
                    if(z==i)
                    {
                        calculate.heap.add(0.);
                        numbers_index++;
                    }
                    calculate.heap.set(numbers_index, Double.valueOf(ciag.substring(z, i + 1)));
                    i++;
                } else {
                    end = false;
                    if(z!=i)
                    {
                        i--;
                    }
                }

            }
            if (ciag.charAt(i) == '+') {
                calculate.add();
                numbers_index--;

            }
            if (ciag.charAt(i) == '-') {
                calculate.sub();
                numbers_index--;

            }
            if (ciag.charAt(i) == '*') {
                calculate.mul();
                numbers_index--;

            }
            if (ciag.charAt(i) == '/') {
                calculate.div();
                numbers_index--;

            }
            if (ciag.charAt(i) == '^') {
                calculate.pow();
                numbers_index--;

            }
            if (ciag.charAt(i) == 's') {
                if (ciag.substring(i, i + 4).equals(sqrt)) {
                    calculate.sqrt();
                    i = i + 4;
                } else {
                    System.out.println("Nieznana komenda");
                    System.exit(-1);
                }
            }
            i++;
        }
        calculate.print();
        System.out.println();
        calculate.printall();
    }
}