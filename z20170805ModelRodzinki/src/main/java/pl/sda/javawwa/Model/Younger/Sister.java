package pl.sda.javawwa.Model.Younger;

import pl.sda.javawwa.Model.Older.Father;
import pl.sda.javawwa.Model.Older.Mother;

public class Sister extends Sibling{

    public Sister(String name, Mother mother, Father father, TypeOfMember sisterOrBrother) {
        super(name, mother, father, sisterOrBrother);
    }

    @Override
    public String toString() {
        return "Sister{" +
                "name='" + name + '\'' +
                ", " + mother +
                ", " + father +
                '}';
    }
}
