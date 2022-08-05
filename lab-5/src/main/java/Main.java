import java.util.Scanner;

/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 5
 Statement of Lab: To demonstrate usage of hash tables with currency
 */
class Main {
    public static void main(String[] args)
    {
        

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

        HashTable table = new HashTable(29);

        for(Currency cur : currencies)
        {
            table.put( (Dollar) cur);
        }

        System.out.println("Number of dollar objects loaded: " + table.getCount());
        System.out.println("Load factor: " + table.loadFactor());
        System.out.println("Number of collisions: " + table.getCollisions());

        Scanner in = new Scanner(System.in);
        int input = -1;

        while(input != 2)
        {
            System.out.println("""
                    1) search
                    2) exit
                    """);
            input = in.nextInt();

            if(input == 1)
            {
                System.out.println("Enter dollar amount to search for: ");
                double value = in.nextDouble();
                Dollar dollar = new Dollar(value);
                Dollar foundDollar = table.get(dollar);
                if(foundDollar != null)
                {
                    System.out.println("Found dollar in hash table: " + foundDollar.toString());
                }
                else
                {
                    System.out.println("Invalid data");
                }
            }
        }

    }
}