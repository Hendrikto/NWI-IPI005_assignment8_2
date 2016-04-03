package assignment8_2;

/**
 * Contains the main method.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class Assignment8_2 {

    /**
     * Entry point.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PaymentMethod payment = new iDeal("Rabobank", 1234567890, 1234);
        WinkelWagen w = new WinkelWagen(payment, new Watermeloen());
        w.add(new Watermeloen());
        System.out.println(w);
        w.pay(); // if this succeeds it blocks further actions (see below)
        w.add(new Watermeloen()); // this does not get added
        w.remove(new Watermeloen()); // this does not get removed
        w.pay(); // this does not cause a second payment
    }

}
