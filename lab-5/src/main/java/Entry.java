public class Entry
{
    Dollar key;
    Dollar value;
    Entry next;
    public Entry(Dollar key, Dollar value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Entry()
    {
        next = null;
    }

    public Dollar getKey() {return key;}

    public Dollar getValue()
    {
        return value;
    }

    public Entry getNext()
    {
        return next;
    }
}
