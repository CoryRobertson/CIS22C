/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 3
 Statement of Lab: To work with linked lists, queues and stacks.
 */
public class Queue extends SinglyLinkedList
{

    public Queue()
    {
        super();
    }

    public Queue(LinkNode start, LinkNode end, int count)
    {
        super(start, end, count);
    }

    public Queue(Currency... currencies)
    {
        for (Currency cur: currencies)
        {
            this.enqueue(cur);
        }
    }
    /**
     * pre: a valid currency object
     * post: sets the currency value to the end of the list
     */
    public void enqueue(Currency cur)
    {
        LinkNode nodeToAdd = new LinkNode(cur);
        if(this.getCount() == 0)
        {
            this.setStart(nodeToAdd);
        }
        else
        {
            this.setEnd(this.findEnd());
            this.getEnd().setNextNode(nodeToAdd);
        }
        this.setEnd(this.findEnd());
        this.setCount(this.getCount() + 1);
    }

    /**
     * pre: n/a
     * post: removing the currency object from the front of the queue
     */
    public Currency dequeue()
    {
        Currency cur =  this.getStart().getData();
        this.setStart(this.getStart().getNextNode());
        this.setCount(this.getCount() - 1);
        return cur;
    }
    /**
     * pre: n/a
     * post: views the front of the queue
     */
    public Currency peekFront()
    {
        return
                this.getStart().getData();
    }
    /**
     * pre: n/a
     * post: views the end of the queue
     */
    public Currency peekRear()
    {
        return
                this.getEnd().getData();
    }
    /**
     * pre: n/a
     * post: prints the queue
     */
    public void printQueue()
    {
        LinkNode start = this.getStart();
        int count = 0;
        while(start != null) {
            System.out.println(count + ": " + start.getData());
            start = start.getNextNode();
            count = 1 + count;
        }
    }


    @Override
    @Deprecated
    public void addCurrency(Currency cur, int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void addCurrency(Currency cur) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void removeCurrency(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void removeCurrency(Currency cur) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void printList() {
        throw new UnsupportedOperationException();
    }

}
