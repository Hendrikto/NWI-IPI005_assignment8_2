package assignment8_2;

/**
 *
 * @author Hendrik
 */
public class Watermeloen extends Artikel {

    public Watermeloen() {
        this.beschrijving = "Watermeloen";
        this.prijs = 4.50;
    }

    @Override
    public double verzendkosten() {
        return 6.75;
    }

}
