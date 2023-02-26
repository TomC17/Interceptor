package main.java.FowlerMovieSystem;

import main.java.FowlerMovieSystem.Context.CustomerContext;
import main.java.FowlerMovieSystem.Dispatcher.Dispatcher;
import main.java.FowlerMovieSystem.Interceptor.ConsoleLoggingInterceptor;
import main.java.FowlerMovieSystem.Interceptor.Interceptor;

import static main.java.FowlerMovieSystem.Movie.*;

public class Application {
    public static void main(String[] args) {
        //Have a customer rent a new release movie
        Customer customer = new Customer("John Doe");

        Dispatcher dispatcher = Dispatcher.getInstance();

        //Create and register interceptor
        Interceptor consoleLoggingInterceptor = new ConsoleLoggingInterceptor();
        dispatcher.registerInterceptor(consoleLoggingInterceptor);

        customer.addRental(new Rental(new Movie("The Matrix", NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Godfather", REGULAR), 2));
        customer.addRental(new Rental(new Movie("The Godfather Part II", REGULAR), 1));
        customer.addRental(new Rental(new Movie("The Godfather Part III", REGULAR), 3));
        customer.addRental(new Rental(new Movie("The Shawshank Redemption", REGULAR), 2));
        customer.addRental(new Rental(new Movie("The Lion King", CHILDREN), 3));

        customer.setName("Nathan Drake");
    }
}
