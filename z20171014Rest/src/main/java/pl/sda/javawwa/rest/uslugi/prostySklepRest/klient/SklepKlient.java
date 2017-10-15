package pl.sda.javawwa.rest.uslugi.prostySklepRest.klient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Zamowienie;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Produkt;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.SklepInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SklepKlient implements SklepInterface {

    //Adres serwera gdzie umieszczony jest obiekt
    private String adresSerwera;

    //Klient http uzyty do komunikacji z obiektem zdalnym (na serwerze)
    private CloseableHttpClient httpclient = HttpClients.createDefault();

    //Instancja uzytkowa do serializacji/deserializacji
    private Gson gson = new Gson();

    //Pomocnicza instancja dla Gson do tworzenia kolekcji prodkuktow
    private Type produktyType = new TypeToken<List<Produkt>>() {}.getType();

    //Konstruktor
    public SklepKlient(String adres) {
        adresSerwera = adres;
    }

    @Override
    public Collection<Produkt> produkty() {
        String sciezka = adresSerwera + "/restowa/sklep/produkty";
        String produktyJson = wywolajGet(sciezka);
        if (produktyJson.isEmpty()) {
            return new ArrayList<>();
        }
        return gson.fromJson(produktyJson, produktyType);
    }

    @Override
    public Produkt pokazProdukt(int id) {
        String sciezka = adresSerwera + "/restowa/sklep/produkty/" + id;
        String produktJson = wywolajGet(sciezka);
        if (produktJson.isEmpty()) {
            return null;
        }
        return gson.fromJson(produktJson, Produkt.class);
    }

    @Override
    public Produkt dodajProdukt(Produkt produkt) {
        try {
            String produktJson = gson.toJson(produkt);
            StringBuffer wynik = wykonajPost(produktJson, "produkty");
            return gson.fromJson(wynik.toString(), Produkt.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Zamowienie stworzZamowienie() {

        StringBuffer wynik = wykonajPost("", "zamowienie");
        return gson.fromJson(wynik.toString(), Zamowienie.class);

    }

    private StringBuffer wykonajPost(String cialoPost, String gdzieWyslac) {
        HttpPost httpPost = new HttpPost("http://localhost:8888/restowa/sklep/" + gdzieWyslac);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Accept", "application/json");
        StringBuffer wynik;
        HttpEntity entity;
        wynik = null;
        try {
            entity = new StringEntity(cialoPost);
            httpPost.setEntity(entity);
            CloseableHttpResponse odpowiedz = httpclient.execute(httpPost);
            wynik = odczytajEncje(odpowiedz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wynik;
    }


    @Override
    public void usunProdukt(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void kupProdukt(int id) {

    }



    private String wywolajGet(String sciezka) {
        // Tworzymy zadanie do wyslania
        HttpGet httpGet = new HttpGet(sciezka);
        try {
            // Wysylamy zadanie
            CloseableHttpResponse odpowiedz = httpclient.execute(httpGet);
            // Odczytujemy odpowiedz
            StringBuffer wynik = odczytajEncje(odpowiedz);
            return wynik.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private StringBuffer odczytajEncje(CloseableHttpResponse odpowiedz) throws IOException {
        StringBuffer wynik = new StringBuffer();
        HttpEntity encja = odpowiedz.getEntity();
        if (encja == null || encja.getContent() == null) {
            return wynik;
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(encja.getContent()));
        String linia = "";
        // Czytamy linia po lini
        while ((linia = rd.readLine()) != null) {
            wynik.append(linia);
        }
        return wynik;
    }
}
