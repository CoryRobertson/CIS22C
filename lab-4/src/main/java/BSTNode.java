/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 4
 Statement of Lab: To demonstrate the functionality of Binary Search Trees using the 4 traversal methods
 */
public class BSTNode {

    private Dollar data;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(Dollar dollar) {
        this.data = dollar;
        leftChild = null;
        rightChild = null;
    }

    public Dollar getData() {
        return data;
    }

    public void setData(Dollar data) {
        this.data = data;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}