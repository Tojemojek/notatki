package pl.sda.javawwa.Model;

public class Wiolonczelista extends Muzyk {

    private final String INSTRUMENT = "wiolonczela";

    public Wiolonczelista(String imięINazwisko, int interwal) {
        super(imięINazwisko, interwal);
    }

    @Override
    public void graj() {
        System.out.println("Jestem " + super.getImięINazwisko() + " i mój instrument to " + INSTRUMENT);
    }


}
