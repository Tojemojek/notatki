package pl.sdacademy.observertest;

import java.util.ArrayList;
import java.util.List;

public class RealObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();

    private List<String> newsletterContent = new ArrayList<>();

    void addNewNewsletter(String newsletter) {
        newsletterContent.add(newsletter);
        notifyObservers(newsletter);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String news) {
        for (Observer o : observers) {
            o.update(news);
        }

    }

}
