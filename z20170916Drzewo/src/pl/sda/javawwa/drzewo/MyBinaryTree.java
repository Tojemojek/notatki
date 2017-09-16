package pl.sda.javawwa.drzewo;

public class MyBinaryTree<T extends Comparable<T>> {

    private MyBinaryTreeNode<T> root;
    private int size = 0;

    public void add(T value) {

        MyBinaryTreeNode<T> newNode = new MyBinaryTreeNode<>(value);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        MyBinaryTreeNode<T> tmpNode = root;
        MyBinaryTreeNode<T> parent;


        while (true) {
            parent = tmpNode;
            if (tmpNode.getValue().equals(value)) {
                System.out.println("Duplikatów nie obsługujemy");
                return;
            }

            if (value.compareTo(tmpNode.getValue()) < 0) {
                tmpNode = tmpNode.getLeftChild();
                if (tmpNode == null) {
                    parent.setLeftChild(newNode);
                    size++;
                    return;
                }
            } else {
                tmpNode = tmpNode.getRightChild();
                if (tmpNode == null) {
                    parent.setRightChild(newNode);
                    size++;
                    return;
                }
            }
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public void preOrderTraversal() {
        postOrderTraversal(root);
    }

    public boolean contains(T value) {

        MyBinaryTreeNode<T> tmpNode = root;

        while (!tmpNode.getValue().equals(value)) {
            if (value.compareTo(tmpNode.getValue()) < 0) {
                tmpNode = tmpNode.getLeftChild();
            } else {
                tmpNode = tmpNode.getRightChild();
            }
            if (tmpNode == null) {
                return false;
            }
        }
        return true;
    }


    private void inOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.println(node.getValue());
            inOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            inOrderTraversal(node.getRightChild());
            System.out.println(node.getValue());
        }
    }

    private void preOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            System.out.println(node.getValue());
            inOrderTraversal(node.getLeftChild());
            inOrderTraversal(node.getRightChild());
        }
    }

    public int size() {
        return size;
    }
}
