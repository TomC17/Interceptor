package main.java.FowlerMovieSystem.Dispatcher;

import main.java.FowlerMovieSystem.Context.CustomerContext;
import main.java.FowlerMovieSystem.Interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private final List<Interceptor> interceptors;

    private static Dispatcher instance;

    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public Dispatcher() {
        interceptors = new ArrayList<>();
    }

    public void dispatch(CustomerContext context) {
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(context);
        }
    }

    public void registerInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void removeInterceptor(Interceptor interceptor) {
        interceptors.remove(interceptor);
    }
}
