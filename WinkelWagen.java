package assignment8_2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Hendrik
 */
public class WinkelWagen {

    private final LinkedList<Artikel> articles;
    private PaymentMethod payment;
    private boolean paid = false;

    public WinkelWagen(PaymentMethod payment, Artikel... articles) {
        this.payment = payment;
        this.articles = new LinkedList<>(Arrays.asList(articles));
    }

    public boolean add(Artikel a) {
        if (!this.paid) {
            this.articles.add(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Artikel a) {
        if (!this.paid) {
            return this.articles.remove(a);
        } else {
            return false;
        }
    }

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

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    public boolean pay() {
        if (this.paid) {
            return false;
        } else {
            this.paid = this.payment.betaal(this.getCost());
            return this.paid;
        }
    }

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
