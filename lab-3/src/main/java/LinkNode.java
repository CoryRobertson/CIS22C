public class LinkNode
{
    private LinkNode next;

    public LinkNode getNextNode() {
        return next;
    }

    public void setNextNode(LinkNode next) {
        this.next = next;
    }

    public Currency getData() {
        return data;
    }

    public void setData(Currency data) {
        this.data = data;
    }

    private Currency data;

    public LinkNode(LinkNode nextNode, Currency dataIn)
    {
        this.next = nextNode;
        this.data = dataIn;
    }
}
