public class BST
{
    private BSTNode root;

    public BST()
    {
        root = null;
    }

    // public BSTNode search(Dollar data)
    // {

    // }

    // public void insert(BSTNode node)
    // {

    // }

    // public void delete(Dollar data)
    // {

    // }

    // public void print()
    // {

    // }

    // public int count()
    // {

    // }

    public void printPostorder(BSTNode node)
    {
        if (node == null)
        {
            return;
        }

        printPostorder(node.getLeftChild());
        printPostorder(node.getRightChild());

        System.out.println(node.getData());

    }

    public void printPreorder(BSTNode node)
    {
        if (node == null)
        {
            return;
        }
        System.out.println(node.getData());
        printPreorder(node.getLeftChild());
        printPreorder(node.getRightChild());

    }

    public int count(BSTNode node)
    {
        if(node == null) {return 0;}

        return 1 + count(node.getLeftChild()) + count(node.getRightChild());
    }

    public void printInOrder(BSTNode node)
    {
        if (node == null)
        {
            return;
        }
        printInOrder(node.getLeftChild());
        System.out.println(node.getData());
        printInOrder(node.getRightChild());


    }

    public int getHeight(BSTNode root)
    {
        return height(root) - 1;
    }
    private int height(BSTNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftHeight = height(root.getLeftChild());
        int rightHeight = height(root.getRightChild());

        if(leftHeight > rightHeight)
        {
            return (leftHeight + 1);
        }
        else
        {
            return (rightHeight + 1);
        }
    }

    public void printLevelOrder(BSTNode node)
    {
        int he = getHeight(node);
        for( int i = 0; i <= he + 1 ; i++)
        {
            printCurrentLevel(node, i);
        }
    }

    public void printCurrentLevel(BSTNode root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == 1)
        {
            System.out.println(root.getData());
        }
        else if(level > 1)
        {
            printCurrentLevel(root.getLeftChild(), level - 1);
            printCurrentLevel(root.getRightChild(), level - 1);
        }
    }

    public BSTNode search(BSTNode root, Dollar key)
    {
        // if tree is empty or the root has the key
        if(root == null || root.getData().isEqual(key))
        {
            return root;
        }
        if(root.getData().isGreater(key))
        {
            return search(root.getRightChild(), key);
        }

        return search(root.getLeftChild(), key);
    }

    public BSTNode insert(BSTNode root, Dollar key)
    {
 

        if (root == null)
        {
            root = new BSTNode(key);
            return root;
        }

        if (root.getData().isGreater(key))
        {
            root.setLeftChild(insert(root.getLeftChild(), key));
        }
        else if (key.isGreater(root.getData()))
        {
            root.setRightChild(insert(root.getRightChild(), key));
        }

        return root;
    }

    public void insert(Dollar key)
    {
        root = insert(root, key);
    }

    public boolean isEmpty()
    {
        return this.getRoot() == null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }
}
