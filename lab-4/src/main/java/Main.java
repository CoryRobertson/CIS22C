import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // tree.setRoot(new BSTNode(new Dollar(1.0)));
        // tree.getRoot().setLeftChild(new BSTNode(new Dollar(2.0)));
        // tree.getRoot().setRightChild(new BSTNode(new Dollar(3.0)));
        // tree.getRoot().getLeftChild().setLeftChild(new BSTNode(new Dollar(4.0)));
        // tree.getRoot().getLeftChild().setRightChild(new BSTNode(new Dollar(5.0)));

        // tree.printPostorder(tree.getRoot());
        // tree.printPreorder(tree.getRoot());
        // tree.printInOrder(tree.getRoot());
        // System.out.println(tree.getHeight(tree.getRoot()));
        // tree.levelOrderTraversal(tree.getRoot());
        // tree.printLevelOrder();

        System.out.println("Welcome to our fourth lab. This lab was written by "
                + "Naran Nathan and Cory Robertson");

        Currency[] currencies = new Currency[20];
        currencies[0] = new Dollar(57.12);
        currencies[1] = new Dollar(23.44);
        currencies[2] = new Dollar(87.43);
        currencies[3] = new Dollar(68.99);
        currencies[4] = new Dollar(111.22);
        currencies[5] = new Dollar(44.55);
        currencies[6] = new Dollar(77.77);
        currencies[7] = new Dollar(18.36);
        currencies[8] = new Dollar(543.21);
        currencies[9] = new Dollar(20.21);
        currencies[10] = new Dollar(345.67);
        currencies[11] = new Dollar(36.18);
        currencies[12] = new Dollar(48.48);
        currencies[13] = new Dollar(101.00);
        currencies[14] = new Dollar(11.00);
        currencies[15] = new Dollar(21.00);
        currencies[16] = new Dollar(51.00);
        currencies[17] = new Dollar(1.00);
        currencies[18] = new Dollar(251.00);
        currencies[19] = new Dollar(151.00);

        BST tree = new BST(currencies);

        // BST tree = new BST();
        Scanner input = new Scanner(System.in);

        System.out.print("Printed below are the 4 traversal methods");
        //tree.

               // System.out.print("Menu options:");
        System.out.print("1. Search for value\n"
                + "2. Insert value\n"
                + "3. Delete value");
        System.out.print("Enter your choice(1-3)");
        int value = input.nextInt();

        if (value == 1) {
            System.out.print("Enter currency value to search: ");
            double search = input.nextDouble();
            //tree.search(null, search);

        } else if (value == 2) {
            System.out.print("Enter currency value to insert: ");
            //Dollar insert = input.nextDouble();
            //tree.insert(insert);

        }

    }

    public static boolean log(String s)
    {

        FileWriter fw;
        BufferedWriter bw;
        PrintWriter out;

        try {
            fw = new FileWriter("log.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(s);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
