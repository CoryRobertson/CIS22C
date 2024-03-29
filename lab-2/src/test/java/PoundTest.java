import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PoundTest
{

    @Test
    void subtract()
    {
        Currency poundSubTest = new Pound(10.5);
        poundSubTest.subtract(new Pound(0.5));

        Assertions.assertTrue(poundSubTest.isEqual(new Pound(10)));
    }

    @Test
    void isGreaterDollarTest()
    {
        Pound d1 = new Pound(1.01);
        Pound d2 = new Pound(1.02);
        Assertions.assertTrue(d2.isGreater(d1));
    }

    @Test
    void invalidDollarObject()
    {
        assertThrows(IllegalArgumentException.class, () -> new Pound(-1.5));
        assertThrows(IllegalArgumentException.class, () -> new Pound(new Pound(-0.1)));
    }

    @Test
    void subtractInvalidType()
    {
        Currency poundSubTest = new Pound(10.5);
        assertThrows(IllegalArgumentException.class, () -> poundSubTest.subtract(new Dollar(1.0)));
    }

    @Test
    void add()
    {
        Currency poundAddTest = new Pound(1.5);
        poundAddTest.add(new Pound(1.5));

        Assertions.assertTrue(poundAddTest.isEqual(new Pound(3)));
    }

    @Test
    void addInvalidType()
    {
        Currency poundSubTest = new Pound(10.5);
        assertThrows(IllegalArgumentException.class, () -> poundSubTest.add(new Dollar(1.0)));
    }

    @Test
    void toDoubleDollar()
    {
        double initAmount = 5.98;
        double addAmount = 1.23;
        Pound pound = new Pound(initAmount);
        pound.add(new Pound(addAmount));
        Assertions.assertEquals(pound.toDouble(), initAmount + addAmount, 0.000001);
    }

    @Test
    void comparisonTest()
    {
        Dollar dollar = new Dollar(9.46);
        Pound pound = new Pound(15.79);
        Assertions.assertThrows(IllegalArgumentException.class,() -> pound.isGreater(dollar));
        Assertions.assertThrows(IllegalArgumentException.class, () -> pound.isEqual(dollar));
    }
}