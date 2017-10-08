package pl.sda.javawwa.KanalSprzedazy;

public class Producent {

    private static int nrKolejny = 0;
    private String[] produkty;
    private boolean shouldIRun = true;


    public Producent(String[] produkty) {
        this.produkty = produkty;
    }


    public void produkuj(KanałSprzedaży ks) {
        new Thread(() -> {
            while (shouldIRun) {
                synchronized (ks) {
                    if (ks.czyZajety()) {
                        try {
                            ks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        ks.wystaw(produkty[nrKolejny]);
                        System.out.println("Wystawiam " + produkty[nrKolejny]);
                        nrKolejny++;
                        if (nrKolejny >= produkty.length) {
                            shouldIRun = false;
                        }
                        ks.notifyAll();
                    }
                }
            }
        }).start();
    }
}
