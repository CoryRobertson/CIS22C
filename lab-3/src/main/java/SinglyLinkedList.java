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


// this is for queue and stack only
//    public void push(Currency data)
//    {
//        LinkNode newNode = new LinkNode(data);
//        newNode.setNextNode(this.start);
//        this.setStart(newNode);
//        this.setEnd(findEnd());
//        this.setCount(this.count + 1);
//    }

    /**
     * Adds a new currency object to the index specified, e.g. if you have a list
     * 0: 0.25
     * 1: 1.24
     * 2: 3.14
     * 3: 4.96
     * and call addCurrency(new Dollar(7.94), 2), the new list would be
     * 0: 0.25
     * 1: 1.24
     * 2: 7.94
     * 3: 3.14
     * 4: 4.96
     * a worded explanation of this, would be that it adds the new currency to the list, such that the added currency is at the index given.
     * @param cur currency to add
     * @param index index to add to, making this object have this index
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
     * no index given, so this function adds the currency object to the end
     * @param cur a valid Currency Object
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
     * returns the integer index of where the given currency object is, if found
     * @param cur a valid currency object
     * @return if not found, returns -1, else, the index of the found object
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
     * @param index the index to go to and get the object
     * @return the Currency object at the given index
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
     * @param index the index to get the node from
     * @return a LinkNode at the given index
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
     * Prints out the list in order of appearance, e.g.
     * 0: Dollar 1.23
     * 1: Dollar 4.96
     * 2: Dollar 7.98
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
     * @return the number of objects in the list
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
     * Removes the object at the index, and patches up the node graph
     * @param index the index to remove
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
     * Removes the currency object given in parameter from the list, will always remove the first occurrence
     * @param cur the object to search for
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
     * @return recalculates the end of the list, called hopefully at the end of any method that changes the list
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
     * @return true if and only if there is a start and end to the list, no null nodes
     */
    public boolean isListEmpty()
    {
        LinkNode a = getStart();
        LinkNode b = getEnd();
        return (a == null && b == null);
    }

}
