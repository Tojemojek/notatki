package pl.sda.wzorce.builder;

public class Main {

    public static void main(String[] args) {

        System.out.println("To jest pierwszy obiekt zbudowany builderem");
        CupWithBuilder.CupBuilder cb = new CupWithBuilder.CupBuilder(10);
        System.out.println(cb.build());

        System.out.println("\nTo jest drugi obiekt zbudowany builderem - z dodatkowymi elementami");

        CupWithBuilder.CupBuilder cb2 = new CupWithBuilder.CupBuilder(18);
        cb2.colour("Czerwony");
        cb2.shape("Walcowy");
        System.out.println(cb2.build());
    }
}