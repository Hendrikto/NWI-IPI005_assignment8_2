package assignment8_2;

/**
 * Represents abstract articles.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public abstract class Artikel {

    protected String beschrijving;
    protected double prijs;

    /**
     * Get the description of this.
     *
     * @return the description of this
     */
    public String getBeschrijving() {
        return this.beschrijving;
    }

    /**
     * Get the price of this.
     *
     * @return the price of this
     */
    public double getPrijs() {
        return this.prijs;
    }

    /**
     * Get the shipping costs of this.
     *
     * @return the shipping costs of this
     */
    public abstract double verzendkosten();

    /**
     * Get a String representation of this.
     *
     * @return a String representation of this
     */
    @Override
    public String toString() {
        return String.format("%s (%.2f€)", this.beschrijving, this.prijs);
    }

    /**
     * Check for equality with another object.
     *
     * @param o the object to test
     * @return whether this is the same product as the object provided
     */
    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }

}
