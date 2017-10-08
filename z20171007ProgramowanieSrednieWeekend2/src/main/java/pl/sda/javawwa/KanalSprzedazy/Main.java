package pl.sda.javawwa.KanalSprzedazy;

public class Main {

    public static void main(String[] args) {


        KanałSprzedaży ks = new KanałSprzedaży();
        Producent producent = new Producent(new String[]{"Owoce", "Warzywa", "Mięso","Szczęście", "Pomyślność"});
        Konsument konsument = new Konsument();


        Producent2 producent2 = new Producent2(new String[]{"Owoce", "Warzywa", "Mięso","Szczęście", "Pomyślność"});
        KanałSprzedaży ks2 = new KanałSprzedaży();
        Konsument konsument2 = new Konsument();

        System.out.println("\nWersja z Producentem 1");
        konsument.konsumuj(ks);
        producent.produkuj(ks);


        //tu wymuszam żeby główny wątek na chwilkę się zatrzymał
        //żeby zdążyły się wykonać wątki które są powyżej
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nWersja z Producentem 2");
        konsument2.konsumuj(ks2);
        producent2.produkuj(ks2);



    }


}
