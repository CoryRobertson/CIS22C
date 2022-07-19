import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void enqueue()
    {
        Queue queue = new Queue();
        queue.enqueue(new Dollar(1.0));
        queue.enqueue(new Dollar(1.4));
        queue.enqueue(new Dollar(3.42));
//        queue.printQueue();
        double a = queue.peekFront().toDouble();
        double b = queue.peekRear().toDouble();
        Assertions.assertEquals(1.0,a);
        Assertions.assertEquals(3.42,b);
    }

    @Test
    void dequeue()
    {
        Queue queue = new Queue();
        queue.enqueue(new Dollar(1.0));
        queue.enqueue(new Dollar(1.4));
        queue.enqueue(new Dollar(3.42));
        double a = queue.dequeue().toDouble();
        Assertions.assertEquals(1.0, a);
    }

    @Test
    void constructorTests()
    {
        Dollar[] dollars = {new Dollar(1.2), new Dollar(4.9), new Dollar(7.99)};
        Queue queue = new Queue(dollars);
//        queue.printQueue();

        Queue queue1 = new Queue(null, null, 0);
        queue1.enqueue(new Dollar(1.24));
    }

    @Test
    void printQueue()
    {
        Queue queue = new Queue();
        queue.enqueue(new Dollar(1.0));
        queue.enqueue(new Dollar(1.4));
        queue.enqueue(new Dollar(3.42));
        queue.printQueue();
    }

    @Test
    void addCurrency()
    {
        Queue queue = new Queue();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.addCurrency(new Dollar(1.0)));
    }

    @Test
    void testAddCurrency()
    {
        Queue queue = new Queue();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.addCurrency(new Dollar(1.0),0));
    }

    @Test
    void removeCurrency()
    {
        Queue queue = new Queue();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.removeCurrency(new Dollar(1.0)));
    }

    @Test
    void testRemoveCurrency()
    {
        Queue queue = new Queue();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.removeCurrency(0));
    }

    @Test
    void printList()
    {
        Queue queue = new Queue();
        Assertions.assertThrows(UnsupportedOperationException.class, queue::printList);
    }


}