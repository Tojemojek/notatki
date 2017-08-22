package pl.sda.javawwa.Model.Younger;

import pl.sda.javawwa.Model.Older.Father;
import pl.sda.javawwa.Model.Older.Mother;

import java.lang.reflect.Type;

public abstract class Sibling {

    TypeOfMember sisterOrBrother;
    String name;
    Mother mother;
    Father father;

    public Sibling(String name, Mother mother, Father father, TypeOfMember sisterOrBrother) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.sisterOrBrother= sisterOrBrother;
    }

    public TypeOfMember getSisterOrBrother() {
        return sisterOrBrother;
    }

    public String getName() {
        return name;
    }
}
