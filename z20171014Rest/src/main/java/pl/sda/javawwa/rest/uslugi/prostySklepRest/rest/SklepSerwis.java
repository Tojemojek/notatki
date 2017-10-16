package pl.sda.javawwa.rest.uslugi.prostySklepRest.rest;

import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Zamowienie;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Produkt;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.Sklep;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.domain.SklepInterface;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

@Path("/sklep")
public class SklepSerwis implements SklepInterface {

    private static Sklep sklep = new Sklep();

    static {
        Produkt domyslny = new Produkt();
        domyslny.setCena(new BigDecimal(15));
        domyslny.setNazwa("Produkt domyslny");
        sklep.dodajProdukt(domyslny);
    }

    @GET
    @Path("/produkty")
    public Collection<Produkt> produkty() {
        return sklep.produkty();
    }

    @GET
    @Path("/produkty/{id}")
    public Produkt pokazProdukt(@PathParam("id") int id) {
        return sklep.pokazProdukt(id);
    }

    @POST
    @Path("/produkty")
    public Produkt dodajProdukt(Produkt produkt) {
        return sklep.dodajProdukt(produkt);
    }

    @DELETE
    @Path("/produkty/{id}")
    public void usunProdukt(@PathParam("id") int id) {
        sklep.usunProdukt(id);
    }


    @POST
    @Path("/zamowienie")
    public Zamowienie dodajZamowienie() {
        return sklep.stworz();
    }

    @PUT
    @Path("/zamowienie/{uuid}/{prodID}/{ilosc}")
    public Zamowienie dodajDoZamowienia(@PathParam("uuid") UUID uuid, @PathParam("prodID") int prodId,@PathParam("ilosc") int ilosc ) {
        return sklep.dodajProdukt(uuid, prodId, ilosc);
    }

    @GET
    @Path("/zamowienie/{uuid}")
    public Zamowienie pokazZamowienie(@PathParam("uuid") UUID uuid) {
        return sklep.pokazZamowienie(uuid);
    }

    @GET
    @Path("/zamowienie/pokaz")
    public Collection<UUID> pokazZamowienia(){
        return sklep.pokazZamowienia();
    }


}
