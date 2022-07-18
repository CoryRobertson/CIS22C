import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void addCurrency() {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        list.addCurrency(new Dollar(3.14), 1);
        // 2.5, 3.14, 1.1, 1.0
        Assertions.assertTrue(list.getNodeAtIndex(1).getData().isEqual(new Dollar(3.14)));

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.push(new Dollar(1.0));
        list2.push(new Dollar(1.1));
        list2.push(new Dollar(2.5));
        list2.addCurrency(new Dollar(3.14), 1);
        // 2.5, 3.14, 1.1, 1.0
        list2.addCurrency(new Dollar(4.96), 2);
        // 2.5, 3.14, 4.96, 1.1, 1.0
        Assertions.assertTrue(list2.getNodeAtIndex(2).getData().isEqual(new Dollar(4.96)));

    }

    @Test
    void getCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));

        Assertions.assertTrue(list.getCurrency(1).isEqual(new Dollar(1.1)));
    }

    @Test
    void printList()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        list.printList();
    }

    @Test
    void isListEmpty()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        SinglyLinkedList list2 = new SinglyLinkedList(null, null, 0);
        assertFalse(list.isListEmpty());
        Assertions.assertTrue(list2.isListEmpty());
    }

    @Test
    void push()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        assertEquals(3, list.getCount());
    }

    @Test
    void getNodeAtIndex()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        // 2.5, 1.1, 1.0
        list.getNodeAtIndex(1);
        Assertions.assertTrue(list.getNodeAtIndex(1).getData().isEqual(new Dollar(1.1)));
    }

    @Test
    void findCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.push(new Dollar(1.0));
        list.push(new Dollar(1.1));
        list.push(new Dollar(2.5));
        int a  = list.findCurrency(new Dollar(1.1));
        int b = list.findCurrency(new Dollar(78.94));
        Assertions.assertEquals(1,a);
        Assertions.assertEquals(-1,b);
    }
}