package com.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movie implements Comparable{
    private double rating;
    private String name;
    private int year;

    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Object o) {
        return this.year - ((Movie) o).year;
    }

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(
                new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(
                new Movie("Return of the Jedi", 8.4, 1983));

        //year compare

        System.out.println("before year sorting::");
        list.stream().map(x -> x.getYear()).forEach(System.out::println);

        Collections.sort(list);
        System.out.println("after year sorting::");
        list.stream().map(x -> x.getYear()).forEach(System.out::println);

        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        System.out.println("after rating sorting::");
        list.stream().map(x -> x.getRating()).forEach(System.out::println);

        NameCompare nameCompare = new NameCompare();
        Collections.sort(list,nameCompare);
        System.out.println("after name sorting::");
        list.stream().map(x -> x.getName()).forEach(System.out::println);
    }
}

class RatingCompare implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getRating() < o2.getRating())
            return -1;
        if(o1.getRating() > o2.getRating())
            return 1;
        else
            return 0;
    }
}

class NameCompare implements Comparator<Movie>
{

    @Override
    public int compare(Movie o1, Movie o2) {
       return o1.getName().compareTo(o2.getName());
    }
}
