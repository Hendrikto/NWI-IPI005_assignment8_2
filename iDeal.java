package assignment8_2;

/**
 * An payment method that uses iDeal.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class iDeal implements PaymentMethod {

    private final String bank;
    private final int rekeningnummer;
    private final int pincode;

    /**
     * Constructor method.
     *
     * @param bank the name of the bank
     * @param nummer the bank number of the customer
     * @param pin the pin number of the customer
     */
    public iDeal(String bank, int nummer, int pin) {
        this.bank = bank;
        this.rekeningnummer = nummer;
        this.pincode = pin;
    }

    /**
     * Initiate payment.
     *
     * @param bedrag the amount to pay
     * @return whether payment has been successful
     */
    @Override
    public boolean betaal(double bedrag) {
        System.out.printf(
                "Paying with iDeal: %.2f€\n\tbank: %s\n\trekeningnummer: %d\n\tpin: %d\n",
                bedrag,
                this.bank,
                this.rekeningnummer,
                this.pincode
        );
        return true;
    }

}
