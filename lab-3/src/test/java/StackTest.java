import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTest
{

    @Test
    void push()
    {
        Stack stack = new Stack();
        stack.push(new Dollar(1.2));
        stack.push(new Dollar(1.8));
        Assertions.assertEquals(1.8,stack.peek().toDouble());
        stack.printStack();
    }

    @Test
    void constructorTests()
    {
        Stack stack = new Stack();
        Stack stack2 = new Stack(null, null, 0);

        Dollar[] dollars = {new Dollar(1.2), new Dollar(4.9), new Dollar(7.99)};

        Stack stack3 = new Stack(dollars);

        Assertions.assertNull(stack.getStart());
        Assertions.assertNull(stack.getEnd());
        Assertions.assertNull(stack2.getStart());
        Assertions.assertNull(stack2.getEnd());

        double a = stack3.pop().toDouble();
        double b = stack3.pop().toDouble();
        double c = stack3.pop().toDouble();

        Assertions.assertEquals(7.99,a);
        Assertions.assertEquals(4.9,b);
        Assertions.assertEquals(1.2,c);

    }

    @Test
    void peek()
    {
        Stack stack = new Stack();
        stack.push(new Dollar(1.2));
        stack.push(new Dollar(4.2));
        stack.push(new Dollar(1994.2));
        stack.push(new Dollar(7.01));
        Assertions.assertEquals(7.01,stack.peek().toDouble());
    }

    @Test
    void pop()
    {
        Stack stack = new Stack();
        stack.push(new Dollar(3.14));
        stack.push(new Dollar(0.25));
        stack.push(new Dollar(1001.00));
        stack.push(new Dollar(971.01));
        Dollar dol = (Dollar) stack.pop();
        Assertions.assertTrue(dol.isEqual(new Dollar(971.01)));
    }

    @Test
    void printStack()
    {
        Stack stack = new Stack();
        stack.push(new Dollar(3.14));
        stack.push(new Dollar(5.00));
        stack.push(new Dollar(7));
        stack.printStack();
    }

    @Test
    void addCurrency()
    {
        Stack stack = new Stack();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.addCurrency(new Dollar(0.1)));
    }

    @Test
    void testAddCurrency()
    {
        Stack stack = new Stack();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.addCurrency(new Dollar(0.1),0));
    }

    @Test
    void removeCurrency()
    {
        Stack stack = new Stack();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.removeCurrency(0));
    }

    @Test
    void testRemoveCurrency()
    {
        Stack stack = new Stack();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.removeCurrency(new Dollar(0.1)));
    }

    @Test
    void printList()
    {
        Stack stack = new Stack();
        Assertions.assertThrows(UnsupportedOperationException.class, stack::printList);
    }
}