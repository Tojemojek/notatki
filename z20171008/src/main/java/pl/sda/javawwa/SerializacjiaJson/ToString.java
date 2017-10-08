package pl.sda.javawwa.SerializacjiaJson;

import java.lang.reflect.Field;

public class ToString {


    public String toString(Object osoba) {
        StringBuilder sb = new StringBuilder();
        boolean nextTry = false;

        Field[] pola = osoba.getClass().getDeclaredFields();
        sb.append("{\"");

        for (Field pole : pola) {
            if (nextTry) {
                sb.append(",\"");
            }
            sb.append(pole.getName());
            sb.append("\":");
            pole.setAccessible(true);
            try {
                if (pole.getType().isPrimitive()) {
                    sb.append(pole.get(osoba));
                } else {
                    sb.append("\"");
                    sb.append(pole.get(osoba));
                    sb.append("\"");
                }
                nextTry = true;
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            }
        }
        sb.append("}");

        return sb.toString();
    }

}
