package pl.sda.wzorce.ObjectPoolExample;

public class Main {
    public static void main(String[] args) {

        ReusablePool mojZasob = ReusablePool.getInstance();


        System.out.println("\nMam łącznie 4 sztuki zasobów");
        System.out.println("Pobranie 1 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 2 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 3 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 4 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 5 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 6 zasobu " + mojZasob.acquireReusable());

        System.out.println("\nZwalniam 2 zasoby - samochód dwa i cztery");
        mojZasob.releaseReusable("Samochód cztery");
        mojZasob.releaseReusable("Samochód dwa");

        System.out.println("\nPróbuję pobrać 3 zasoby");
        System.out.println("Pobranie 1 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 2 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 3 zasobu " + mojZasob.acquireReusable());

        System.out.println("\nDodaję do puli samochody Audi i Mercedes");


        mojZasob.addObjectToPoll("Audi");
        mojZasob.addObjectToPoll("Mercedes");

        System.out.println("\nPróbuję pobrać 3 zasoby");
        System.out.println("Pobranie 1 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 2 zasobu " + mojZasob.acquireReusable());
        System.out.println("Pobranie 3 zasobu " + mojZasob.acquireReusable());


    }
}
