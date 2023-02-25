package main.java.FowlerMovieSystem;

public class RegularPrice extends Price {
    double price = 2;

    int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int daysRented) {
        if (daysRented > 2)
            price += (daysRented - 2) * 1.5;
        return price;
    }

    @Override
    public void setCharge(double price) {

        this.price = price;

    }
}
