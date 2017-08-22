package pl.sda.javawwa.Model.Older;

public class Mother extends Parent {

    public Mother(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "name='" + name + '\'' +
                '}';
    }
}
