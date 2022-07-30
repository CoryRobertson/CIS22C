/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 4
 Statement of Lab: To demonstrate the functionality of Binary Search Trees using the 4 traversal methods
 */
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


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

        System.out.println("Printed below are the 4 traversal methods");
        log("Printed below are the 4 traversal methods");

        System.out.println("\nBreadth First:");
        log("\nBreadth First:");

        tree.printLevelOrder(true);

        System.out.println("\nIn order:");
        log("\nIn order:");

        tree.printInOrder(tree.getRoot(), true);

        System.out.println("\nPre order:");
        log("\nPre order:");

        tree.printPreorder(tree.getRoot(), true);

        System.out.println("\nPost order:");
        log("\nPost order:");

        tree.printPostorder(tree.getRoot(), true);

        int value = -1;




        while (value != 0)
        {
            System.out.println("Menu options:");
            System.out.println("""
                    1. Search for value
                    2. Insert value
                    3. Delete value
                    0. Quit program""");
            System.out.println("Enter your choice(0-3):");
            value = input.nextInt();
            if (value == 1) {
                System.out.println("Enter currency value to search: ");
                double search = input.nextDouble();
                if(search > 0)
                {
                    Dollar searchDollar = new Dollar(search);
                    BSTNode found = tree.search(tree.getRoot(), searchDollar);

                    if (found == null) {
                        System.out.println("Unable to find searched currency.");
                    }
                    else
                    {
                        System.out.println("Found currency: " + searchDollar.toString());
                    }
                }
                else
                {
                    System.out.println("Invaid input");
                }

            } else if (value == 2) {
                System.out.println("Enter currency value to insert: ");
                double insert = input.nextDouble();
                if(insert > 0)
                {
                    Dollar insertDollar = new Dollar(insert);
                    tree.insert(insertDollar);
                }
                else
                {

                    //log("Cannot insert invalid currency");
                    System.out.println("Cannot insert invalid currency");
                }


            } else if (value == 3) {
                System.out.println("Enter currency value to delete: ");
                //log("Enter currency value to delete: ");
                double delete = input.nextDouble();
                if(delete > 0)
                {
                    Dollar deleteDollar = new Dollar(delete);
                    tree.delete(tree.getRoot(), deleteDollar);
                    System.out.println("Currency deleted");
                    //log("Currency deleted");
                }
                else
                {
                    System.out.println("Cannot delete invalid currency");
                    //log("Cannot delete invalid currency")
                }


            }

        }
        System.out.println("Would you like to log the output of the tree to a file(y/n)?");
        String inpt = input.next();
        if(inpt.equalsIgnoreCase("y"))
        {
            log("Here are the four updated traversal methods.");

            log("\nBreadth First:");

            tree.printLevelOrder(true);

            log("\nIn order:");

            tree.printInOrder(tree.getRoot(), true);

            log("\nPre order:");

            tree.printPreorder(tree.getRoot(), true);

            log("\nPost order:");

            tree.printPostorder(tree.getRoot(), true);
        }
        System.out.print("Goodbye");

    }

    public static boolean log(String s) {

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
