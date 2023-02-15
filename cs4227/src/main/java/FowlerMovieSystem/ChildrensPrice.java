package main.java.FowlerMovieSystem;

public class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    public double getCharge(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}