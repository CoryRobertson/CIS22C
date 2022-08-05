/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 5
 Statement of Lab: To demonstrate usage of hash tables with currency
 */
public class HashTable {
    Entry[] array;
    int size;
    int collisions;
    /**
     * pre: An integer of size
     * post:
     **/
    public HashTable(int size) {
        this.size = size;
        this.array = new Entry[size];
        collisions = 0;

        for (int i = 0; i < size; i++) {
            array[i] = new Entry();
        }
    }

    private int getHash(Dollar key) {
        final int w = key.getWholePart();
        final int f = key.getFractionalPart();
        final int m = 2;
        final int n = 3;
        return ((m * w + n * f) % this.size);
    }

    public void put(Dollar val) {
        put(val, val);
    }

    public double loadFactor()
    {
        return (double) getCount() / size;
    }

    public int getCount()
    {
        int count = 0;

        for(Entry entry : array)
        {
            if(entry.getValue() != null) { count = count + 1; }
        }

        return count;
    }

    public int getCollisions()
    {
        return collisions;
    }

    public void put(Dollar key, Dollar value) {
        int hash = getHash(key);

        Entry arrayVal = array[hash];
        int i = 1;
        while (arrayVal.getKey() != null) {
            // this loop is for quadratic probing
            hash = (getHash(key) + i * i) % this.size;
            arrayVal = array[hash];
            i++;
            this.collisions += 1;
        }

        Entry newVal = new Entry(key, value);
        newVal.next = arrayVal.next;
        arrayVal.next = newVal;
        this.array[hash] = newVal;
    }

    public Dollar get(Dollar key)
    {

        int hash = getHash(key);
        int i = 1;


        Entry arrayVal = array[hash];
        while(arrayVal != null)
        {
            if(arrayVal.getKey() == null) {break;}

            if(arrayVal.getKey().isEqual(key))
            {
                return arrayVal.getValue();
            }
            else
            {
                hash = (getHash(key) + i*i) % this.size;
                arrayVal = array[hash];
                i++;
            }
//            arrayVal = arrayVal.next;
        }
        return null;
    }

}
