public abstract class Currency
{
  /*
    -Default Construction (i.e. no parameters passed).
    -Construction based on one single input of type double - create logical objects only, i.e. no negative value objects allowed.
    -Copy Constructor and/or Assignment (i.e. the input is an object of the same class), as applicable to your programming language of choice.
    !--Destructor, as applicable to your programming language of choice.
    -Setters and Getters for all attributes, as may be necessary.
    A method called add for adding an input object of the same currency.
    -A method called subtract for subtracting an input object of the same currency - the result should be logical, i.e. negative results are not allowed.
    -A method called isEqual for comparing an input object of the same currency for equality/inequality.
    -A method called isGreater for comparing an input object of the same currency to identify which object is larger or smaller.
    -?A method called toString to 'stringify' the name and value of a currency object in the form "xx.yy" followed by the derived currency name, e.g. 1.23 Dollar or 2.46 Pound.
    -All of the above should be instance methods and not static.
    -The add and subtract as specified should manipulate the object on which they are invoked. It is allowed to have overloaded methods that create and return new objects .
  */

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

    public void setFractionalPart(int fractionalPart)
    {
        if (fractionalPart < 0)
        {
            throw new IllegalArgumentException(" value cannot be a negative number: " + fractionalPart);
        }
        this.fractionalPart = fractionalPart;
    }

    public void subtract(Currency cur) throws NumberFormatException
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

    public boolean isEqual(Currency cur)
    {
        boolean wholeEqual = this.getWholePart() == cur.getWholePart();
        boolean fracEqual = this.getFractionalPart() == cur.getFractionalPart();
        return (wholeEqual && fracEqual) == true;
    }

    public boolean isGreater(Currency cur)
    {
        double value = this.getWholePart() + ((double)this.getFractionalPart()/100);
        double curValue = cur.getWholePart() + ((double)cur.getFractionalPart()/100);
        return (value > curValue);
    }


    public void add(Currency cur)
    {
        double value = ((this.getWholePart()) * 100) + (this.getFractionalPart());
        double curValue = ((cur.getWholePart()) * 100) + (cur.getFractionalPart());

        //double value = this.getWholePart() + ((double)this.getFractionalPart()/100);
        //double curValue = cur.getWholePart() + ((double)cur.getFractionalPart()/100);

        double newValue = value + curValue;
        if(value < 0 || curValue < 0){
            throw new NumberFormatException("Value cannot be a negative");
        }
        // new value = 12.76
        this.setWholePart((int)newValue / 100); // set whole part to 12
        this.setFractionalPart((int)(newValue % 100)); // set frac part to 76
    }

    @Override
    public String toString()
    {
        return this.getClass().toString() + " " + this.getWholePart() + "." + this.getFractionalPart();
    }

    /**
     * @return the value of the currency in double form, e.g. 1.26
     */
    public double toDouble()
    {
        return ((this.getWholePart()*100) + this.getFractionalPart()) / 100.0;
    }

}
