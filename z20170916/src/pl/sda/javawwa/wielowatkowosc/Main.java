package pl.sda.javawwa.wielowatkowosc;


public class Main {

    /*
    Thread - wątek - pojedyncze zadanie - lekki ma dostęp do zasobów
    Proces - zbiór wielu wątków

    jenkov tutorials concurency
    */


    public static void main(String[] args) {


//        MyThread t1 = new MyThread("wątek 1");
//        MyThread t2 = new MyThread("wątek 2");
//        MyThread t3 = new MyThread("wątek 3");
//        MyThread t4 = new MyThread("wątek 4");
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        MyThread tab[] = new MyThread[10];


        for (int i = 0; i < 10; i++){
            tab[i] = new MyThread("wątek"+i);
        }

        for (int i = 0; i < 10; i++){
            tab[i].start();
        }





    }





}
