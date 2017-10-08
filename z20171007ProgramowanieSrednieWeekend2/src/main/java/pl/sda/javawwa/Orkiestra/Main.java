package pl.sda.javawwa.Orkiestra;

import pl.sda.javawwa.Orkiestra.*;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Muzyk> muzycyTmp = new ArrayList<Muzyk>();
        muzycyTmp.add(new Skrzypek("A", 2000));
        muzycyTmp.add(new Wiolonczelista("B", 3000));
        muzycyTmp.add(new Skrzypek("C", 2000));
        muzycyTmp.add(new Wiolonczelista("D", 3000));

        List<Nuty> nutyTmp = new ArrayList<Nuty>();
        nutyTmp.add(new Nuty(new int[]{1, 2, 3}));
        nutyTmp.add(new Nuty(new int[]{3, 4, 5}));
        nutyTmp.add(new Nuty(new int[]{5, 6, 7}));
        nutyTmp.add(new Nuty(new int[]{7, 8, 9}));


        Orkiestra muzycy = new Orkiestra(muzycyTmp);
        OrkiestraZNutami muzycyZNutami = new OrkiestraZNutami(muzycyTmp, nutyTmp);

        System.out.println("\n\n\nKoncert na forEach\n");
        muzycy.grajKoncert();

        System.out.println("\n\n\nKoncert na stream\n");
        muzycy.grajKoncertStream();


//        System.out.println("\n\n\nKoncert z użyciem wait\n");
//        muzycy.grajKoncertZWait();


//        System.out.println("\n\n\nKoncert z użyciem wielu wątków\n");
//        muzycy.grajKoncertNaWieluWatkach();
//        for (int i = 0; i < 12; i++) {
//            System.out.println("Metronom s: " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        System.out.println("\n\n\nKoncert z użyciem nut i wielu wątków\n");
        muzycyZNutami.grajKoncertNaWieluWatkach();
        for (int i = 0; i < 12; i++) {
            System.out.println("Metronom s: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


