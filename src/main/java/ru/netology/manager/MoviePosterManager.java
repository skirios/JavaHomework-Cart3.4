package ru.netology.manager;

import ru.netology.domain.Movie;


public class MoviePosterManager {
    private Movie[] movies = new Movie[0];
    private int moviesAmountFeed = 10;

    public Movie[] getMovies() {
        return movies;
    }

    public MoviePosterManager() {

    }

    public MoviePosterManager(int moviesAmountFeed) {
        this.moviesAmountFeed = moviesAmountFeed;
    }


    public void addToPoster(Movie movie) {

        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

//    public Movie[] showMovieFeed() {
//        PurchaseItem[] result = new PurchaseItem[items.length];
//        // перебираем массив в прямом порядке
//        // но кладём в результаты в обратном
//        for (int i = 0; i < result.length; i++) {
//            int index = items.length - i - 1;
//            result[i] = items[index];
//        }
//        return result;
//    }

    // наивная реализация
    public Movie[] showMovieFeed() {
        int length = moviesAmountFeed;
        if (moviesAmountFeed > movies.length) {
            length = movies.length;
        }


        Movie[] result = new Movie[length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}