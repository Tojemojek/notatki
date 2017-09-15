package pl.sda.javawwa.kolekcjePracaDomowa;

public class MainLinkedListPD {

    public static void main(String[] args) {

        MyLinkedListPD<String> mllString = new MyLinkedListPD<>();

        mllString.add("5");
        mllString.add("10");
        mllString.add("20");
        mllString.add("30");

        System.out.println("\nTest czy działa add i traverse");
        mllString.traverse();


        System.out.println("\nTest czy działa for each");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy działa dodanie po elemencie");

        mllString.addAfter("30", "999999");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy dodatnie bez znalezionego elementu");

        mllString.addAfter("99", "99");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy działa usunięcie head - wyświetlenie for each");

        mllString.removeHead();

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nTest czy zbudowanie streama działa");
        System.out.println("powinno się wyświetlić to samo co wyżej");
        mllString.stream()
                .forEach(System.out::println);

        System.out.println("\nTu jest wielokrotne usunięcie head");
        mllString.removeHead();
        mllString.removeHead();
        mllString.removeHead();
        mllString.removeHead();
        mllString.removeHead();

        System.out.print("\nTest czy działa wielokrotne usunięcie head");
        System.out.println("\nnie powinno się nic pojawić");
        for (String s : mllString) {
            System.out.println(s);
        }



        System.out.println("\nPonowne dodanie do listy elementów");

        mllString.add("5");
        mllString.add("10");
        mllString.add("20");
        mllString.add("30");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nRozmiar listy to " + mllString.size());

        mllString.add("30");

        System.out.println("\nRozmiar listy po dodaniu jeszcze jednego elementu to " + mllString.size());

        System.out.println("\nPróba usunięcia ogona");
        System.out.println("\nPrzed usunięciem");
        for (String s : mllString) {
            System.out.println(s);
        }
        mllString.removeTail();

        System.out.println("\nPo usunięciu");
        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nSprawdzenie czy zawiera \"30\" " + mllString.contains("30"));
        System.out.println("\nSprawdzenie czy zawiera \"31\" " + mllString.contains("31"));


        System.out.println("\nPróba usunięcia elementu stojącego za \"10\"");
        mllString.removeAfter("10");

        for (String s : mllString) {
            System.out.println(s);
        }

        System.out.println("\nPróba usunięcia elementu stojącego za \"10\"");
        mllString.removeAfter("10");

        for (String s : mllString) {
            System.out.println(s);
        }



        System.out.println("\nPróba usunięcia elementu stojącego za \"999\"");
        mllString.removeAfter("999");

        for (String s : mllString) {
            System.out.println(s);
        }


    }




}
