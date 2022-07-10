import java.util.Scanner;

/**
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 2
 Statement of Lab: To demonstrate usage of polymorphism, inheritance, and class design to simulate currency
 **/
public class Lab2main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Currency[] currencies = new Currency[2];

        currencies[0] = new Pound(0);
        currencies[1] = new Dollar(0);

        System.out.println(" ");

        String input = "";

        while (!input.equalsIgnoreCase("q"))
        {
            System.out.println(currencies[0]);
            System.out.println(currencies[1]);

            System.out.println("1) Type (a) to Add or (s) to Subtract");
            System.out.println("2) Type (q) to Quit?");
            System.out.print("Your input ?: ");
            input = in.nextLine();

            if(input.equalsIgnoreCase("a"))
            {
                System.out.print("1) Pound(p) or Dollar(d)?");
                input = in.nextLine();
                if (input.equalsIgnoreCase("p")) {
                    System.out.print("Enter value to add: ");
                    input = in.nextLine();
                    System.out.print("Enter currency type: ");
                    String type = in.nextLine();
                    if (type.equalsIgnoreCase("Pound")) {
                        double value = Double.parseDouble(input);
                        currencies[0].add(new Pound(value));
                    } else {
                        System.out.println("Invalid addition\n");
                    }

                } else if (input.equalsIgnoreCase("d"))
                {

                    System.out.print("Enter value to add: ");
                    input = in.nextLine();
                    System.out.print("Enter type: ");
                    String type = in.nextLine();
                    if (type.equalsIgnoreCase("Dollar")) {
                        double value = Double.parseDouble(input);
                        currencies[1].add(new Dollar(value));
                    } else {
                        System.out.println("Invalid addition\n");
                    }

                    // continue;
                }
            }

            if(input.equals("s"))
            {
                System.out.print("1) Pound(p) or Dollar(d)?");
                input = in.nextLine();
                if(input.equalsIgnoreCase("p"))
                {
                    System.out.print("Enter value to subtract: ");
                    input = in.nextLine();
                    System.out.print("Enter type: ");
                    String type = in.nextLine();
                    if(type.equalsIgnoreCase("pound"))
                    {
                        double value = Double.parseDouble(input);
                        currencies[0].subtract(new Pound(value));
                    }
                    else
                    {
                        System.out.println("Invalid subtraction");
                    }
                }
                else if(input.equalsIgnoreCase("d"))
                {
                    System.out.print("Enter value to subtract: ");
                    input = in.nextLine();
                    System.out.print("Enter type: ");
                    String type = in.nextLine();
                    if(type.equalsIgnoreCase("dollar"))
                    {
                        double value = Double.parseDouble(input);
                        try
                        {
                            currencies[1].subtract(new Dollar(value));
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("Invalid subtraction");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid subtraction");
                    }
                }
                // continue;
            }


        }
        in.close();

    }
}