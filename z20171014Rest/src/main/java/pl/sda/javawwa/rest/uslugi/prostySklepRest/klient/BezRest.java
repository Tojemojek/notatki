package pl.sda.javawwa.rest.uslugi.prostySklepRest.klient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.OrderItem;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Produkt;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Sklep;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Zamowienie;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class BezRest {

    public static void main(String[] args) {

        Sklep sklep = new Sklep();

        Gson gson = new Gson();
        Type produktyType = new TypeToken<List<Produkt>>() {
        }.getType();

        Collection<Produkt> produkty = null;

        try (JsonReader jsonReader = new JsonReader(new FileReader("daneProduktow.json"))) {
            produkty = gson.fromJson(jsonReader, produktyType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Produkt produkt : produkty) {
            sklep.dodajProdukt(produkt);
        }

        for (Produkt produkt : sklep.produkty()) {
            System.out.println(produkt);
        }

        Zamowienie zamowienie = sklep.stworz();

        OrderItem oi = new OrderItem(sklep.pokazProdukt(10),10);

        zamowienie.addItemToZamowienie(oi);

        System.out.println(zamowienie);


    }
}
