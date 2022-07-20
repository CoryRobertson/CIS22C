/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 3
 Statement of Lab: To work with linked lists, queues and stacks.
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to our third lab. This lab was written by Naran Nathan and Cory Robertson");
        Currency[] currencies = new Currency[20];
        currencies[0] = new Dollar(57.12);
        currencies[1] = new Dollar(23.44);
        currencies[2] = new Dollar(87.43);
        currencies[3] = new Dollar(68.99);
        currencies[4] = new Dollar(111.22);
        currencies[5] = new Dollar(44.55);
        currencies[6] = new Dollar(77.77);
        currencies[7] = new Dollar(18.36);
        currencies[8] = new Dollar(543.21);
        currencies[9] = new Dollar(20.21);
        currencies[10] = new Dollar(345.67);
        currencies[11] = new Dollar(36.18);
        currencies[12] = new Dollar(48.48);
        currencies[13] = new Dollar(101.00);
        currencies[14] = new Dollar(11.00);
        currencies[15] = new Dollar(21.00);
        currencies[16] = new Dollar(51.00);
        currencies[17] = new Dollar(1.00);
        currencies[18] = new Dollar(251.00);
        currencies[19] = new Dollar(151.00);

        SinglyLinkedList list = new SinglyLinkedList();


        for(int i = 6; i >= 0; i--)
        {
            list.addCurrency(currencies[i]);
        }

        System.out.println(list.findCurrency(new Dollar(87.43)));
        System.out.println(list.findCurrency(new Dollar(44.56)));

        list.removeCurrency(new Dollar(111.22));
        list.removeCurrency(2);

        list.printList();

        list.addCurrency(currencies[9],9%5);
        list.addCurrency(currencies[10],10%5);
        list.addCurrency(currencies[11],11%5);
        list.addCurrency(currencies[12],12%5);

        list.removeCurrency(list.countCurrency() % 6);
        list.removeCurrency(list.countCurrency() / 7);

        list.printList();

        Stack stack = new Stack();

        for(int i = 13; i < currencies.length ; i++)
        {
            stack.push(currencies[i]);
        }
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
        stack.push(currencies[0]);
        stack.push(currencies[1]);
        stack.push(currencies[2]);
        stack.push(currencies[3]);
        stack.push(currencies[4]);
        stack.pop();
        stack.pop();
        stack.printStack();

        Queue queue = new Queue();
        for(int i = 5; i < currencies.length - 1 ; i+=2)
        {
            queue.enqueue(currencies[i]);
        }

        System.out.println("\n"+queue.peekFront());
        System.out.println("\n"+queue.peekRear());

        queue.dequeue();
        queue.dequeue();

        System.out.println();
        queue.printQueue();


        for(int i = 10; i < 16; i++)
        {
            queue.enqueue(currencies[i]);
        }


        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println();
        queue.printQueue();

        System.out.println("Now exiting the list, stack and queue demo, thank you.");
    }
}
