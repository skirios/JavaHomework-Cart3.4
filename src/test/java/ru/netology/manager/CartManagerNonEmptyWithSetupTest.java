package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviePosterManagerChangeFeedSizeTest {
    private MoviePosterManager manager = new MoviePosterManager(9);
    private Movie first = new Movie(1, "фильм", "url", 11*12*2020, "фантастика");
    private Movie second = new Movie(2, "фильм", "url", 10*12*2020, "фантастика");
    private Movie third = new Movie(3, "фильм", "url", 10*12*2020,"фантастика" );
    private Movie fourth = new Movie(4, "фильм", "url", 10*12*2020, "фантастика");
    private Movie fifth = new Movie(5, "фильм", "url",10*12*2020, "фантастика");
    private Movie sixth = new Movie(6, "фильм", "url",10*12*2020, "фантастика");
    private Movie seventh = new Movie(7, "фильм", "url",10*12*2020, "фантастика");
    private Movie eighth = new Movie(8, "фильм", "url",10*12*2020, "фантастика");
    private Movie ninth = new Movie(9, "фильм", "url",10*12*2020, "фантастика");
    private Movie tenth = new Movie(10, "фильм", "url",10*12*2020, "фантастика");


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
    }

    @Test
    public void moviesInThePosterAreLessThan10() { // фильмов к выдаче меньше 10
        manager.addToPoster(ninth);
        Movie[] actual = manager.showMovieFeed();
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void moviesForIssuingMoreThan10() { // фильмов к выдаче больше 10
        manager.addToPoster(ninth);
        Movie[] actual = manager.showMovieFeed();
        Movie[] expected = new Movie[]{eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }
}