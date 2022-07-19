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

    public Currency dequeue()
    {
        LinkNode retnNode = this.getStart();
        this.setStart(this.getStart().getNextNode());
        return retnNode.getData();
    }

    public Currency peekFront()
    {
        return this.getStart().getData();
    }

    public Currency peekRear()
    {
        return this.getEnd().getData();
    }

    /*
        public void push(Currency data)
        {
            LinkNode newNode = new LinkNode(data);
            newNode.setNextNode(this.getStart());
            this.setStart(newNode);
            this.setEnd(this.findEnd());
            this.setCount(this.getCount() + 1);
        }
     */

    public void printQueue()
    {
        LinkNode a = getStart();
        int count = 0;
        while (a != null)
        {
            System.out.println(count + ": " + a.getData());
            a = a.getNextNode();
            count = count + 1;
        }
        System.out.println();
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
