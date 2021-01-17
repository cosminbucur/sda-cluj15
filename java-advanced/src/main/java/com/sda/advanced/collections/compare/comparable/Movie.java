package com.sda.advanced.collections.compare.comparable;

public class Movie implements Comparable<Movie> {

    private String title;
    private int rating;

    public Movie(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

//    @Override
//    public int compareTo(Movie other) {
//        if (this.rating < other.rating) {
//            return -1;
//        } else if (this.rating == other.rating) {
//            return 0;
//        }
//        return 1;
//    }

    @Override
    public int compareTo(Movie other) {
        return other.rating - this.rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
