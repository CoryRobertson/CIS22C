
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


    @Override
    public void subtract(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Dollar)
        {
            super.subtract(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot subtract " + cur.getClass().toString() + " from " + this.getClass().toString());
        }
    }

    @Override
    public boolean isEqual(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Dollar)
        {
            return super.isEqual(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot compare " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

    @Override
    public boolean isGreater(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Dollar)
        {
            return super.isGreater(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot compare " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

    @Override
    public void add(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Dollar)
        {
            super.add(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot add " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

}