package main.java.FowlerMovieSystem.Context;

import main.java.FowlerMovieSystem.Customer;
import main.java.FowlerMovieSystem.Rental;

import java.util.Collections;
import java.util.List;

public class CustomerContext {
    private final Customer customer;

    public CustomerContext(Customer customer) {

        this.customer = customer;

    }

    public String getName() {
        return customer.getName();
    }

    public List<Rental> getRentals() {
        return Collections.unmodifiableList(customer.getRentals());
    }

    public int getRentalsAmount() {
        return customer.getRentalsAmount();
    }

    public double getTotalCharge() {
        return customer.getTotalCharge();
    }

    public int getTotalFrequentRenterPoints() {
        return customer.getTotalFrequentRenterPoints();
    }

    public String statement() {
        return customer.statement();
    }

    public String htmlStatement() {
        return customer.htmlStatement();
    }
}
