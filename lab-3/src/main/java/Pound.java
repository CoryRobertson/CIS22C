/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 2
 Statement of Lab: To demonstrate usage of polymorphism, inheritance, and class design to simulate currency
 */
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
     * pre: A pound object that is not null
     * post: Changes the value of the parent pound to the difference of both of the pounds, changed value must be positive
     **/
    @Override
    public void subtract(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Pound)
        {
            super.subtract(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot subtract " + cur.getClass().toString() + " from " + this.getClass().toString());
        }
    }

    /**
     * pre: A pound object that is not null
     * post: Returns a true value if and only if the parent pound is equal to a given pound.
     **/
    @Override
    public boolean isEqual(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Pound)
        {
            return super.isEqual(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot compare " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

    /**
     * pre: A pound object that is not null
     * post: returns true if and only if, the parent object is greater than the given object
     **/
    @Override
    public boolean isGreater(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Pound)
        {
            return super.isGreater(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot compare " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

    /**
     * pre: A pound object that is not null
     * post: Changes the value of the parent pound to the sum of both of the pounds
     **/
    @Override
    public void add(Currency cur) throws IllegalArgumentException
    {
        if(cur instanceof Pound)
        {
            super.add(cur);
        }
        else
        {
            throw new IllegalArgumentException("Cannot add " + cur.getClass().toString() + " to " + this.getClass().toString());
        }
    }

}