package pl.sda.javawwa.drzewo;

import java.util.Iterator;
import java.util.stream.Stream;


public class MyBinaryTree<T extends Comparable<T>> implements Iterable<T> {

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
                    newNode.setParent(parent);
                    size++;
                    return;
                }
            } else {
                tmpNode = tmpNode.getRightChild();
                if (tmpNode == null) {
                    parent.setRightChild(newNode);
                    newNode.setParent(parent);
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
        preOrderTraversal(root);
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


    public int size() {
        return size;
    }

    private void inOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrderTraversal(node.getRightChild());
        }
    }

    private void postOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

    private void preOrderTraversal(MyBinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }


    private void traverseAndAddToStreamBuilder(MyBinaryTreeNode<T> node, Stream.Builder<T> builder) {

        if (node != null) {
            traverseAndAddToStreamBuilder(node.getLeftChild(), builder);
            builder.add(node.getValue());
            traverseAndAddToStreamBuilder(node.getRightChild(), builder);
        }
    }


    Stream<T> stream() {

        Stream.Builder<T> builder = Stream.builder();
        MyBinaryTreeNode<T> node = root;

        traverseAndAddToStreamBuilder(root, builder);

        return builder.build();
    }


    private MyBinaryTreeNode<T> findSmallest(MyBinaryTreeNode<T> startNode) {
        MyBinaryTreeNode<T> tmp = startNode;

        while (tmp.getLeftChild() != null) {
            tmp = tmp.getLeftChild();
        }
        return tmp;
    }


    private MyBinaryTreeNode<T> findGreaterThan(MyBinaryTreeNode<T> currentMin) {

        MyBinaryTreeNode<T> tmp = currentMin;

        if (tmp.getRightChild() != null) {
            tmp = tmp.getRightChild();
            tmp = findSmallest(tmp);
        } else if (tmp.getParent().getValue().compareTo(currentMin.getValue()) > 0) {
            tmp = tmp.getParent();
        } else if (tmp.getParent() == root) {
            tmp = root;
        } else {
            while (tmp.getParent().getRightChild()==tmp) {
                tmp = tmp.getParent();
            }
            tmp = tmp.getParent();
        }
        return tmp;
    }


    public void PrintAllIteracyjnie() {

        MyBinaryTreeNode<T> tmp;
        int howManyPrinted = 0;


        if (root == null) {
            System.out.println("Drzewo nie zawiera danych");
            return;
        } else {
            tmp = findSmallest(root);
            System.out.print(tmp.getValue() + " ");
            howManyPrinted++;
        }


        while (howManyPrinted < size) {
            tmp = findGreaterThan(tmp);
            System.out.print(tmp.getValue() + " ");
            howManyPrinted++;
        }
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            MyBinaryTreeNode<T> currentEl = root;
            MyBinaryTreeNode<T> max = root;
            boolean firstGo = true;

            void setMinMaxAtFirstGo() {
                while (currentEl.getLeftChild() != null) {
                    currentEl = currentEl.getLeftChild();
                }
                while (max.getRightChild() != null) {
                    max = max.getRightChild();
                }
            }

            @Override
            public boolean hasNext() {
                if (root == null) {
                    return false;
                }

                if (firstGo) {
                    setMinMaxAtFirstGo();
                    firstGo = false;
                }
                if (currentEl != null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public T next() {

                MyBinaryTreeNode<T> currentElTmp = currentEl;
                if (currentEl == max) {
                    currentEl = null;
                } else {
                    currentEl = findGreaterThan(currentEl);
                }
                return currentElTmp.getValue();
            }
        };
    }
}





