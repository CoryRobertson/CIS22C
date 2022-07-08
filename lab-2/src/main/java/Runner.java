import java.util.Scanner;

public class Runner
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Currency[] currencies = new Currency[2];

        currencies[0] = new Pound(0);
        currencies[1] = new Dollar(5);

        System.out.println(" ");

        String input = "";

        while (!input.equalsIgnoreCase("q"))
        {
            System.out.println(currencies[0]);
            System.out.println(currencies[1]);

            System.out.println("1) Add(a) or Subtact(s)?");
            System.out.println("2) Quit?");
            input = in.nextLine();

            if(input.equalsIgnoreCase("a"))
            {
                System.out.print("1) Pound(p) or Dollar(d)?");
                input = in.nextLine();
                if(input.equalsIgnoreCase("p"))
                {
                    System.out.print("Enter value to add: ");
                    input = in.nextLine();
                    System.out.print("Enter currency type: ");
                    input = in.nextLine();
//                    if()
//                        double value = Double.parseDouble(input);
//                    currencies[0].add(new Pound(value));

                }else if(input.equalsIgnoreCase("d"))

                    System.out.print("Enter value to add: ");
                input = in.nextLine();
                double value = Double.parseDouble(input);
                currencies[0].add(new Dollar(value));
                {

                }

                // continue;
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
                        currencies[1].subtract(new Dollar(value));
                    }
                    else
                    {
                        System.out.println("Invalid subtraction");
                    }
                }
                // continue;
            }


        }

    }
}