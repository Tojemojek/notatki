package pl.sda.javawwa.Model;

public class Skrzypek extends Muzyk {

    private final String INSTRUMENT = "skrzypce";

    public Skrzypek(String imięINazwisko, int interwal) {
        super(imięINazwisko, interwal);
    }

    @Override
    public void graj() {
        System.out.println("Jestem " + super.getImięINazwisko() + " i mój instrument to " + INSTRUMENT);
    }


}
