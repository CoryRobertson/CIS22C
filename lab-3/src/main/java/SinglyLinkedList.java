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



    public void push(Currency data)
    {
        LinkNode newNode = new LinkNode(data);
        newNode.setNextNode(this.start);
        this.setStart(newNode);
        this.setEnd(findEnd());
        this.setCount(this.count + 1);
    }

    public void addCurrency(Currency cur, int index)
    {
        LinkNode a = this.getStart();
        for(int i = 0 ; i < index - 1; i++)
        {
            a = a.getNextNode();
        }
        a.setNextNode(new LinkNode(a.getNextNode(), cur));
        this.setCount(this.getCount() + 1);


    }


    //this adds to end ??!?
//    public void addCurrency(Currency cur, LinkNode previousNode)
//    {
//        LinkNode newNode = new LinkNode(cur);
//
//
//        LinkNode last = this.getStart();
//
//        while(last.getNextNode() != null)
//        {
//            last = last.getNextNode();
//        }
//        last.setNextNode(newNode);
//
//
//    }

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

    private LinkNode findEnd()
    {
        LinkNode a = getStart();
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
