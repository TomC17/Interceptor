package main.java.FowlerMovieSystem;

import main.java.FowlerMovieSystem.Interceptor.ConsoleLoggingInterceptor;

public class Rental {

    private final Movie _movie;
    private final int _daysRented;
    private final ConsoleLoggingInterceptor _interceptor;

    public Rental(Movie movie, int daysRented, ConsoleLoggingInterceptor interceptor) {
        _movie = movie;
        _daysRented = daysRented;
        _interceptor = interceptor;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    double getCharge() {
        if (_interceptor != null) {
            _interceptor.log("Calling getCharge() from Rental on Movie: " + _movie.getTitle());
        }
        return _movie.getCharge(_daysRented);
    }

    public int getFrequentRenterPoints() {
        if (_interceptor != null) {
            _interceptor.log("Calling getFrequentRenterPoints() from Rental on Movie: " + _movie.getTitle());
        }
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
