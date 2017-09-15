package pl.sda.javawwa.kolekcjePracaDomowa;

import pl.sda.javawwa.kolekcje.MyList;

public class MainSortedArrayListPD {

    public static void main(String[] args) {


        MyList<String> list = new MyArrayListWithSortPD<>();

        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.add("który");
        list.add("jest");
        list.add("wredny");

        System.out.println("\nLista przed sortowaniem buble");
        list.forEach(System.out::println);

        ((MyArrayListWithSortPD) list).bubblesort();

        System.out.println("\nLista po sortowaniu bubble");
        list.forEach(System.out::println);

        MyList<String> list2 = new MyArrayListWithSortPD<>();

        list2.add("Ala");
        list2.add("ma");
        list2.add("kota");
        list2.add("który");
        list2.add("jest");
        list2.add("wredny");


        System.out.println("\nLista przed sortowaniem insertion");
        list2.forEach(System.out::println);

        ((MyArrayListWithSortPD) list2).inserionSort();

        System.out.println("\nLista po sortowaniu insertion");
        list2.forEach(System.out::println);

        System.out.println("\nSprawdzamy wyszukiwanie metodą binary search");
        int indexKota = ((MyArrayListWithSortPD) list2).findInSortedArray("kota");

        System.out.println("\nIndex na którym jest słowo \"kota\" " + indexKota);

        int indexDobrego = ((MyArrayListWithSortPD) list2).findInSortedArray("dobrego");
        System.out.println("\nIndex na którym jest słowo \"dobrego " + indexDobrego);


        MyList<String> list3 = new MyArrayListWithSortPD<>();

        list3.add("Ala");
        list3.add("ma");
        list3.add("kota");
        list3.add("który");
        list3.add("jest");
        list3.add("wredny");

        System.out.println("\nLista przed sortowaniem quickSort");
        list3.forEach(System.out::println);

        System.out.println("\nLista po sortowaniu quickSort");
        ((MyArrayListWithSortPD) list3).quickSort();
        list3.forEach(System.out::println);


        MyList<String> list4 = new MyArrayListWithSortPD<>();

        list4.add("Ala");
        list4.add("ma");
        list4.add("kota");
        list4.add("który");
        list4.add("jest");
        list4.add("wredny");

        System.out.println("\nLista przed usunięciem elementu\"kota\"");
        list4.forEach(System.out::println);

        System.out.println("\nLista po usunięciu elementu \"kota\"");
        ((MyArrayListWithSortPD) list4).remove("kota");
        list4.forEach(System.out::println);

        System.out.println("\nLista po usunięciu elementu \"który\"");
        ((MyArrayListWithSortPD) list4).remove("który");
        list4.forEach(System.out::println);


        System.out.println("\nLista po dodaniu na indeksie 2 słowa \"test1\"");
        ((MyArrayListWithSortPD) list4).add(2,"Test");
        list4.forEach(System.out::println);

        System.out.println("\nPróba dodania na indeksie 33");
        ((MyArrayListWithSortPD) list4).add(33,"Test");
        list4.forEach(System.out::println);


    }
}
