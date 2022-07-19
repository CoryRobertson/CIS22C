import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void addCurrency() {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.addCurrency(new Dollar(2.5), 0);
        list.addCurrency(new Dollar(3.14), 1);
        list.addCurrency(new Dollar(1.1), 2);
        list.addCurrency(new Dollar(1.0), 3);
        // 2.5, 3.14, 1.1, 1.0
        Assertions.assertTrue(list.getNodeAtIndex(1).getData().isEqual(new Dollar(3.14)));

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addCurrency(new Dollar(2.5), 0);
        list2.addCurrency(new Dollar(3.14), 1);
        list2.addCurrency(new Dollar(1.1), 2);
        list2.addCurrency(new Dollar(1.0), 3);

        // 2.5, 3.14, 1.1, 1.0
        list2.addCurrency(new Dollar(4.96), 2);
        // 2.5, 3.14, 4.96, 1.1, 1.0
        Assertions.assertTrue(list2.getNodeAtIndex(2).getData().isEqual(new Dollar(4.96)));
        Assertions.assertEquals(4,list.getCount());
        Assertions.assertEquals(5,list2.getCount());
        Assertions.assertEquals(1.0, list2.getEnd().getData().toDouble());
        Assertions.assertEquals(1.0, list.getEnd().getData().toDouble());
        Assertions.assertEquals(2.5, list.getStart().getData().toDouble());
        Assertions.assertEquals(2.5, list2.getStart().getData().toDouble());

    }

    @Test
    void getCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.addCurrency(new Dollar(2.5), 0);
        list.addCurrency(new Dollar(1.1), 1);
        list.addCurrency(new Dollar(1.0), 2);

        Assertions.assertTrue(list.getCurrency(1).isEqual(new Dollar(1.1)));
        Assertions.assertEquals(3,list.getCount());
    }

    @Test
    void printList()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.printList();
        Assertions.assertEquals(0,list.getCount());
        SinglyLinkedList list2 = new SinglyLinkedList(null, null, 0);
        list2.addCurrency(new Dollar(2.5), 0);
        list2.addCurrency(new Dollar(1.1), 1);
        list2.addCurrency(new Dollar(1.0), 2);
        list2.printList();
    }

    @Test
    void isListEmpty()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.addCurrency(new Dollar(2.5), 0);
        list.addCurrency(new Dollar(1.1), 1);
        list.addCurrency(new Dollar(1.0), 2);
        SinglyLinkedList list2 = new SinglyLinkedList(null, null, 0);
        assertFalse(list.isListEmpty());
        Assertions.assertTrue(list2.isListEmpty());
        Assertions.assertEquals(3,list.getCount());
    }

    @Test
    void getNodeAtIndex()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.addCurrency(new Dollar(2.5), 0);
        list.addCurrency(new Dollar(1.1), 1);
        list.addCurrency(new Dollar(1.0), 2);
        // 2.5, 1.1, 1.0
        list.getNodeAtIndex(1);
        Assertions.assertTrue(list.getNodeAtIndex(1).getData().isEqual(new Dollar(1.1)));
        Assertions.assertEquals(3,list.getCount());
        Assertions.assertEquals(1.0, list.getEnd().getData().toDouble());
    }

    @Test
    void findCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList(null, null, 0);
        list.addCurrency(new Dollar(2.5), 0);
        list.addCurrency(new Dollar(1.1), 1);
        list.addCurrency(new Dollar(1.0), 2);
        int a  = list.findCurrency(new Dollar(1.1));
        int b = list.findCurrency(new Dollar(78.94));
        Assertions.assertEquals(1,a);
        Assertions.assertEquals(-1,b);
        Assertions.assertEquals(3,list.getCount());
        Assertions.assertEquals(1.0, list.getEnd().getData().toDouble());
    }

    @Test
    void testAddCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addCurrency(new Dollar(2.5));
        list.addCurrency(new Dollar(1.1));
        list.addCurrency(new Dollar(1.0));
        //2.5, 1.1, 1.0
        double a = list.getNodeAtIndex(0).getData().toDouble();
        double b = list.getNodeAtIndex(1).getData().toDouble();
        double c = list.getNodeAtIndex(2).getData().toDouble();
        Assertions.assertEquals(2.5,a);
        Assertions.assertEquals(1.1,b);
        Assertions.assertEquals(1.0,c);
        Assertions.assertEquals(3,list.getCount());
        Assertions.assertEquals(1.0, list.getEnd().getData().toDouble());
    }

    @Test
    void getEnd()
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addCurrency(new Dollar(2.5));
        list.addCurrency(new Dollar(1.1));
        list.addCurrency(new Dollar(1.0));
        Assertions.assertTrue(list.getEnd().getData().isEqual(new Dollar(1.0)));
        Assertions.assertEquals(3,list.getCount());

    }

    @Test
    void removeCurrencyObject()
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addCurrency(new Dollar(2.5));
        list.addCurrency(new Dollar(3.49));
        list.addCurrency(new Dollar(1.1));
        list.addCurrency(new Dollar(7.24));
        list.addCurrency(new Dollar(1.0));

        list.removeCurrency(new Dollar(1.1));

        list.printList();



        Assertions.assertTrue(list.getCurrency(0).isEqual(new Dollar(2.5)));
        Assertions.assertTrue(list.getCurrency(1).isEqual(new Dollar(3.49)));
        Assertions.assertTrue(list.getCurrency(2).isEqual(new Dollar(7.24)));
        Assertions.assertTrue(list.getCurrency(3).isEqual(new Dollar(1.0)));
        double a = list.getEnd().getData().toDouble();
        Assertions.assertEquals(1.0,a);

        Assertions.assertEquals(4,list.getCount());

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addCurrency(new Dollar(3.49));
        list3.addCurrency(new Dollar(7.93));
        list3.addCurrency(new Dollar(17.45));
        list3.addCurrency(new Dollar(4.96));
        list3.removeCurrency(new Dollar(3.49));
        Assertions.assertEquals(7.93, list3.getStart().getData().toDouble());

        SinglyLinkedList list4 = new SinglyLinkedList();
        list4.addCurrency(new Dollar(1.2));
        list4.addCurrency(new Dollar(1.2));
        list4.removeCurrency(new Dollar(1.2));
        list4.removeCurrency(new Dollar(1.2));
        Assertions.assertEquals(0,list4.getCount());


        SinglyLinkedList list5 = new SinglyLinkedList();
        list5.addCurrency(new Dollar(21.5));
        list5.addCurrency(new Dollar(1.78));
        list5.addCurrency(new Dollar(3.14));
        list5.removeCurrency(new Dollar(21.5));
        Assertions.assertEquals(1.78, list5.getStart().getData().toDouble());
    }

    @Test
    void removeCurrencyIndex()
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addCurrency(new Dollar(1.2));
        list.addCurrency(new Dollar(1.21));
        list.addCurrency(new Dollar(3.96));
        list.addCurrency(new Dollar(7.28));
        list.addCurrency(new Dollar(15.12));

        list.removeCurrency(0);
        list.removeCurrency(3);

        double a = list.getNodeAtIndex(0).getData().toDouble();
        double b = list.getNodeAtIndex(1).getData().toDouble();
        double c = list.getNodeAtIndex(2).getData().toDouble();

        Assertions.assertEquals(1.21, a);
        Assertions.assertEquals(3.96, b);
        Assertions.assertEquals(7.28, c);

        Assertions.assertEquals(3, list.getCount());
    }

    @Test
    void countCurrency()
    {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addCurrency(new Dollar(2.5));
        list.addCurrency(new Dollar(1.1));
        list.addCurrency(new Dollar(1.0));
        Assertions.assertEquals(3,list.countCurrency());
        list.addCurrency(new Dollar(1.1));
        list.addCurrency(new Dollar(1.0));
        Assertions.assertEquals(5,list.countCurrency());

    }

    @Test
    void listFromArray()
    {
        Dollar[] currencies = new Dollar[5];
        double[] values = {1.23,4.96,7.98,0.25,11.45};
        for (int i = 0; i < currencies.length ;i++)
        {
            currencies[i] = new Dollar(values[i]);
        }
        SinglyLinkedList list = new SinglyLinkedList(currencies);
        list.printList();
        list.addCurrency(new Dollar(12.4),3);
        list.printList();
    }
}