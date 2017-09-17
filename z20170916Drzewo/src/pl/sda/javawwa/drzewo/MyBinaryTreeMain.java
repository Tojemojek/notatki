package pl.sda.javawwa.drzewo;

import java.util.Iterator;

public class MyBinaryTreeMain {


    public static void main(String[] args) {

        MyBinaryTree<Integer> mbt = new MyBinaryTree<>();


        System.out.println("\nPróba dodania elementów do drzewa");
        mbt.add(40);
        mbt.add(25);
        mbt.add(10);
        mbt.add(32);
        mbt.add(3);
        mbt.add(17);
        mbt.add(78);
        mbt.add(50);
        mbt.add(93);
        mbt.add(63);

        System.out.println("\nWyświetlenie drzewa inOrderTraversal");
        mbt.inOrderTraversal();

        System.out.println("\n\nPróba dodania duplikatu");
        mbt.add(10);

        System.out.println("\nCzy w drzewie jest 17 " + mbt.contains(17));
        System.out.println("Czy w drzewie jest 999 " + mbt.contains(999));

        System.out.println("\n\nWyświetlenie drzewa inOrderTraversal");
        mbt.inOrderTraversal();

        System.out.println("\n\nWyświetlenie drzewa postOrderTraversal");
        mbt.postOrderTraversal();

        System.out.println("\n\nWyświetlenie drzewa preOrderTraversal");
        mbt.preOrderTraversal();

        System.out.println("\n\nWielkość drzewa " + mbt.size());


        System.out.println("\nTest czy udało się zbudować stream ");

        mbt.stream()
                .forEach(s-> System.out.print(s + " "));

        System.out.println("\n\nIteracyjne przejście przez drzewo ");
        mbt.PrintAllIteracyjnie();

        System.out.println("\n\nTest iteratora");
        Iterator<Integer> it = mbt.iterator();

        System.out.println("Info - dodano 5 dodatkowych wartości");

        mbt.add(99);
        mbt.add(48);
        mbt.add(1);

        mbt.add(18);
        mbt.add(19);


        System.out.println("\nWyświetlenie elementów korzystając z iteratora ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\n\nIteracyjne przejście przez drzewo korzystając z funkcji iteracyjnie przechodzących ");
        mbt.PrintAllIteracyjnie();

        System.out.println("\n\nZliczanie elementów dzięki iteratorowi");
        Integer countElements = 0;

        Iterator<Integer> it2 = mbt.iterator();
        while (it2.hasNext()) {
            countElements++;
            it2.next();
        }

        System.out.println(String.format("W drzewie jest %d elementów", countElements));


    }
}
