package pl.sda.javawwa.rest.uslugi.prostySklepRest.klient;

import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Produkt;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Zamowienie;

import java.math.BigDecimal;
import java.util.Collection;

public class MainSklepKlient {


    public static void main(String[] args) {

        SklepKlient klient = new SklepKlient("http://localhost:8888");
        Collection<Produkt> produkty = klient.produkty();


        System.out.println(produkty);
        System.out.println(klient.pokazProdukt(0));

        Produkt nowy = new Produkt();
        nowy.setNazwa("nowa nazwa");
        nowy.setCena(new BigDecimal("1234"));
        klient.dodajProdukt(nowy);
        System.out.println(klient.produkty());

        Zamowienie z = klient.stworzZamowienie();
        System.out.println(z);

    }
}
