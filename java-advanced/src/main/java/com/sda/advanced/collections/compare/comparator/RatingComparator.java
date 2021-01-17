package com.sda.advanced.collections.compare.comparator;

import java.util.Comparator;

public class RatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return Integer.compare(movie2.getRating(), movie1.getRating());
    }

//    @Override
//    public int compare(Movie movie1, Movie movie2) {
//        if (movie1.getRating() < movie2.getRating()) return -1;
//        if (movie1.getRating() > movie2.getRating()) return 1;
//        else return 0;
//    }
}
