import java.util.Scanner;

/**
 Authors:
 Cory Robertson
 Narann Nathan
 **/
class Runner {

    public static void main(String[] args)
    {
        // 567 is the non prime number
        //final int[] testNumsFirst = {53, 5099, 1223, 567, 17};
        // these are all prime
        //final int[] testNumsSecond = {1871, 8069, 3581, 6841};

        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array (max = 16): ");
        int len = Integer.parseInt(input.nextLine());
        int[] array = new int[len];
        System.out.println("Enter the array of numbers (range 1 - 9999):");

        for(int i = 0; i < array.length; i++)
        {
            int nums = input.nextInt();
            array[i] = nums;

            // System.out.print(array[i]);
        }

        boolean isPrimeIter = isArrayPrimeIter(array, array.length);
        boolean isPrimeRecur = isArrayPrimeRecur(array, array.length);

        if (isPrimeIter)
        {
            System.out.println("Prime Array using iteration");
        }
        else
        {
            System.out.println("Not a Prime Array using iteration");
        }

        if (isPrimeRecur)
        {
            System.out.println("Prime Array using recursion");
        } else
        {
            System.out.println("Not a Prime Array using recursion");
        }

        // prompt user for input size of array

        // initialize user input array with size from their input

        // prompt user using for loop for each slot in array

        // call prime iter array check and print out if it is or not prime

        // call prime recursive check and print out if it is or not prime

        //
        // System.out.println(isArrayPrimeRecur(testNumsFirst, testNumsFirst.length));
        // System.out.println(isArrayPrimeRecur(testNumsSecond, testNumsSecond.length));


        // System.out.println(isArrayPrimeIter(testNumsFirst, testNumsFirst.length));
        // System.out.println(isArrayPrimeIter(testNumsSecond, testNumsSecond.length));
    }

    /**
     pre: an integer array full of numbers, and a length of the array to go through, all numbers in the array must be actual numbers, and not null
     post: returns true if and only if the entire array was prime, if even one was not prime, then false is returned instead.
     **/
    public static boolean isArrayPrimeIter(int[] arr, int len)
    {
        System.out.println("Entering isArrayPrimeIter");
        for(int i = 0; i < len; i++)
        {
            int num = arr[i];

            if (num < 2) // check for one or lower
            {
                System.out.println("Leaving isArrayPrimeRecur");
                return false;
            }
            // check for num being less than 3, lets us skip first few, these are also good for exception cases!
            if (num == 2 || num == 3)
            {
                continue; // skip execution of the loop if we encounter these numbers :)
            }

            // even number check, lets us cut out a large amount of numbers
            if (num % 2 == 0 || num % 3 == 0)
            {
                System.out.println("Leaving isArrayPrimeRecur");
                return false;
            }

            // professor email showed us this cool square root trick, never thought of it!
            int squareNum = (int)Math.sqrt(num) + 1;
            // we go all the way to square root + 1 in this case
            for(int j = 6 ; j <= squareNum ; j+= 6)
            {
                if (num % (j - 1) == 0 || num % (j + 1) == 0)
                {
                    System.out.println("Leaving isArrayPrimeRecur");
                    return false;
                }
            }

        }

        System.out.println("Leaving isArrayPrimeRecur");
        return true;
    }

    /**
     pre: \o/
     post: \o/
     **/
    public static boolean isArrayPrimeRecur(int[] arr, int len)
    {
        // we probably want to use len as an index, and just count downwards from len to 0!
        if(len == 0)
        {
            System.out.println("Leaving isArrayPrimeRecur");
            return true;
        }

        if(isPrimeRecur(arr[len - 1], 3))
        {
            return isArrayPrimeRecur(arr, len - 1);
        }

        System.out.println("Leaving isArrayPrimeRecur");
        return false;
    }

    /**
     pre: \o/
     post: \o/
     **/
    // public static boolean isPrime(int num)
    // {
    //   if (num < 2) // check for one or lower
    //   {
    //     return false;
    //   }
    //   // check for num being less than 3, lets us skip first few, these are also good for exception cases!
    //   if (num == 2 || num == 3)
    //   {
    //     return true;
    //   }

    //   // even number check, lets us cut out a large amount of numbers
    //   if (num % 2 == 0 || num % 3 == 0)
    //   {
    //     return false;
    //   }

    //   // professor email showed us this cool square root trick, never thought of it!
    //   int squareNum = (int)Math.sqrt(num) + 1;
    //   // we go all the way to square root + 1 in this case
    //   for(int i = 6 ; i <= squareNum ; i+= 6)
    //   {
    //     if (num % (i - 1) == 0 || num % (i + 1) == 0)
    //     {
    //       return false;
    //     }
    //   }
    //   return true;
    // }

    /**
     pre: a number, and a divisor, the divisor should start with 3 always
     post: returns true if and only if the given number is prime
     **/
    public static boolean isPrimeRecur(int num, int i)
    {
        System.out.println("Entering isPrimeRecur");

        // one check
        if (num < 2)
        {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }

        // even number check
        if (num % 2 == 0)
        {
            if (num == 2) // even but its two
            {
                System.out.println("Leaving isPrimeRecur");
                return true;
            }
            System.out.println("Leaving isPrimeRecur");
            return false;
        }

        // if the divisor is larger than the number when squared the number is prime
        if (i * i > num)
        {
            System.out.println("Leaving isPrimeRecur");
            return true;
        }

        // divison check for primality
        if (num % i == 0)
        {
            System.out.println("Leaving isPrimeRecur");
            return false;
        }

        return isPrimeRecur(num, i + 2); // we add two cause we can skip evens

    }
}