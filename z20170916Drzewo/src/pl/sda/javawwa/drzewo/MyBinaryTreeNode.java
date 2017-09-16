package pl.sda.javawwa.drzewo;

public class MyBinaryTreeNode<T> {

    private MyBinaryTreeNode<T> leftChild;
    private MyBinaryTreeNode<T> rightChild;
    private T value;


    public MyBinaryTreeNode(T value) {
        this.value = value;
    }

    public MyBinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyBinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public MyBinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyBinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
