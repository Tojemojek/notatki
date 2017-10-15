package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Zamowienie;

import java.util.UUID;

public interface ZamowienieInterface {

    Zamowienie stworz();

    Zamowienie pokazZamowienie(UUID idZamowienia);
    Zamowienie dodajProdukt(UUID idZamowienia, int idProduktu, int ilosc);
    Zamowienie usunProdukt(UUID idZamowienia, int idProduktu, int ilosc);

    void zrealizuj(UUID idZamowienia);
    void anuluj(UUID idZamowienia);

}
