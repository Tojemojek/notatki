package pl.sda.javawwa.kolekcjeZSortowaniem;

import pl.sda.javawwa.kolekcje.MyList;

public class MainSortedArrayList {

    public static void main(String[] args) {


        MyList<String> list = new MyArrayListWithSort<>();

        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.add("który");
        list.add("jest");
        list.add("wredny");

        System.out.println("\nLista przed sortowaniem buble");
        list.forEach(System.out::println);

        ((MyArrayListWithSort) list).bubblesort();

        System.out.println("\nLista po sortowaniu bubble");
        list.forEach(System.out::println);

        MyList<String> list2 = new MyArrayListWithSort<>();

        list2.add("Ala");
        list2.add("ma");
        list2.add("kota");
        list2.add("który");
        list2.add("jest");
        list2.add("wredny");


        System.out.println("\nLista przed sortowaniem insertion");
        list2.forEach(System.out::println);

        ((MyArrayListWithSort) list2).inserionSort();

        System.out.println("\nLista po sortowaniu insertion");
        list2.forEach(System.out::println);

        System.out.println("\nSprawdzamy wyszukiwanie metodą binary search");
        int indexKota = ((MyArrayListWithSort) list2).findInSortedArray("kota");

        System.out.println("\nIndex na którym jest słowo \"kota\" " + indexKota);

        int indexDobrego = ((MyArrayListWithSort) list2).findInSortedArray("dobrego");
        System.out.println("\nIndex na którym jest słowo \"dobrego " + indexDobrego);


        MyList<String> list3 = new MyArrayListWithSort<>();

        list3.add("Ala");
        list3.add("ma");
        list3.add("kota");
        list3.add("który");
        list3.add("jest");
        list3.add("wredny");

        System.out.println("\nLista przed sortowaniem quickSort");
        list3.forEach(System.out::println);

        System.out.println("\nLista po sortowaniu quickSort");
        ((MyArrayListWithSort) list3).quickSort();
        list3.forEach(System.out::println);


    }
}
