package pl.sda.javawwa.Model;

public class Skrzypek extends Muzyk {

    private final String INSTRUMENT = "skrzypce";

    public Skrzypek(String imięINazwisko, int interwal) {
        super(imięINazwisko, interwal);
    }

    @Override
    public void graj() {
        Runnable gr = () -> {
            while(true) {
                System.out.println("Jestem " + getImięINazwisko() +
                        " i mój instrument to " + INSTRUMENT+ " i gram co " + getInterwal());
                try {
                    Thread.sleep(getInterwal());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread mojWatekMuzyka = new Thread(gr);
        mojWatekMuzyka.setDaemon(true);
        mojWatekMuzyka.start();
    }
}
