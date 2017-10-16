package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import java.util.Collection;

public interface SklepInterface {

    Collection<Produkt> produkty();

    Produkt pokazProdukt(int id);

    Produkt dodajProdukt(Produkt produkt);

    void usunProdukt(int id);

}