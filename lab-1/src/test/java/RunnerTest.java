import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void isArrayPrimeIter()
    {
        // 567 is the non-prime number
        final int[] testNumsFirst = {53, 5099, 1223, 567, 17};
        // these are all prime
        final int[] testNumsSecond = {1871, 8069, 3581, 6841};

        assertFalse(Runner.isArrayPrimeIter(testNumsFirst, testNumsFirst.length));
        assertTrue(Runner.isArrayPrimeIter(testNumsSecond, testNumsSecond.length));
    }

    @Test
    void isArrayPrimeRecur() {
        // primes
        Assertions.assertTrue(Runner.isPrimeRecur(109, 3));
        Assertions.assertTrue(Runner.isPrimeRecur(131, 3));
        Assertions.assertTrue(Runner.isPrimeRecur(163, 3));
        Assertions.assertTrue(Runner.isPrimeRecur(191, 3));
        Assertions.assertTrue(Runner.isPrimeRecur(997, 3));
        Assertions.assertTrue(Runner.isPrimeRecur(971, 3));

        // not primes
        Assertions.assertFalse(Runner.isPrimeRecur(908, 3));
        Assertions.assertFalse(Runner.isPrimeRecur(20, 3));
        Assertions.assertFalse(Runner.isPrimeRecur(999, 3));
    }

    @Test
    void isPrimeRecur()
    {
        Assertions.assertTrue(true);
    }
}