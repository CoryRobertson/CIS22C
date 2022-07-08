public class Dollar extends Currency
{

    private final String name = "Dollar";

    public Dollar()
    {
        super();
    }

    public Dollar(double value)
    {
        super(value);
    }

    public Dollar(Dollar d)
    {
        super(d);
    }


    @Override
    public String toString()
    {
        return name + " " + this.getWholePart() + "." + this.getFractionalPart();
    }

    public void subtract(Dollar cur)
    {
        super.subtract(cur);
    }

    public void add(Dollar cur)
    {
        super.add(cur);
    }

}