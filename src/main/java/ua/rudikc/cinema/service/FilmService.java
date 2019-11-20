package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.FilmDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.DaoFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Film service
 */
public class FilmService {

    /**
     * Comparator to sort films in alphabetical order by name
     */
    private static final Comparator<Film> ALPHABETICAL_ORDER = (film1, film2) -> {
        int res = String.CASE_INSENSITIVE_ORDER.compare(film1.getName(), film2.getName());
        if (res == 0) {
            res = film1.getName().compareTo(film2.getName());
        }
        return res;
    };

    /**
     * Adds film to database
     * @param film
     */
    public void addFilm(Film film){
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        try {
            filmSqlDao.save(film);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes film from database
     * @param film
     */
    public void removeFilm (Film film){
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        try {
            filmSqlDao.delete(film);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return list of all films in database
     */
    public List<Film> getAllFilms() {
        FilmDao filmDao = (FilmDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        List<Film> allFilms = new ArrayList<>();
        try {
            allFilms = filmDao.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        allFilms.sort(ALPHABETICAL_ORDER);
        return allFilms;
    }

    /**
     * @param page
     * @param itemsPerPage
     * @return film pagination variant of select
     */
    public List<Film> getFilmsPagination(int page, int itemsPerPage) {
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        int lowerLimit = (page - 1) * itemsPerPage;

        return filmSqlDao.paginationGet(lowerLimit, itemsPerPage);
    }

    /**
     * @param itemsPerPage
     * @return value of maximum possible pages
     */
    public List<Integer> getFilmsMaxPages(int itemsPerPage) {
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        List<Integer> pages = new ArrayList<>();
        int rows = filmSqlDao.countFilms();
        int pagesCount = rows / itemsPerPage;

        if (rows % itemsPerPage != 0) {
            pagesCount += 1;
        }
        for (int i = 1; i <= pagesCount; i++) {
            pages.add(i);
        }
        return pages;
    }
}
