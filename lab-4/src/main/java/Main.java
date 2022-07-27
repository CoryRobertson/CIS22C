
public class Main {
    public static void main(String[] args)
    {
        BST tree = new BST();

//        tree.setRoot(new BSTNode(new Dollar(1.0)));
//        tree.getRoot().setLeftChild(new BSTNode(new Dollar(2.0)));
//        tree.getRoot().setRightChild(new BSTNode(new Dollar(3.0)));
//        tree.getRoot().getLeftChild().setLeftChild(new BSTNode(new Dollar(4.0)));
//        tree.getRoot().getLeftChild().setRightChild(new BSTNode(new Dollar(5.0)));
        tree.insert(new Dollar(1.0));
        tree.insert(new Dollar(2.0));
        tree.insert(new Dollar(3.0));
        tree.insert(new Dollar(4.0));
        tree.insert(new Dollar(5.0));
        tree.insert(new Dollar(2.5));


        tree.printInOrder(tree.getRoot());
    }

}