package assignment8_2;

/**
 * A watermelon.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Watermeloen extends Artikel {

    /**
     * Constructor method.
     */
    public Watermeloen() {
        this.beschrijving = "Watermeloen";
        this.prijs = 4.50;
    }

    /**
     * Get the shipping costs of a melon.
     *
     * @return the shipping costs of a melon
     */
    @Override
    public double verzendkosten() {
        return 6.75;
    }

}
