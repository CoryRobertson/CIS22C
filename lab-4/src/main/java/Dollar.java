/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 2
 Statement of Lab: To demonstrate usage of polymorphism, inheritance, and class design to simulate currency
 */
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

    /**
     * pre: n/a
     * post: Returns the name of the class, plus the wholePart and fractionalPart combined.
     **/
    @Override
    public String toString()
    {
        return name + " " + this.getWholePart() + "." + this.getFractionalPart();
    }

    /**
     * pre: A dollar object that is not null
     * post: Changes the value of the parent object to the difference of both of the objects, changed value must be positive
     **/
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

    /**
     * pre: A dollar object that is not null
     * post: Returns a true value if and only if the parent dollar is equals to given dollar.
     **/
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

    /**
     * pre: A dollar object that is not null
     * post: Returns true if and only if parent dollar is greater than the given dollar
     **/
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

    /**
     * pre: A dollar object that is not null
     * post: Changes the value of the parent dollar to the sum of both of the dollars
     **/
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