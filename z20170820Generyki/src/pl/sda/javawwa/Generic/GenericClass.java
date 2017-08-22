package pl.sda.javawwa.Generic;

import java.util.List;

public class GenericClass<T extends Namable> {

    private List<T> object;

    public GenericClass(List<T> objects) {
        this.object = objects;
    }


    public String getprintConcatenateNames(){

        StringBuilder sb = new StringBuilder();

        for (T t: object) {
            sb.append(t.getName());
        }
        return sb.toString();
    }



}
