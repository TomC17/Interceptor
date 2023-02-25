package main.java.FowlerMovieSystem.Interceptor;

import main.java.FowlerMovieSystem.Context.CustomerContext;

public class ConsoleLoggingInterceptor implements Interceptor {
    @Override
    public void intercept(CustomerContext context) {
        System.out.println(context.getName() + " rented " + context.getRentalsAmount() + " movies");
        System.out.println();
        System.out.println("Total charge: " + context.getTotalCharge());
        System.out.println();
        System.out.println("Total frequent renter points: " + context.getTotalFrequentRenterPoints());
        System.out.println();
        System.out.println("Statement: " + context.statement());
        System.out.println();
        System.out.println("HTML Statement: " + context.htmlStatement());
        System.out.println();

    }

//log using context

}
