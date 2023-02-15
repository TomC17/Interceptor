package test.java.FowlerMovieSystemTest;

import main.java.FowlerMovieSystem.Interceptor.Interceptor;
import org.junit.jupiter.api.Test;
import main.java.FowlerMovieSystem.Customer;
import main.java.FowlerMovieSystem.Movie;
import main.java.FowlerMovieSystem.Rental;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    Interceptor interceptor = new Interceptor() {
        @Override
        public void before(String method) {
            System.out.println("Before " + method);

        }

        @Override
        public void after(String method) {
            System.out.println("After " + method);

        }
    };
    Customer customer = new Customer("Tester", interceptor);

    @Test
    public void test() {
        customer.addRental(new Rental(new Movie("Movie1", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Movie2", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Movie3", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Movie4", Movie.CHILDREN), 4));

        String expected = "" +
                "Rental record for Tester\n" +
                "\tMovie1\t2.0\n" +
                "\tMovie2\t6.0\n" +
                "\tMovie3\t9.0\n" +
                "\tMovie4\t3.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 6 frequent renter points";

        assertEquals(expected, customer.statement());
        System.out.println(customer.statement());
    }
}