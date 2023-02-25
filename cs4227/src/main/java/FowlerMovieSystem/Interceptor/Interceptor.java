package main.java.FowlerMovieSystem.Interceptor;

import main.java.FowlerMovieSystem.Context.CustomerContext;

public interface Interceptor {
    void intercept(CustomerContext context);
}
