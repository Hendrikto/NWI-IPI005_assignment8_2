package assignment8_2;

/**
 *
 * @author Hendrik
 */
public class iDeal implements PaymentMethod {

    private final String bank;
    private final int rekeningnummer;
    private final int pincode;

    public iDeal(String bank, int nummer, int pin) {
        this.bank = bank;
        this.rekeningnummer = nummer;
        this.pincode = pin;
    }

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
