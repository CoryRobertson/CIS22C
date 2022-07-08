public class Pound extends Currency
{

    private final String name = "Pound";

    public Pound()
    {
        super();
    }

    public Pound(double value)
    {
        super(value);
    }

    public Pound(Pound p)
    {
        super(p);
    }

    @Override
    public String toString()
    {
        return name + " " + this.getWholePart() + "." + this.getFractionalPart();
    }

    public void subtract(Pound cur)
    {
        super.subtract(cur);
    }

    public void add(Pound cur)
    {
        super.add(cur);
    }

}