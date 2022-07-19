public class Stack extends SinglyLinkedList
{

    public Stack()
    {
        super();
    }

    public Stack(LinkNode start, LinkNode end, int count)
    {
        super(start, end, count);
    }

    public Stack(Currency... currencies)
    {
        for (Currency cur: currencies)
        {
            this.push(cur);
        }
    }

    public Currency peek()
    {
        return this.getStart().getData();
    }

    public void push(Currency data)
    {
        LinkNode newNode = new LinkNode(data);
        newNode.setNextNode(this.getStart());
        this.setStart(newNode);
        this.setEnd(this.findEnd());
        this.setCount(this.getCount() + 1);
    }

    public Currency pop()
    {
        Currency cur =  this.getStart().getData();
        this.setStart(this.getStart().getNextNode());
        this.setCount(this.getCount() - 1);
        return cur;
    }

    public void printStack()
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
