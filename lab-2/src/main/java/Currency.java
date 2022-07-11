/*
 Authors:
 Cory Robertson
 Naran Nathan
 Lab Team: 26
 Lab Number: 2
 Statement of Lab: To demonstrate usage of polymorphism, inheritance, and class design to simulate currency
 */
public abstract class Currency
{

    private int wholePart;
    private int fractionalPart;

    public Currency()
    {
        this.setWholePart(0);
        this.setFractionalPart(0);
    }

    public Currency(double value) // value = 12.58
    {

        if (value < 0)
        {
            throw new IllegalArgumentException(" value cannot be a negative number: " + value);
        }

        int newWholePart = (int) (value);
        int newFracPart = (int) ((value * 100.0) % 100.0);
        this.setWholePart(newWholePart);
        this.setFractionalPart(newFracPart);

    }

    public Currency(Currency cur)
    {
        this.wholePart = cur.wholePart;
        this.fractionalPart = cur.fractionalPart;
    }

    public int getWholePart()
    {
        return wholePart;
    }

    public void setWholePart(int wholePart)
    {
        if (wholePart < 0)
        {
            throw new IllegalArgumentException(" value cannot be a negative number: " + wholePart);
        }
        this.wholePart = wholePart;
    }

    public int getFractionalPart()
    {
        return fractionalPart;
    }

    public void setFractionalPart(int fractionalPart) throws IllegalArgumentException
    {
        if (fractionalPart < 0)
        {
            throw new IllegalArgumentException(" value cannot be a negative number: " + fractionalPart);
        }
        this.fractionalPart = fractionalPart;
    }

    /**
     * pre: A currency object that is not null
     * post: Changes the value of the parent object to the difference of both of the objects
     **/
    public void subtract(Currency cur) throws IllegalArgumentException
    {
        double value = ((this.getWholePart() - cur.getWholePart()) * 100) + (this.getFractionalPart() - cur.getFractionalPart());

        if (value < 0) // negative value check exception
        {
            throw new IllegalArgumentException(" value cannot be a negative number: " + this + ":" + value + " - " + cur);
        }

        int newWholePart = (int) (value / 100);
        int newFracPart = (int) (value % 100);

        this.setWholePart(newWholePart);
        this.setFractionalPart(newFracPart);

    }

    /**
     * pre: A currency object that is not null
     * post: Returns a true value if the wholePart and fractionalPart are equals.
     **/
    public boolean isEqual(Currency cur)
    {
        boolean wholeEqual = this.getWholePart() == cur.getWholePart();
        boolean fracEqual = this.getFractionalPart() == cur.getFractionalPart();
        return (wholeEqual && fracEqual);
    }

    /**
     * pre: A currency object that is not null
     * post: Returns true if and only if parent object is greater than given object
     **/
    public boolean isGreater(Currency cur)
    {
        double value = this.getWholePart() + ((double)this.getFractionalPart()/100);
        double curValue = cur.getWholePart() + ((double)cur.getFractionalPart()/100);
        return (value > curValue);
    }

    /**
     * pre: A currency object that is not null
     * post: Changes the value of the parent currency to the sum of both of the currencies
     **/
    public void add(Currency cur)
    {
        double value = ((this.getWholePart()) * 100) + (this.getFractionalPart());
        double curValue = ((cur.getWholePart()) * 100) + (cur.getFractionalPart());

        double newValue = value + curValue;
        if(value < 0 || curValue < 0){
            throw new NumberFormatException("Value cannot be a negative");
        }
        // new value = 12.76
        this.setWholePart((int)newValue / 100); // set whole part to 12
        this.setFractionalPart((int)(newValue % 100)); // set frac part to 76
    }

    /**
     * pre: n/a
     * post: Returns the name of the class, plus the wholePart and fractionalPart combined.
     **/
    @Override
    public String toString()
    {
        return this.getClass().toString() + " " + this.getWholePart() + "." + this.getFractionalPart();
    }

    /**
     * @return the value of the currency in double form, e.g. whole = 1, frac = 26, output = 1.26
     */
    public double toDouble()
    {
        return ((this.getWholePart()*100) + this.getFractionalPart()) / 100.0;
    }

}
