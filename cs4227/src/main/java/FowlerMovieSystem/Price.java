package main.java.FowlerMovieSystem;

public abstract class Price {
    double price = 0;

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

    public abstract void setCharge(double price);
}
