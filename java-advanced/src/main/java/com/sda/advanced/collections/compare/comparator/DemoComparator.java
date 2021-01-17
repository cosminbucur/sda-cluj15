package com.sda.advanced.collections.compare.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparator {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie("movie 1", 2);
        movies.add(movie1);
        Movie movie2 = new Movie("movie 2", 5);
        movies.add(movie2);
        movies.add(new Movie("movie 3", 3));

        movies.forEach(movie -> System.out.println(movie));

        Collections.sort(movies, new RatingComparator());

        movies.forEach(movie -> System.out.println(movie));
    }
}
