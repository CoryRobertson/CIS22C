
/**
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 1
 Statement of Lab: To demonstrate the usage of iterative and recursive functions by checking if a number is a prime.
 **/
import java.util.Scanner;

class Runner
{

    public static void main(String[] args)
    {

        // begin input for user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array (max = 16 size): ");
        int len = Integer.parseInt(input.nextLine()); // prompt user for size of array
        int[] array = new int[len]; // initialize array with size from user prompt
        System.out.println("Enter the array of numbers (range 1 - 9999):");

        for(int i = 0 ; i < array.length ; i++)
        {
            int nums = input.nextInt(); // this line breaks each space separated value into the nums variable
            array[i] = nums;
        }

        input.close(); // close scanner input

        boolean isPrimeIter = isArrayPrimeIter(array, array.length); // boolean check for is prime iter
        boolean isPrimeRecur = isArrayPrimeRecur(array, array.length); // boolean check for is prime recur

        if (isPrimeIter) // if statement for checking for prime array iter
        {
            System.out.println("Prime Array using iteration");
        }
        else
        {
            System.out.println("Not a Prime Array using iteration");
        }

        if (isPrimeRecur) // if statement for checking for prime array recur
        {
            System.out.println("Prime Array using recursion");
        }
        else
        {
            System.out.println("Not a Prime Array using recursion");
        }
    }

    /**
     pre: an integer array full of numbers, and a length of the array to go through, all numbers in the array must be actual numbers, and not null
     post: returns true if and only if the entire array was prime, if even one was not prime, then false is returned instead.

     Pseudocode for isArrayPrimeIter
     1) Print enter primeIter
     2) loop(i equals 0 and i less than length)
     3) 	num = arr[i]
     4) 	if(num less than 2)
     5) 		return false and print Leaving array
     6)	if( num equals 2 or 3)
     7)	continue loop
     8)  end if
     9) 	if(num divisible by 2 or 3)
     10) 		return false and print leave array
     11) end if
     12) int squareroot equals the squareroot of num plus 1
     13) 	loop(j = 6 and less than squareroot)
     14) 		if(num divisible by j-1 or j+1)
     15)				return false and print leaving array
     16)					end if
     17) end loop
     **/
    public static boolean isArrayPrimeIter(int[] arr, int len)
    {
        System.out.println("Entering isArrayPrimeIter");
        for(int i = 0; i < len; i++)
        {
            int num = arr[i];

            if (num < 2) // check for one or lower
            {
                System.out.println("Leaving isArrayPrimeIter \n");
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
                System.out.println("Leaving isArrayPrimeIter \n");
                return false;
            }

            // professor email showed us this cool square root trick, never thought of it!
            int squareNum = (int)Math.sqrt(num) + 1;
            // we go all the way to square root + 1 in this case
            for(int j = 6 ; j <= squareNum ; j+= 6)
            {
                if (num % (j - 1) == 0 || num % (j + 1) == 0)
                {
                    System.out.println("Leaving isArrayPrimeIter \n");
                    return false;
                }
            }
        }
        System.out.println("Leaving isArrayPrimeIter \n");
        return true;
    }


    /**
     pre: an integer array with the user inputted        numbers and the length of array
     post: returns true if the number is a prime,       else return false
     Pseudocode for isArrayPrimeRecur:
     1) if(length of array equals 0)
     2) 		return true and print out Leaving array
     3) end if
     4) if(isPrimeRecur has array of length - 1 and        length from the array set)
     5) return isArrayPrimeRecur(of the integer array      and the divisor of 3)
     6) end if
     7) return false and print leaving                     isArrayPrimeRecur
     **/
    public static boolean isArrayPrimeRecur(int[] arr, int len)
    {
        // we probably want to use len as an index, and just count downwards from len to 0!
        if(len == 0)
        {
            System.out.println("Leaving isArrayPrimeRecur \n");
            return true;
        }

        if(isPrimeRecur(arr[len - 1], 3))
        {
            return isArrayPrimeRecur(arr, len - 1);
        }

        System.out.println("Leaving isArrayPrimeRecur \n");
        return false;
    }

    /**
     pre: a number, and a divisor, the divisor should start with 3 always
     post: returns true if and only if the given number is prime
     Pseudocode for isPrimeRecur:
     1) prints entering isPrimeRecur
     2) if ( number is less than 2)
     3) leaves isPrimeRecur
     4) returns false
     5) end if
     6) if (number is even)
     7) 	if(number equals 2)
     8)		prints leaving isPrimeRecur
     9) 	returns true because 2 is prime
     10) prints leaving isPrimeRecur
     11) returns false as it's even number
     12) end if
     13) if( squared divisor is larger than number)
     14) 	prints return true
     15) if(number is divisible by the divisor)
     16)		prints return false
     17) returns isPrimeRecur with number and divisor added 2
     because we skip even numbers.
     **/
    public static boolean isPrimeRecur(int num, int i)
    {
        System.out.println("Entering isPrimeRecur");

        // one check
        if (num < 2)
        {
            System.out.println("Leaving isPrimeRecur \n");
            return false;
        }

        // even number check
        if (num % 2 == 0)
        {
            if (num == 2) // num is even but its two, which is prime
            {
                System.out.println("Leaving isPrimeRecur \n");
                return true;
            }
            System.out.println("Leaving isPrimeRecur \n");
            return false;
        }

        // if the divisor is larger than the number when squared the number is prime
        if (i * i > num)
        {
            System.out.println("Leaving isPrimeRecur \n");
            return true;
        }

        // divison check for primality
        if (num % i == 0)
        {
            System.out.println("Leaving isPrimeRecur \n");
            return false;
        }

        return isPrimeRecur(num, i + 2); // we add two cause we can skip evens
    }
}