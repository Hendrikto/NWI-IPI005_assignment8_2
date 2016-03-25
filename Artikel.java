package assignment8_2;

/**
 *
 * @author Hendrik
 */
public abstract class Artikel {

    protected String beschrijving;
    protected double prijs;

    public String getBeschrijving() {
        return this.beschrijving;
    }

    public double getPrijs() {
        return this.prijs;
    }

    public abstract double verzendkosten();

    @Override
    public String toString() {
        return String.format("%s (%.2f€)", this.beschrijving, this.prijs);
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }

}
