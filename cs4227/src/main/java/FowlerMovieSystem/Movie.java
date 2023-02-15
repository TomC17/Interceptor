package main.java.FowlerMovieSystem;

import main.java.FowlerMovieSystem.Interceptor.ConsoleLoggingInterceptor;

public class Movie {

    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private final String _title;
    private final ConsoleLoggingInterceptor _loggingInterceptor;
    private Price _price;

    public Movie(String title, int priceCode, ConsoleLoggingInterceptor loggingInterceptor) {
        _title = title;
        _loggingInterceptor = loggingInterceptor;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        log("Calling setPriceCode on Movie from Movie: " + _title + " with arg: " + arg + "");
        switch (arg) {
            case REGULAR -> _price = new RegularPrice();
            case CHILDREN -> _price = new ChildrensPrice();
            case NEW_RELEASE -> _price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }



    public double getCharge(int daysRented) {
        log("Calling getCharge on Movie from Movie: " + _title + " with arg: " + daysRented + "");
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        log("Calling getFrequentRenterPoints on Movie from Movie: " + _title + " with arg: " + daysRented + "");
        return _price.getFrequentRenterPoints(daysRented);
    }

    private void log(String message) {
        if (_loggingInterceptor != null) {
            _loggingInterceptor.log(message);
        }
    }
}