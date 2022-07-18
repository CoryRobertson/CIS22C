public class SinglyLinkedList
{
    private int count;
    private LinkNode start;
    private LinkNode end;

    public SinglyLinkedList(LinkNode start, LinkNode end, int count)
    {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public SinglyLinkedList()
    {
        this.start = null;
        this.end = null;
        this.count = 0;
    }

    public int getCount()
    {

        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public LinkNode getStart()
    {
        return start;
    }

    public void setStart(LinkNode start)
    {
        this.start = start;
    }

    public LinkNode getEnd()
    {
        return end;
    }


    public void setEnd(LinkNode end)
    {
        this.end = end;
    }


// this is for queue and stack only
//    public void push(Currency data)
//    {
//        LinkNode newNode = new LinkNode(data);
//        newNode.setNextNode(this.start);
//        this.setStart(newNode);
//        this.setEnd(findEnd());
//        this.setCount(this.count + 1);
//    }

    public void addCurrency(Currency cur, int index)
    {
        LinkNode a = this.getStart();
        if (a != null) {
            for (int i = 0; i < index - 1; i++) {
                a = a.getNextNode();
            }
            a.setNextNode(new LinkNode(a.getNextNode(), cur));
        }
        else
        { // list start is null
            this.setStart(new LinkNode(cur));
        }
        this.setCount(this.getCount() + 1);
        this.setEnd(this.findEnd());
    }


    //this adds to end ??!?
    public void addCurrency(Currency cur)
    {
        LinkNode newNode = new LinkNode(cur);


        LinkNode last = this.getStart();

        if(last != null)
        {
            while (last.getNextNode() != null) {
                last = last.getNextNode();
            }
            last.setNextNode(newNode);
        } else
        {
            this.setStart(new LinkNode(cur));
        }
        this.setCount(this.getCount() + 1);
        this.setEnd(this.findEnd());

    }

    public int findCurrency(Currency cur)
    {
        LinkNode a = getStart();
        int index = 0;
        while(a != null)
        {
            if(a.getData().isEqual(cur))
            {
                return index;
            }
            index = index + 1;
            a = a.getNextNode();
        }
        return -1;
    }

    public Currency getCurrency(int index)
    {
        LinkNode a = getStart();
        for (int i = 0; i < index; i++)
        {
            a = a.getNextNode();
        }
        return a.getData();

    }

    public LinkNode getNodeAtIndex(int index)
    {
        LinkNode a = getStart();
        for (int i = 0; i < index; i++)
        {
            a = a.getNextNode();
        }
        return a;
    }

    public void printList()
    {
        LinkNode a = getStart();
        int count = 0;
        while (a != null)
        {
            System.out.println(count + ": " + a.getData());
            a = a.getNextNode();
            count = count + 1;
        }
        System.out.println("");
    }

//    public void countCurrency(Currency cur)
//    {
//        LinkNode a = getStart();
//
//        while(a != null)
//        {
//
//        }
//    }

    /*
        removeCurrency method which takes a Currency object as parameter and removes that Currency object from
            the list and may return a copy of the Currency.
        removeCurrency overload method which takes a node index as parameter and removes the Currency object
            at that index and may return a copy of the Currency.
     */

    public void removeCurrency(Currency cur)
    {
        LinkNode previousNode = this.getStart();
        while(!previousNode.getNextNode().getData().isEqual(cur))
        {
            previousNode = previousNode.getNextNode();
        }
        previousNode.setNextNode(previousNode.getNextNode().getNextNode());
        this.setCount(this.count - 1);
        this.setEnd(this.findEnd());
    }

    private LinkNode findEnd()
    {
        LinkNode a = getStart();

        if(this.getCount() == 0)
        {
            return null;
        }

        while(a.getNextNode() != null)
        {
            a = a.getNextNode();
        }
        return a;
    }

    public boolean isListEmpty()
    {
        LinkNode a = getStart();
        LinkNode b = getEnd();
        return (a == null && b == null);
    }

}
