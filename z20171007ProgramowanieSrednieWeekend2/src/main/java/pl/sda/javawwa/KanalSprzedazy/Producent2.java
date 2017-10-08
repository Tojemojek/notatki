package pl.sda.javawwa.KanalSprzedazy;

public class Producent2 {

    private String[] produkty;

    public Producent2(String[] produkty) {
        this.produkty = produkty;
    }


    public void produkuj(KanałSprzedaży ks) {
        new Thread(() -> {

            for (String s : produkty) {
                while (true) {
                    synchronized (ks) {
                        if (ks.czyZajety()) {
                            try {
                                ks.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            ks.wystaw(s);
                            System.out.println("Wystawiam " + s);
                            ks.notifyAll();
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}
