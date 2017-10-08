package pl.sda.javawwa.SerializacjiaJson;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FromString {


    public Object fromString(String s, Class klasa) throws Exception {

        Map<String, String> mapaPol = stworzMape(s, klasa);
        Object instance = klasa.newInstance();

        for (Field f : klasa.getDeclaredFields()) {
            f.setAccessible(true);
            if (mapaPol.containsKey(f.getName())) {
                String wartosc = mapaPol.get(f.getName());

                if (f.getType().isPrimitive()) {
                    f.set(instance, Integer.valueOf(wartosc).intValue());
                } else {
                    f.set(instance, mapaPol.get(f.getName()));
                }


            }
        }

        // znaleźć
        // jak w mechanizmie refleksji pobrać konstruktor i
        // dodać do konstruktora dane które mamy sparsowane
        //

        return instance;
    }

    private Map<String, String> stworzMape(String zawartosc, Class klasa) {

        Map<String, String> daneWMapie = new HashMap<>();

        zawartosc = zawartosc.replace("{", "");
        zawartosc = zawartosc.replace("}", "");

        String[] daneZJSON = zawartosc.split(",");

        for (String s : daneZJSON) {
            String[] split = s.split(":");
            daneWMapie.put(usunZnaki(split[0]), usunZnaki(split[1]));
        }


        return daneWMapie;
    }

    private String usunZnaki(String s) {
        if (s.startsWith("\"")) {
            s = s.substring(1, s.length());
        }
        if (s.endsWith("\"")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}
