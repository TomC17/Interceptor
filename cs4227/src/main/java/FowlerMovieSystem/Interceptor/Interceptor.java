package main.java.FowlerMovieSystem.Interceptor;

public interface Interceptor {
    void before(String method);

    void after(String method);
}
