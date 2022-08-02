public class HashTable
{
    Entry[] array;
    int size;
    public HashTable(int size)
    {
        this.size = size;
        this.array = new Entry[size];

        for(int i = 0; i < size; i++)
        {
            array[i] = new Entry();
        }
    }

    private int getHash(Dollar key)
    {
        final int w = key.getWholePart();
        final int f = key.getFractionalPart();
        final int m = 2;
        final int n = 3;
        return ((m*w + n*f) % this.size);
    }

    public void put(Dollar val)
    {
        put(val, val);
    }

    public void put(Dollar key, Dollar value)
    {
        int hash = getHash(key);

        Entry arrayVal = array[hash];
        Entry newVal = new Entry(key, value);
        newVal.next = arrayVal.next;
        arrayVal.next = newVal;
        this.array[hash] = newVal;
    }

    public Dollar get(Dollar key)
    {
        Dollar retn = null;

        int hash = getHash(key);

        Entry arrayValue = array[hash];

        while(arrayValue != null)
        {
            if(arrayValue.getKey().isEqual(key))
            {
                retn = arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.next;
        }

        return retn;
    }

}
