package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviePostManagerChangeFeedSizeTest {
    private  MoviePosterManager manager = new MoviePosterManager(9);
    private Movie first = new Movie(1, "фильм", "url", 11 * 12 * 2020, "фантастика");
    private Movie second = new Movie(2, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie third = new Movie(3, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie fourth = new Movie(4, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie fifth = new Movie(5, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie sixth = new Movie(6, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie seventh = new Movie(7, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie eighth = new Movie(8, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie ninth = new Movie(9, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie tenth = new Movie(10, "фильм", "url", 10 * 12 * 2020, "фантастика");
    private Movie eleventh = new Movie(11, "фильм", "url", 10 * 12 * 2020, "фантастика");

    @BeforeEach
    public void setUp() {
        manager.addToPoster(first);
        manager.addToPoster(second);
        manager.addToPoster(third);
        manager.addToPoster(fourth);
        manager.addToPoster(fifth);
        manager.addToPoster(sixth);
        manager.addToPoster(seventh);
        manager.addToPoster(eighth);
        manager.addToPoster(ninth);
    }




    @Test
    public void shouldCheckAdding() {
        Movie[] actual = manager.getMovies();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10AndMoviesAreActually10() {
        manager.addToPoster(tenth);
        Movie[] actual = manager.showMovieFeed();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreMoreThan10() {
        manager.addToPoster(tenth);
        manager.addToPoster(eleventh);
        Movie[] actual = manager.showMovieFeed();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckShowFeedForMoviesAmountInFeedIs10ButMoviesAreLess10() {
        Movie[] actual = manager.showMovieFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

}