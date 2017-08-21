package pl.sda.javawwa.dto;

import java.io.Serializable;

public class SerializableObject implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;
    private String nazwa;
    private Integer numer;


    public SerializableObject(String id, String nazwa, Integer numer) {
        this.id = id;
        this.nazwa = nazwa;
        this.numer = numer;
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "id='" + id + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", numer=" + numer +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getNumer() {
        return numer;
    }

    public void setNumer(Integer numer) {
        this.numer = numer;
    }
}
