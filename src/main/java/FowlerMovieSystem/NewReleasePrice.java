package main.java.FowlerMovieSystem;

public class NewReleasePrice extends Price {
    double price = 3;

    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * price;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }

    @Override
    public void setCharge(double price) {
        this.price = price;
    }
}
