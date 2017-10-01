package pl.sdacademy.observertest;

public class MyObserver implements Observer {
    private String name;

    @Override
    public void update(String s) {
        System.out.println("Obserwator o nazwie: " + name + "\t obserwuje i zauważył zmianę : " + s);
    }

    MyObserver(String name) {
        this.name = name;
    }
}