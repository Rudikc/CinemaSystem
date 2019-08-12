package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(T t) throws DaoException;
}
