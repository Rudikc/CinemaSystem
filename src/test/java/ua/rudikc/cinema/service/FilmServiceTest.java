package ua.rudikc.cinema.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.rudikc.cinema.entity.Film;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilmServiceTest {
    private static FilmService filmService;
    private static List<Film> films;

    @BeforeClass
    public static void init() {
        filmService = new FilmService();
    }

    @Before
    public void setUp() {
        films = new ArrayList<>();
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticalExceptionWhenZeroIsSetAsAParameter() {
        filmService.getFilmsMaxPages(0);
    }


    @Test
    public void quantityOfFilmsShouldEqualsItemsPerPage() {
        int itemsPerPage = 1;
        films = filmService.getFilmsPagination(1, itemsPerPage);
        assertEquals(itemsPerPage, films.size());
        itemsPerPage = 2;
        films = filmService.getFilmsPagination(2, itemsPerPage);
        assertEquals(itemsPerPage, films.size());

    }

    @Test
    public void getAllFilms() {
        films = filmService.getAllFilms();
        assertNotNull(films);
//        assertThat(films.get(0).getName(), greaterThan(films.get(1).getName()) );

    }
}