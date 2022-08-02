

public class Main
{
    public static void main(String[] args)
    {
        HashTable table = new HashTable(29);
        table.put(new Dollar(1.0));
        table.put(new Dollar(1.1));
        table.put(new Dollar(1.2));
    }
}