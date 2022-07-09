import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void subtract()
    {
        Currency dollarSubTest = new Dollar(1.5);
        dollarSubTest.subtract(new Dollar(0.15));
        Assertions.assertTrue(dollarSubTest.isEqual(new Dollar(1.35)));
    }

    @Test
    void isGreaterDollarTest()
    {
        Dollar d1 = new Dollar(1.01);
        Dollar d2 = new Dollar(1.02);
        Assertions.assertTrue(d2.isGreater(d1));
    }

    @Test
    void invalidDollarObject()
    {
        assertThrows(NumberFormatException.class, () -> new Dollar(-1.5));
        assertThrows(NumberFormatException.class, () -> new Dollar(new Dollar(-0.1)));
    }

    @Test
    void subtractInvalidType()
    {
        Currency dollarSubTest = new Dollar(10.5);
        assertThrows(InvalidParameterException.class, () -> dollarSubTest.subtract(new Pound(1.0)));
    }

    @Test
    void add()
    {
        Currency dollarSubTest = new Dollar(199.5);
        dollarSubTest.add(new Dollar(1.25));
        Assertions.assertTrue(dollarSubTest.isEqual(new Dollar(200.75)));
    }

    @Test
    void addInvalidType()
    {
        Currency dollarSubTest = new Dollar(10.5);
        assertThrows(InvalidParameterException.class, () -> dollarSubTest.add(new Pound(1.0)));
    }

    @Test
    void toDoubleDollar()
    {
        double initAmount = 5.90;
        double addAmount = 1.20;
        Dollar dollar = new Dollar(initAmount);
        dollar.add(new Dollar(addAmount));
        Assertions.assertEquals(dollar.toDouble(), initAmount + addAmount, 0.000001);
    }
}