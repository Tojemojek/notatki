package pl.sda.javawwa.rest.uslugi.prostySklepRest.klient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Produkt;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class MainSklepKlientDeserializacjaJson {


    public static void main(String[] args) {

        Gson gson = new Gson();
        Type produktyType = new TypeToken<List<Produkt>>() {
        }.getType();

        Collection<Produkt> produkty = null;

        try (JsonReader jsonReader = new JsonReader(new FileReader("daneProduktow.json"))) {
            produkty = gson.fromJson(jsonReader, produktyType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SklepKlient klient = new SklepKlient("http://localhost:8888");

        for (Produkt produkt : produkty) {
            klient.dodajProdukt(produkt);
        }
    }
}
