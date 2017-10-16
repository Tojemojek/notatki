package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Sklep implements SklepInterface, ZamowienieInterface {

    private int counter;

    private Map<Integer, Produkt> magazyn = new HashMap<Integer, Produkt>();
    private Map<UUID, Zamowienie> zamowienia = new HashMap<UUID, Zamowienie>();

    @Override
    public Collection<Produkt> produkty() {
        return magazyn.values();
    }


    @Override
    public Produkt pokazProdukt(int id) {
        return magazyn.get(id);
    }

    @Override
    public Produkt dodajProdukt(Produkt produkt) {
        produkt.setId(generujId());
        magazyn.put(produkt.getId(), produkt);
        return produkt;
    }

    @Override
    public void usunProdukt(int id) {
        magazyn.remove(id);
    }


    private int generujId() {
        return counter++;
    }


    @Override
    public Zamowienie stworz() {
        Zamowienie nowe = new Zamowienie();
        zamowienia.put(nowe.getId(), nowe);
        return nowe;
    }

    @Override
    public Zamowienie pokazZamowienie(UUID idZamowienia) {
        return zamowienia.get(idZamowienia);
    }

    public Collection<UUID> pokazZamowienia() {
        return zamowienia.keySet();
    }

    @Override
    public Zamowienie dodajProdukt(UUID idZamowienia, int idProduktu, int ilosc) {
        if (zamowienia.containsKey(idZamowienia) && magazyn.containsKey(idProduktu)) {
            Zamowienie zamowienieTmp = zamowienia.get(idZamowienia);
            OrderItem orderItem = new OrderItem(magazyn.get(idProduktu), ilosc);
            zamowienieTmp.addItemToZamowienie(orderItem);
            zamowienia.replace(idZamowienia,zamowienieTmp);
        }
        return zamowienia.get(idZamowienia);
    }

    @Override
    public Zamowienie usunProdukt(UUID idZamowienia, int idProduktu, int ilosc) {
        //ToDo dopisać sensowną implementację
        return null;
    }

    @Override
    public void zrealizuj(UUID idZamowienia) {
        //ToDo dopisać sensowną implementację
    }

    @Override
    public void anuluj(UUID idZamowienia) {
        //ToDo dopisać sensowną implementację
    }
}