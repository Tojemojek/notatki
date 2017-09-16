package pl.sda.javawwa.wielowatkowoscPodstawy;


public class MainMyThreadRunnable {

    public static void main(String[] args) throws InterruptedException {

        MyThreadRunnable tr = new MyThreadRunnable("wątek runnable1");
        Thread th = new Thread(tr);
        th.start();

        //jednoliniowe uruchomienie
        new Thread(new MyThreadRunnable("wątek runnable2")).start();

        //z wyrażeniem Lambda
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Wykonuję wątek z interface funkcyjnego " + i);
            }
        }).start();


    }
}

