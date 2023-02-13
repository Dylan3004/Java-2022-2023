import java.util.Random;

public class MyThread implements Runnable{

        Beehive beehive;

        MyThread(Beehive beehive)
        {
                this.beehive=beehive;
        }

        Bee bee = new Bee();

        int bee_index = bee.hashCode();

        double time =0;

        double average =0;

        int ilosc_wlotow=0;

        int ilosc_wylotow=0;

        protected boolean is_second_gate_empty_for_out_to_in()
        {
                return beehive.fifo_second_to_go_in.start.liczba == bee_index;
        }
        protected boolean is_second_gate_empty_for_in_to_out()
        {
                return beehive.fifo_second_to_go_out.start.liczba == bee_index;
        }
        protected boolean is_first_gate_empty_for_out_to_in()
        {
                return beehive.fifo_first_to_go_in.start.liczba == bee_index;
        }
        protected boolean is_first_gate_empty_for_in_to_out()
        {
                return beehive.fifo_first_to_go_out.start.liczba == bee_index;
        }
        protected synchronized void thru_first_gate_to_go_in ()
        {
                // czas jaki zajmuje przejscie przez bramke
                // zmienia tez pierwszenstwo bramki dla wychodzacych
                ilosc_wlotow++;
                beehive.it_ok=change_flag(beehive.it_ok);
                try {
                        System.out.println("wlatuje do ula wejsciem pierwszym :"+bee_index);
                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                }
                beehive.it_ok=change_flag(beehive.it_ok);
                if(!beehive.fifo_first_to_go_out.is_Empty())
                {
                        //beehive.first_gate_thru_out_to_in=false;
                        beehive.first_gate_thru_out_to_in=change_flag(beehive.first_gate_thru_out_to_in);
                }
                // ta funkcja miała wybudzać wszystkie wontki które znajdują się w kolejce fifo do danego gate-u i tylko
                // jedna z tych pszczół powinna w danym momencie miec możliwośc przejścia przez daną konkretną bramkę bo reszta
                // pszczół albo jest w kolejce albo nie może wejśc do funkcji przejścia np w drugim gate-cie bo funkcja synchronized
                // zabrania jej wykonania funkcji bo w danym momencie inna przszoła ją wykonuje
                notifyAll();

        }
        protected synchronized void thru_second_gate_to_go_in ()
        {
                ilosc_wlotow++;
                // czas jaki zajmuje przejscie przez bramke
                // zmienia tez pierwszenstwo bramki dla wychodzacych
                try {
                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                }
                if(!beehive.fifo_second_to_go_out.is_Empty())
                {
                        //beehive.second_gate_thru_out_to_in=false;
                        beehive.second_gate_thru_out_to_in=change_flag(beehive.second_gate_thru_out_to_in);
                }
                notifyAll();

        }
        protected synchronized void thru_first_gate_to_go_out ()
        {
                ilosc_wylotow++;
                // czas jaki zajmuje przejscie przez bramke
                // zmienia tez pierwszenstwo bramki dla wychodzacych
                try {
                        Thread.sleep(1000);
                        //wait(1000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                }
                if(!beehive.fifo_first_to_go_in.is_Empty())
                {
                        //beehive.first_gate_thru_out_to_in=true;
                        beehive.first_gate_thru_out_to_in=change_flag(beehive.first_gate_thru_out_to_in);
                }
                notifyAll();

        }
        protected synchronized void thru_second_gate_to_go_out ()
        {
                ilosc_wylotow++;
                // czas jaki zajmuje przejscie przez bramke
                // zmienia tez pierwszenstwo bramki dla wychodzacych
                try {
                        Thread.sleep(1000);
                        //wait(1000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                }
                if(!beehive.fifo_second_to_go_in.is_Empty())
                {
                        //beehive.second_gate_thru_out_to_in=true;
                        beehive.second_gate_thru_out_to_in=change_flag(beehive.second_gate_thru_out_to_in);
                }
                notifyAll();

        }
        protected void thru_gate_sequence_first_gate_to_go_in()
        {
                boolean sequence = true;
                while(sequence)
                {
                        if(is_first_gate_empty_for_out_to_in() && beehive.first_gate_thru_out_to_in)
                        {
                                thru_first_gate_to_go_in();
                                beehive.fifo_first_to_go_in.dequeue();
                                sequence=false;
                        }
                        else
                        {
                                try {
                                        wait();
                                } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                }
        }

        protected void thru_gate_sequence_second_gate_to_go_in()
        {
                boolean sequence = true;
                while(sequence)
                {
                        if(is_second_gate_empty_for_out_to_in() && beehive.second_gate_thru_out_to_in)
                        {
                                thru_second_gate_to_go_in();
                                beehive.fifo_second_to_go_in.dequeue();
                                sequence=false;
                        }
                        else
                        {
                                try {
                                        wait();
                                } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                }
        }
        protected void thru_gate_sequence_first_gate_to_go_out()
        {
                boolean sequence = true;
                while(sequence)
                {
                        if(is_first_gate_empty_for_in_to_out() && !beehive.second_gate_thru_out_to_in)
                        {
                                thru_first_gate_to_go_out();
                                beehive.fifo_first_to_go_out.dequeue();
                                sequence=false;
                        }
                        else
                        {
                                try {
                                        wait();
                                } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                }
        }
        protected void thru_gate_sequence_second_gate_to_go_out()
        {
                boolean sequence = true;
                while(sequence)
                {
                        if(is_second_gate_empty_for_in_to_out() && !beehive.second_gate_thru_out_to_in)
                        {
                                thru_second_gate_to_go_out();
                                beehive.fifo_second_to_go_out.dequeue();
                                sequence=false;
                        }
                        else
                        {
                                try {
                                        wait();
                                } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                }
                        }
                }
        }
        public synchronized boolean change_flag(boolean flag)
        {
                return !flag;
        }
        public synchronized void add_to_fifo(Fifo fifo,int number)
        {
                fifo.enqueue(number);
        }

        public synchronized boolean allow_going_function_first_to_go_in()
        {
                try {
                        synchronized (beehive.fifo_second_to_go_out){Thread.sleep(1000);}
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
                if (beehive.fifo_first_to_go_in.is_Empty() && (beehive.first_gate_thru_out_to_in || (beehive.fifo_second_to_go_out.start == null|| beehive.fifo_first_to_go_out.start == null)))
                {
                        return true;
                }
                else
                {
                        return false;
                }
        }

        @Override
        public void run() {
                int j =0;
                boolean end = true;
                while(end) {
                        int rand = new Random().nextInt(5000);
                        try {
                                Thread.sleep(5000+rand);
                        } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                        rand=new Random().nextInt(2);
                        // pszczoła losowo wybiera przejscie którym chce wejść do ula
                        if (allow_going_function_first_to_go_in() && rand==1 && beehive.it_ok ) {
                                thru_first_gate_to_go_in();
                                //przelatuje
                        }
                        else if (beehive.fifo_second_to_go_in.is_Empty() && beehive.second_gate_thru_out_to_in) {
                                thru_second_gate_to_go_in();
                                //przelatuje
                                System.out.println("wleciałam do ula wejsciem drugim :"+bee_index);
                        }
                        else {
                                // losowo przczolka dobiera sobie kolejkę do przejscia
                                Random random = new Random();
                                int random_gate=random.nextInt(2);
                                double start_in_queque1 = System.currentTimeMillis();
                                if (random_gate==1) {
                                        add_to_fifo(beehive.fifo_first_to_go_in,bee_index);
                                        System.out.println("Czekam w kolejce pierwszej do wlecenia do ula :"+bee_index);
                                        thru_gate_sequence_first_gate_to_go_in();


                                } else {
                                        add_to_fifo(beehive.fifo_second_to_go_in,bee_index);
                                        System.out.println("Czekam w kolejce drugiej do wlecenia do ula :"+bee_index);
                                        thru_gate_sequence_second_gate_to_go_in();

                                }
                                double end_in_queque1= System.currentTimeMillis();
                                time+=end_in_queque1-start_in_queque1;
                        }

                        // wleciala do ula
                        try {
                                int rand2 = new Random().nextInt(4000);
                                Thread.sleep(1000+rand2);
                        } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                        }
                        if (beehive.fifo_first_to_go_out.is_Empty() && (!beehive.first_gate_thru_out_to_in || (beehive.fifo_second_to_go_in.start == null|| beehive.fifo_first_to_go_in.start == null))) {
                                thru_first_gate_to_go_out();
                                System.out.println("Wyleciałam z ula pierwszym przjesciem :"+bee_index);
                                //przelatuje
                        } else if (beehive.fifo_second_to_go_out.is_Empty() && (!beehive.second_gate_thru_out_to_in || (beehive.fifo_second_to_go_in.start == null|| beehive.fifo_first_to_go_in.start == null))) {
                                thru_second_gate_to_go_out();
                                System.out.println("Wyleciałam z ula drugim przjesciem :"+bee_index);
                                //przelatuje
                        } else {
                                // losowo przczolka dobiera sobie kolejkę do przejscia
                                Random random = new Random();
                                int random_gate=random.nextInt(2);
                                double start_in_queque2 = System.currentTimeMillis();
                                if (random_gate==1) {
                                        add_to_fifo(beehive.fifo_first_to_go_out,bee_index);
                                        System.out.println("Czekam w kolejce pierwszej do wylecenia z ula :"+bee_index);
                                        thru_gate_sequence_first_gate_to_go_out();


                                } else {
                                        add_to_fifo(beehive.fifo_second_to_go_out,bee_index);
                                        System.out.println("Czekam w kolejce drugiej do wylecenia z ula :"+bee_index);
                                        thru_gate_sequence_second_gate_to_go_out();

                                }
                                double end_in_queque2 = System.currentTimeMillis();
                                time+=end_in_queque2-start_in_queque2;
                        }
                        // ustaliłem że pszczoła robi 10 takich cykli
                        average=time/ilosc_wylotow;
                        if(j==1)
                        {
                                beehive.write_to_file("resoults.txt",ilosc_wlotow,ilosc_wlotow,average,bee_index);
                                end=false;
                        }
                        j++;
                        // koniec sekwencji dzialania pszczoly cykl powtarza sie


                }
        }
}
