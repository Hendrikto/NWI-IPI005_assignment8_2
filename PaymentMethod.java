package assignment8_2;

/**
 * An interface for payment methods.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public interface PaymentMethod {

    /**
     * Let the customer pay.
     *
     * @param bedrag the amount the customer has to pay
     * @return whether the payment was successful
     */
    public boolean betaal(double bedrag);

}
