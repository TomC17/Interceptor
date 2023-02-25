package main.java.FowlerMovieSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final List<Rental> _rentals = new ArrayList<>();
    private String _name;

    public Customer(String name) {

        _name = name;

    }

    public static Customer getCustomer() {
        return new Customer("Customer");
    }

    public void addRental(Rental arg) {
        //before takes a context object, not a string

        _rentals.add(arg);

    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {

        _name = name;
    }

    public String statement() {


        int frequentRenterPoints = 0;
        StringBuilder resultBuilder = new StringBuilder("Rental record for " + getName() + "\n");
        for (Rental rental : _rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();

            // show figures for this rental
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge()).append("\n");
        }
        String result = resultBuilder.toString();

        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";


        return result;
    }

    public String htmlStatement() {


        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental each : _rentals) {
            //show figures for each rental
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";


        return result;
    }

    public int getTotalFrequentRenterPoints() {


        int result = 0;
        for (Rental each : _rentals) {
            result += each.getFrequentRenterPoints();
        }


        return result;
    }

    public double getTotalCharge() {


        double result = 0;
        for (Rental each : _rentals) {
            result += each.getCharge();
        }


        return result;
    }

    public List<Rental> getRentals() {
        return _rentals;
    }

    public int getRentalsAmount() {
        return _rentals.size();
    }
}
