package pl.sda.javawwa.Model;

import java.util.ArrayList;
import java.util.List;

public class Orkiestra {

    final int HOW_MANY_TIMES = 3;
    List<Muzyk> muzycy;

    public Orkiestra(List<Muzyk> muzycy) {
        this.muzycy = muzycy;
    }

    public void grajKoncert() {
        for (int i = 0; i < HOW_MANY_TIMES; i++) {
            System.out.println("Takt " + i);
            for (Muzyk muzyk : muzycy) {
                muzyk.graj();
            }
        }
    }


    public void grajKoncertStream() {
        for (int i = 0; i < HOW_MANY_TIMES; i++) {
            System.out.println("Takt " + i);
            muzycy.forEach(m -> m.graj());
        }
    }

    public void grajKoncertZWait() {
        for (int i = 0; i < 12; i++) {
            System.out.println("Takt " + i + "sekunda");
            //skrzypek co 2 s a wiolonczelista co 3s
            for (Muzyk muzyk : muzycy) {
                if (muzyk instanceof Skrzypek && i % 2 == 0) {
                    muzyk.graj();
                }
                if (muzyk instanceof Wiolonczelista && i % 3 == 0) {
                    muzyk.graj();
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void grajKoncertNaWieluWatkach() {

        int czasKoncertu = 12;

        for (Muzyk muzyk : muzycy) {
            Runnable gr = () -> {
                for (int i = 0; i < (czasKoncertu * 1000 / muzyk.getInterwal()); i++) {
                    System.out.println(Thread.currentThread().getName());
                    muzyk.graj();
                    try {
                        Thread.sleep(muzyk.getInterwal());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread muzykTmp = new Thread(gr);
            muzykTmp.start();
        }
    }
}

