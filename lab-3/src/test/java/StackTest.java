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
}