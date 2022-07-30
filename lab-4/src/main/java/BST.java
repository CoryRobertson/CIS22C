/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 4
 Statement of Lab: To demonstrate the functionality of Binary Search Trees using the 4 traversal methods
 */
public class BST {
    private BSTNode root;

    public BST() {
        root = null;
    }

    public BST(Currency... cur) {
        root = null;
        for (Currency currency : cur) {
            this.insert((Dollar) currency);
        }
    }

    /**
     * pre: A BSTNode that is not null
     * post: Returns to the order of left Node, right node
     * and parent node till there are no more nodes to report.
     **/
    public void printPostorder(BSTNode node, boolean log) {
        if (node == null) { // null check
            return;
        }
        // print ordering for post order
        printPostorder(node.getLeftChild(), log);
        printPostorder(node.getRightChild(), log);
        if (log) {
            Main.log(node.getData().toString());
        }
        System.out.println(node.getData());

    }

    /**
     * pre: A BSTNode that is not null
     * post: Returns to the order of parent node, left node
     * and right node till there are no more nodes to report.
     **/
    public void printPreorder(BSTNode node, boolean log) {
        if (node == null) { // null check
            return;
        }
        // print ordering for preorder
        if (log) {
            Main.log(node.getData().toString());
        }
        System.out.println(node.getData());
        printPreorder(node.getLeftChild(), log);
        printPreorder(node.getRightChild(), log);

    }

    /**
     * pre: A BSTNode that is not null
     * post: Returns the count of nodes within the BST
     **/
    public int count(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.getLeftChild()) + count(node.getRightChild());
    }

    /**
     * pre: A BSTNode that is not null
     * post: Returns in the order of left Node, parent node
     * and right node till there are no more nodes to report.
     **/
    public void printInOrder(BSTNode node, boolean log) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild(), log);

        System.out.println(node.getData());
        if (log) {
            Main.log(node.getData().toString());
        }
        printInOrder(node.getRightChild(), log);

    }

    /**
     * pre: A BST root that is not null
     * post: Returns the height of the BST subrtacted by 1
     **/
    public int getHeight(BSTNode root) {
        return height(root) - 1;
    }

    /**
     * pre: A BST root that is not null
     * post: Returns 0 if the root of the BST is null
     **/
    private int height(BSTNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.getLeftChild());
        int rightHeight = height(root.getRightChild());

        if (leftHeight > rightHeight) {
            return (leftHeight + 1);
        } else {
            return (rightHeight + 1);
        }
    }

    /**
     * pre: nothing
     * post: Returns a in the order of left Node, right node
     * and parent node till there are no more nodes to report.
     **/
    public void printLevelOrder(boolean log) {
        printLevelOrder(this.getRoot(), log);
    }

    /**
     * pre: A BSTNode that is not null
     * post: Returns a in the order of left Node, right node
     * and parent node till there are no more nodes to report.
     **/
    public void printLevelOrder(BSTNode node, boolean log) {
        int he = getHeight(node);
        for (int i = 0; i <= he + 1; i++) {
            printCurrentLevel(node, i, log);
        }
    }

    private void printCurrentLevel(BSTNode root, int level, boolean log) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            if (log) {
                Main.log(root.getData().toString());
            }
            System.out.println(root.getData());
        } else if (level > 1) {
            printCurrentLevel(root.getLeftChild(), level - 1, log);
            printCurrentLevel(root.getRightChild(), level - 1, log);
        }
    }

    /**
     * pre: a valid non null Dolllar object
     * post: removes the given dollar object if found in the tree, returns null if
     * not found.
     */
    public BSTNode delete(Dollar key) {
        return delete(this.getRoot(), key);
    }

    /**
     * pre: a valid non-null node, commonly root, and a valid non null Dolllar
     * object
     * post: removes the given dollar object if found in the tree, returns null if
     * not found.
     */
    public BSTNode delete(BSTNode root, Dollar key) {

        if (root == null) {
            return root;
        }

        double keyv = key.toDouble();
        double rootkey = root.getData().toDouble();

        if (keyv < rootkey) {
            root.setLeftChild(delete(root.getLeftChild(), key));
        } else if (keyv > rootkey) {
            root.setRightChild(delete(root.getRightChild(), key));
        } else {

            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }

            root.setData(minValue(root.getRightChild()));

            root.setRightChild(delete(root.getRightChild(), root.getData()));
        }

        return root;

    }

    /**
     * pre: a valid node
     * post: returns the smalles value of an object in the given node tree
     */
    private Dollar minValue(BSTNode root) {
        Dollar min = root.getData();
        while (root.getLeftChild() != null) {
            min = root.getLeftChild().getData();
            root = root.getLeftChild();
        }
        return min;
    }

    /**
     * pre: A BSTNode that is not null and a Dollar value
     * post: Returns the specific dollar value that was searched.
     **/
    public BSTNode search(Dollar key) {
        return search(this.getRoot(), key);
    }

    /**
     * pre: A BSTNode that is not null and a Dollar value
     * post: Returns the specific dollar value that was searched.
     **/
    public BSTNode search(BSTNode root, Dollar key) {
        // if tree is empty or the root has the key
        if (root == null || root.getData().isEqual(key)) {
            return root;
        }

        if (!root.getData().isGreater(key)) {
            return search(root.getRightChild(), key);
        }

        return search(root.getLeftChild(), key);
    }

    /**
     * pre: a valid non-null bst-node and dollar object to insert into the tree
     * post: adds the given node to the tree, to the right place such that the tree
     * is still valid
     */
    private BSTNode insert(BSTNode root, Dollar key) {

        if (root == null) { // root is empty, so make root contain the new key
            root = new BSTNode(key);
            return root;
        }

        if (root.getData().isGreater(key)) // decision to add to the left or right of the currently searched node
        {
            root.setLeftChild(insert(root.getLeftChild(), key));
        } else if (key.isGreater(root.getData())) {
            root.setRightChild(insert(root.getRightChild(), key));
        }

        return root;
    }

    /**
     * pre: a dollar object to insert into the tree
     * post: adds the given node to the tree, to the right place such that the tree
     * is still valid
     */
    public void insert(Dollar key) {
        root = insert(root, key);
    }

    /**
     * pre: nothing
     * post: returns if the list is empty
     */
    public boolean isEmpty() {
        return this.getRoot() == null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }
}
