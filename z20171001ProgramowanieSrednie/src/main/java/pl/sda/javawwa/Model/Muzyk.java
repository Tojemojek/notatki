package pl.sda.javawwa.Model;

public abstract class Muzyk {


    private String imięINazwisko;
    private int interwal;

    public int getInterwal() {
        return interwal;
    }

    public Muzyk(String imięINazwisko, int interwal) {
        this.imięINazwisko = imięINazwisko;
        this.interwal= interwal;
    }

    public String getImięINazwisko() {
        return imięINazwisko;
    }


    abstract public void graj();

}
