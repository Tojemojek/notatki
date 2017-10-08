package pl.sda.javawwa;

import pl.sda.javawwa.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Muzyk> muzycyTmp = new ArrayList<Muzyk>();
        muzycyTmp.add(new Skrzypek("A", 2000));
        muzycyTmp.add(new Wiolonczelista("B", 3000));
        muzycyTmp.add(new Skrzypek("C", 1000));
        muzycyTmp.add(new Wiolonczelista("D", 4000));


        Orkiestra muzycy = new Orkiestra(muzycyTmp);

        System.out.println("\n\n\nKoncert na forEach\n");
        System.out.println("Zaczynamy koncert od przedstawienia się muzyków");

        muzycy.grajKoncert();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 21; i++) {
            System.out.println("Metronom s: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}


