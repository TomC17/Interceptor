package main.java.FowlerMovieSystem;

public class ChildrensPrice extends Price {
    double price = 1.5;

    int getPriceCode() {
        return Movie.CHILDREN;
    }

    public double getCharge(int daysRented) {
        if (daysRented > 3)
            price += (daysRented - 3) * 1.5;
        return price;
    }

    @Override
    public void setCharge(double price) {

        this.price = price;

    }


}