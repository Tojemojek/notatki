package pl.sdacademy.observertest;

public class Main {

    public static void main(String[] args) {

        Observer Stalker1 = new MyObserver("Stalker1");
        Observer Stalker2 = new MyObserver("Stalker2");

        System.out.println("\nTworzę obiekt obserwowany i dodaję 2 obeserwatorów");
        RealObservable observable = new RealObservable();
        observable.registerObserver(Stalker2);
        observable.registerObserver(Stalker1);

        System.out.println("\nDodaję pierwszy news do obiektu obserwable");
        observable.addNewNewsletter("pierwszy news");

        System.out.println("\nUsuwam z listy obserwatorów Stalkera 1");
        observable.removeObserver(Stalker1);

        System.out.println("\nDodaję drugi news do obiektu obserwable");
        observable.addNewNewsletter("drugi news");
    }
}