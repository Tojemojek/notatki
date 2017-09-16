package pl.sda.javawwa.wielowatkowoscPodstawy;


public class MainMyThread {

    /*
    Thread - wątek - pojedyncze zadanie - lekki ma dostęp do zasobów
    Proces - zbiór wielu wątków

    jenkov tutorials concurency

    metoda join - zapobiega przerwaniu wątku - trzeba czekać aż się skończy
    metoda start - TWORZY tak naprawdę wątek uruchamia metodę run
    metoda run - po prostu wywołuje metodę
    dwa razy wywołania wątku metodą start nie jest możliwe pokazuje się wyjątek
    IllegalThreadStateException

    */


    public static void main(String[] args) throws InterruptedException {


//        MyThread t1 = new MyThread("wątek 1");
//        t1.start();


        MyThread tab[] = new MyThread[10];


        for (int i = 0; i < 10; i++) {
            tab[i] = new MyThread("wątek" + i);
        }

        for (int i = 0; i < 10; i++) {
            tab[i].start();
        }

        MyThread tab2[] = new MyThread[10];

        for (int i = 0; i < 10; i++) {
            tab2[i].start();
            tab2[i].join();
        }
    }
}
