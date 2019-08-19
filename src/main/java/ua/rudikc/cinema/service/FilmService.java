package ua.rudikc.cinema.service;

import ua.rudikc.cinema.dao.FilmDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.FilmSqlDao;
import ua.rudikc.cinema.entity.Film;
import ua.rudikc.cinema.factory.DaoFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilmService {

    private static Comparator<Film> ALPHABETICAL_ORDER = (film1, film2) -> {
        int res = String.CASE_INSENSITIVE_ORDER.compare(film1.getName(), film2.getName());
        if (res == 0) {
            res = film1.getName().compareTo(film2.getName());
        }
        return res;
    };

    public List<Film> getAllFilms(){
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

    public List<Film> getFilmsPagination(int page, int itemsPerPage) {
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        int lowerLimit = (page-1)*itemsPerPage;

        return filmSqlDao.paginationGet(lowerLimit, itemsPerPage);
    }

    public List<Integer> getFilmsMaxPages(int itemsPerPage) {
        FilmSqlDao filmSqlDao = (FilmSqlDao) DaoFactory.getDao(DaoFactory.FILM_DAO);
        List<Integer> pages = new ArrayList<>();
        int rows = filmSqlDao.countFilms();
        int pagesCount = rows / itemsPerPage;

        if (rows%itemsPerPage != 0){
            pagesCount += 1;
        }
        for (int i = 1; i <= pagesCount; i++) {
            pages.add(i);
        }
        return pages;
    }
}
