package pl.sda.javawwa.rest.uslugi.prostySklepRest.domain;

import java.util.UUID;

public class Zamowienie {
    private UUID id;

    public Zamowienie() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "id=" + id +
                '}';
    }
}
