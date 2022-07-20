/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 3
 Statement of Lab: To work with linked lists, queues and stacks.
 */
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

    public SinglyLinkedList(Currency... currencies)
    {
        this.start = null;
        this.end = null;
        this.count = 0;
        for (Currency cur: currencies)
        {
            addCurrency(cur);
        }
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


    /**
     * pre: a valid Currency object, an index >= 0 and < the length of the list
     * post: the given currency object will be added to the list such that its index is the given index from the parameter
     */
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


    /**
     * pre: a valid currency object
     * post: adds the given currency object to the end of the list
     */
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

    /**
     * pre: a valid currency object
     * post: returns the integer index of where the given currency object is, if found, else returns -1
     */
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

    /**
     * pre: index the index to go to and get the object
     * post: the Currency object at the given index
     */
    public Currency getCurrency(int index)
    {
        LinkNode a = getStart();
        for (int i = 0; i < index; i++)
        {
            a = a.getNextNode();
        }
        return a.getData();

    }

    /**
     * pre: the index to get the node from
     * post: a LinkNode at the given index
     */
    public LinkNode getNodeAtIndex(int index)
    {
        LinkNode a = getStart();
        for (int i = 0; i < index; i++)
        {
            a = a.getNextNode();
        }
        return a;
    }


    /**
     * pre: nothing
     * post: prints the contents of the list
     */
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
        System.out.println();
    }

    /**
     * pre: nothing
     * post: the number of objects in the list
     */
    public int countCurrency()
    {
        LinkNode a = getStart();
        int count = 0;
        while(a != null)
        {
            a = a.getNextNode();
            count = count + 1;
        }
        return count;
    }

    /**
     * pre: index to remove object from
     * post: nothing
     */
    public void removeCurrency(int index)
    {
        LinkNode a = this.getStart();
        for(int i = 0; i < index; i++)
        {
            a = a.getNextNode();
        }
        removeCurrency(a.getData());
    }

    /**
     * pre: the object to search for and remove
     * post: removes the given object if found, if not, nothing happens
     */
    public void removeCurrency(Currency cur)
    {
        LinkNode previousNode = this.getStart();

        if(previousNode.getData().isEqual(cur))
        {// this case occurs when the start is the node to remove

            this.setStart(previousNode.getNextNode());

        }
        else // else we need to go find the node that has the data to remove
        {

            while (!previousNode.getNextNode().getData().isEqual(cur)) {
                previousNode = previousNode.getNextNode();
            }
            // set the next node to the node two ahead, skipping the node intended to be removed
            previousNode.setNextNode(previousNode.getNextNode().getNextNode());

        }
        this.setCount(this.count - 1);
        this.setEnd(this.findEnd());
    }

    /**
     * pre: nothing
     * post: recalculates the end of the list, called hopefully at the end of any method that changes the list
     */
    public LinkNode findEnd()
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

    /**
     * pre: nothing
     * post: true if and only if there is a start and end to the list, no null nodes
     */
    public boolean isListEmpty()
    {
        LinkNode a = getStart();
        LinkNode b = getEnd();
        return (a == null && b == null);
    }

}
