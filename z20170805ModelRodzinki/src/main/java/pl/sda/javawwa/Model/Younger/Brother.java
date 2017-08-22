package pl.sda.javawwa.Model.Younger;

import pl.sda.javawwa.Model.Older.Father;
import pl.sda.javawwa.Model.Older.Mother;

public class Brother extends Sibling{

    public Brother(String name, Mother mother, Father father, TypeOfMember sisterOrBrother) {
        super(name, mother, father, sisterOrBrother);
    }

    @Override
    public String toString() {
        return "Brother{" +
                "name='" + name + '\'' +
                ", " + mother +
                ", " + father +
                '}';
    }



}

