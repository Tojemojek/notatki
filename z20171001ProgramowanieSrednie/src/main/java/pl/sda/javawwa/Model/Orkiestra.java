package pl.sda.javawwa.Model;

import java.util.ArrayList;
import java.util.List;

public class Orkiestra {

    List<Muzyk> muzycy;

    public Orkiestra(List<Muzyk> muzycy) {
        this.muzycy = muzycy;
    }

    public void grajKoncert() {
        for (Muzyk muzyk : muzycy) {
            muzyk.graj();
        }
    }

}

