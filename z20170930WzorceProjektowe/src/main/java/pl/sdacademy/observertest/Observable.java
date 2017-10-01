package pl.sdacademy.observertest;

public interface Observable {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(String news);

}
