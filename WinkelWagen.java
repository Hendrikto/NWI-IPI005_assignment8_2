package assignment8_2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Manage the user's shopping cart.
 *
 * @author Hendrik Werner // s4549775
 * @author Jasper Haasdijk // s4449754
 */
public class WinkelWagen {

    private final LinkedList<Artikel> articles;
    private PaymentMethod payment;
    private boolean paid = false;

    /**
     * Constructor method.
     *
     * @param payment the payment method to use
     * @param articles initial articles to put in the shopping cart
     */
    public WinkelWagen(PaymentMethod payment, Artikel... articles) {
        this.payment = payment;
        this.articles = new LinkedList<>(Arrays.asList(articles));
    }

    /**
     * Add an article to the shopping cart.
     *
     * @param a the article to add
     * @return whether the article has been added
     */
    public boolean add(Artikel a) {
        if (!this.paid) {
            this.articles.add(a);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove an article from the shopping cart.
     *
     * @param a the article to remove
     * @return whether there has been a change to the shopping cart
     */
    public boolean remove(Artikel a) {
        if (!this.paid) {
            return this.articles.remove(a);
        } else {
            return false;
        }
    }

    /**
     * Calculate the total cost of the shopping cart including shipping.
     *
     * @return the total cost of this shopping cart
     */
    public double getCost() {
        int total = 0;
        // sum cost of articles
        total += this.articles.stream().map((a) -> {
            return a.getPrijs();
        }).reduce(0.0, (a, b) -> {
            return a + b;
        });
        // add the sum of unique shipping costs and return that
        return total + this.articles.stream().map((a) -> {
            return a.verzendkosten();
        }).distinct().reduce(0.0, (a, b) -> {
            return a + b;
        });
    }

    /**
     * Set the payment method.
     *
     * @param payment the payment method to use
     */
    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    /**
     * Use the chosen payment method to make the user pay.
     *
     * @return whether payment has been successful
     */
    public boolean pay() {
        if (this.paid) {
            return false;
        } else {
            this.paid = this.payment.betaal(this.getCost());
            return this.paid;
        }
    }

    /**
     * Get a String representation of this shopping cart.
     *
     * @return a String representation of this shopping cart
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WinkelWagen:\n============\n");
        this.articles.stream().forEach((a) -> {
            sb.append(String.format("- %s\n", a));
        });
        sb.append(String.format("============\ntotal cost: %.2f€\n", this.getCost()));
        return sb.toString();
    }

}
