package pl.sda.javawwa;

import pl.sda.javawwa.Model.Muzyk;
import pl.sda.javawwa.Model.Orkiestra;
import pl.sda.javawwa.Model.Skrzypek;
import pl.sda.javawwa.Model.Wiolonczelista;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Muzyk> muzycyTmp = new ArrayList<Muzyk>();
        muzycyTmp.add(new Skrzypek("Jan Kowalski",2000));
        muzycyTmp.add(new Wiolonczelista("Jan Nowak",3000));
        muzycyTmp.add(new Skrzypek("Janina Kowalska",2000));
        muzycyTmp.add(new Wiolonczelista("Janina Nowak",3000));

        Orkiestra muzycy = new Orkiestra(muzycyTmp);

        System.out.println("\n\n\nKoncert na forEach\n");
        muzycy.grajKoncert();

        System.out.println("\n\n\nKoncert na stream\n");
        muzycy.grajKoncertStream();


//        System.out.println("\n\n\nKoncert z użyciem wait\n");
//        muzycy.grajKoncertZWait();


        System.out.println("\n\n\nKoncert z użyciem wielu wątków\n");
        muzycy.grajKoncertNaWieluWatkach();





    }
}


