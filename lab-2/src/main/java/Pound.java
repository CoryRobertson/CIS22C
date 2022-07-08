import java.security.InvalidParameterException;

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

    @Override
    public void subtract(Currency cur) throws InvalidParameterException
    {
        if(cur instanceof Pound)
        {
            super.subtract(cur);
        }
        else
        {
            throw new InvalidParameterException("Cannot subtract " + cur.getClass().toString() + " from " + this.getClass().toString());
        }
    }

    @Override
    public void add(Currency cur) throws InvalidParameterException
    {
        if(cur instanceof Pound)
        {
            super.add(cur);
        }
        else
        {
            throw new InvalidParameterException("Cannot add " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

}