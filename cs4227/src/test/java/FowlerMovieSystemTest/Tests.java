package test.java.FowlerMovieSystemTest;

import main.java.FowlerMovieSystem.Customer;
import main.java.FowlerMovieSystem.Interceptor.ConsoleLoggingInterceptor;
import main.java.FowlerMovieSystem.Interceptor.Interceptor;
import main.java.FowlerMovieSystem.Movie;
import main.java.FowlerMovieSystem.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    ConsoleLoggingInterceptor consoleLoggingInterceptor = new ConsoleLoggingInterceptor();
    Interceptor[] interceptors = {consoleLoggingInterceptor};



    Customer customer = new Customer("Tester");
    @Test
    public void CustomerTest() {
        Rental rental1 = new Rental(
                new Movie("REGULAR", Movie.REGULAR),
                1
        );
        customer.addRental(rental1);
        Rental rental2 = new Rental(
                new Movie("NEW_RELEASE 1", Movie.NEW_RELEASE),
                2
        );
        customer.addRental(rental2);
        Rental rental3 = new Rental(
                new Movie("NEW_RELEASE 2", Movie.NEW_RELEASE),
                3
        );
        customer.addRental(rental3);
        Rental rental4 = new Rental(
                new Movie("CHILDREN", Movie.CHILDREN),
                4
        );
        customer.addRental(rental4);

        String expected = """
                Rental record for Tester
                \tREGULAR\t2.0
                \tNEW_RELEASE 1\t6.0
                \tNEW_RELEASE 2\t9.0
                \tCHILDREN\t3.0
                Amount owed is 20.0
                You earned 6 frequent renter points""";

        assertEquals(expected, customer.statement());
        System.out.println(customer.statement());
    }

    @Test
    public void NoCustomersTest() {
        String expected = "" +
                "Rental record for Tester\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        assertEquals(expected, customer.statement());
        System.out.println(customer.statement());
    }
}

