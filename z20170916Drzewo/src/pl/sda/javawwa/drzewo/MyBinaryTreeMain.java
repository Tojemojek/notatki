package pl.sda.javawwa.drzewo;

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

        System.out.println("\nPróba dodania duplikatu");
        mbt.add(10);
        System.out.println("\nWyświetlenie drzewa posortowanego");
        mbt.inOrderTraversal();

        System.out.println("\nCzy w drzewie jest 17? " + mbt.contains(17));
        System.out.println("\nCzy w drzewie jest 999? " + mbt.contains(999));


        System.out.println("\nWyświetlenie drzewa postOrderTraversal");
        mbt.postOrderTraversal();

        System.out.println("\nWyświetlenie drzewa preOrderTraversal");
        mbt.preOrderTraversal();

        System.out.println("\nWielkość drzewa " + mbt.size());

    }
}
