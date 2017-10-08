package pl.sda.javawwa.KanalSprzedazy;

public class Konsument {


    public void konsumuj(KanałSprzedaży ks) {
        Thread t = new Thread(() -> {
            while (true) {
                synchronized (ks) {
                    if (ks.czyZajety()) {
                        String product = ks.pobierz();
                        System.out.println("Kupiłem: " + product);
                        ks.notifyAll();
                    } else {
                        try {
                            ks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        t.setDaemon(true);
        t.start();

    }
}
