package test.java.FowlerMovieSystemTest;

import main.java.FowlerMovieSystem.Context.CustomerContext;
import main.java.FowlerMovieSystem.Customer;
import main.java.FowlerMovieSystem.Dispatcher.Dispatcher;
import main.java.FowlerMovieSystem.Interceptor.ConsoleLoggingInterceptor;
import main.java.FowlerMovieSystem.Interceptor.Interceptor;
import main.java.FowlerMovieSystem.Movie;
import main.java.FowlerMovieSystem.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    ConsoleLoggingInterceptor consoleLoggingInterceptor = new ConsoleLoggingInterceptor();
    Interceptor[] interceptors = {consoleLoggingInterceptor};

    @Test
    public void CustomerTest() {
        // Create a new customer
        Customer customer = new Customer("Tester");

        // Add some rentals to the customer
        Movie movie1 = new Movie("Movie 1", Movie.REGULAR);
        Rental rental1 = new Rental(movie1, 3);
        customer.addRental(rental1);

        Movie movie2 = new Movie("Movie 2", Movie.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 2);
        customer.addRental(rental2);

        // Call the statement method and check the output
        String expected = "Rental record for Tester\n" +
                "\tMovie 1\t3.5\n" +
                "\tMovie 2\t6.0\n" +
                "Amount owed is 11.0\n" +
                "You earned 3 frequent renter points";
        assertEquals(expected, customer.statement());

        //now we want to test the interceptor
        //first we create the dispatcher
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.registerInterceptor(consoleLoggingInterceptor);


        // Create a new customer with context
        Customer customer2 = new Customer("Tess Tue");
        //now we want to add some rentals to the customer
        Movie movie3 = new Movie("Movie 3", Movie.REGULAR);
        Rental rental3 = new Rental(movie3, 3);
        customer2.addRental(rental3);

        Movie movie4 = new Movie("Movie 4", Movie.NEW_RELEASE);
        Rental rental4 = new Rental(movie4, 2);
        customer2.addRental(rental4);

        Movie movie5 = new Movie("Movie 5", Movie.CHILDREN);
        Rental rental5 = new Rental(movie5, 6);
        customer2.addRental(rental5);

        CustomerContext context = new CustomerContext(customer2);
        //now we want to create a stringbuilder to store the output of various methods
        StringBuilder resultBuilder = new StringBuilder();
        //now we want to call the dispatcher to dispatch the context
        dispatcher.dispatch(context);
        //now we want to get the output from the context
        resultBuilder.append(context.getName());
        resultBuilder.append(context.getRentalsAmount());
        resultBuilder.append(context.getTotalFrequentRenterPoints());
        resultBuilder.append(context.getTotalCharge());
        //now we want to check the output

        String expectedInterceptor = "Tess Tue3445.5";
        assertEquals(expectedInterceptor, resultBuilder.toString());
    }

    @Test
    public void NoCustomersTest() {
        // Create a new customer with no rentals
        Customer customer = new Customer("Empty");

        // Call the statement method and check the output
        String expected = """
                Rental record for Empty
                Amount owed is 0.0
                You earned 0 frequent renter points""";
        assertEquals(expected, customer.statement());

        //now we want to test the interceptor
        //first we create the dispatcher
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.registerInterceptor(consoleLoggingInterceptor);

        // Create a new customer with context
        Customer customer2 = new Customer("Empty ");
        CustomerContext context;
        context = new CustomerContext(customer2);
        //now we want to create a stringbuilder to store the output of various methods
        StringBuilder resultBuilder = new StringBuilder();
        //now we want to call the dispatcher to dispatch the context
        dispatcher.dispatch(context);
        //now we want to get the output from the context
        resultBuilder.append(context.getName());
        resultBuilder.append(context.getRentalsAmount());
        resultBuilder.append(context.getTotalFrequentRenterPoints());
        resultBuilder.append(context.getTotalCharge());
        //now we want to check the output

        String expectedInterceptor = "Empty 000.0";
        assertEquals(expectedInterceptor, resultBuilder.toString());


    }
}
