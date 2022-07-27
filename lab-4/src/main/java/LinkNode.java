public class LinkNode
{
    private LinkNode next;
    private Currency data;

    public LinkNode(LinkNode nextNode, Currency dataIn)
    {
        this.next = nextNode;
        this.data = dataIn;
    }

    public LinkNode()
    {
        this.next = null;
        this.data = null;
    }

    public LinkNode(Currency dataIn)
    {
        this.data = dataIn;
    }

    public LinkNode(LinkNode nextNode)
    {
        this.next = nextNode;
    }

    public LinkNode getNextNode()
    {
        return next;
    }

    public void setNextNode(LinkNode next)
    {
        this.next = next;
    }

    public Currency getData()
    {
        return data;
    }

    public void setData(Currency data)
    {
        this.data = data;
    }
}
