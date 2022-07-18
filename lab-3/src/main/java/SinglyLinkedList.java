public class SinglyLinkedList
{
    private int count;
    private LinkNode start;
    private LinkNode end;

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

    public SinglyLinkedList(LinkNode start, LinkNode end, int count)
    {
        this.start = start;
        this.end = end;
        this.count = count;
    }

    public void addCurrency()
    {

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

    public void printList()
    {
        LinkNode a = getStart();
        while (a != null)
        {
            System.out.println(a.getData());
            a = a.getNextNode();
        }
    }

    public void isListEmpty()
    {
        LinkNode a = getStart();

        //if()
    }
}
