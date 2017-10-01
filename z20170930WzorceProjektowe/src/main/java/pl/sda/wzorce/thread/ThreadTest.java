package pl.sda.wzorce.thread;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable job1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Wątek o nazwie: " + Thread.currentThread().getName());
                System.out.println("aaaaaaaaaaaa");
            }
        };
        Runnable job2 = new Job2();

        Thread worker1 = new Thread(job1);
        Thread worker2 = new Thread(job2);

        worker1.setName("Jestem WątkiemJednym");
        worker2.setName("Jestem WątkiemDrugim");

        System.out.println("Wątek o nazwie: " + Thread.currentThread().getName());

        worker1.start();
        worker1.join();
        // tu jest uwaga że to może rzucić błąd dodatkowo
        // w zasadzie trzeba sprawdzić czy wątek jeszcze jest żywy

        worker2.start();
        worker2.join();
        // tu jest uwaga że to może rzucić błąd dodatkowo
        // w zasadzie trzeba sprawdzić czy wątek jeszcze jest żywy

        System.out.println("finish");
    }
}

class Job2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Wątek o nazwie: " + Thread.currentThread().getName());
            System.out.println("d");
        }
    }
}