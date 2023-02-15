package main.java.FowlerMovieSystem;

import main.java.FowlerMovieSystem.Interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String _name;
    private final List<Rental> _rentals = new ArrayList<>();
    private final Interceptor _interceptor;

    public Customer(String name, Interceptor interceptor) {
        _name = name;
        _interceptor = interceptor;
    }

    public void addRental(Rental arg) {
        _interceptor.before("addRental in Customer");
        _rentals.add(arg);
        _interceptor.after("addRental in Customer");
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        _interceptor.before("statement in Customer");

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

        _interceptor.after("statement in Customer");

        return result;
    }

    public String htmlStatement() {
        _interceptor.before("htmlStatement in Customer");

        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental each : _rentals) {
            //show figures for each rental
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";

        _interceptor.after("htmlStatement in Customer");

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        _interceptor.before("getTotalFrequentRenterPoints in Customer");

        int result = 0;
        for (Rental each : _rentals) {
            result += each.getFrequentRenterPoints();
        }

        _interceptor.after("getTotalFrequentRenterPoints in Customer");

        return result;
    }

    private double getTotalCharge() {
        _interceptor.before("getTotalCharge in Customer");

        double result = 0;
        for (Rental each : _rentals) {
            result += each.getCharge();
        }

        _interceptor.after("getTotalCharge in Customer");

        return result;
    }
}
