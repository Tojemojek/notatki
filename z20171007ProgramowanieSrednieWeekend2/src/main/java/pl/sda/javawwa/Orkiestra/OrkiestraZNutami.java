package pl.sda.javawwa.Orkiestra;

import java.util.List;

public class OrkiestraZNutami {

    List<Muzyk> muzycy;
    List<Nuty> nutyList;

    public OrkiestraZNutami(List<Muzyk> muzycy, List<Nuty> nutyList) {
        this.muzycy = muzycy;
        this.nutyList = nutyList;
    }

    public void grajKoncertNaWieluWatkach() {
        for (int i = 0; i < muzycy.size(); i++) {
            Muzyk muzykTmp = muzycy.get(i);
            int[] nutyTmp = nutyList.get(i).getNuty();
            Runnable gr = () ->
            {
                try {
                    Thread.sleep(nutyTmp[0] * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                muzykTmp.graj();
                for (int j = 1; j < nutyTmp.length; j++) {
                    try {
                        Thread.sleep((nutyTmp[j] - nutyTmp[j - 1]) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    muzykTmp.graj();
                }

            };
            Thread muzykGrajTmp = new Thread(gr);
            muzykGrajTmp.start();
        }
    }
}

