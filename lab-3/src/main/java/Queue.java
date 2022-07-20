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

    //enqueue which takes a Currency object as parameter and adds it to the end of the queue.
    // public void enqueue(Currency cur)
    // {
    // 	LinkNode newNode = new LinkNode(cur);

    // 	if(this.getEnd() == null) {
    // 		this.getStart() = this.getEnd() = newNode;
    // 		return;
    // 	}
    // 	this.getEnd().next = newNode;
    // 	this.getEnd() = newNode;

    // }

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
        Currency cur =  this.getStart().getData();
        this.setStart(this.getStart().getNextNode());
        this.setCount(this.getCount() - 1);
        return cur;
    }

    public Currency peekFront()
    {
        return
                this.getStart().getData();
    }

    public Currency peekRear()
    {
        return
                this.getEnd().getData();
    }

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
