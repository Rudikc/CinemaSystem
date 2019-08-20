package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.dao.exception.DaoException;

import java.util.List;
import java.util.Optional;

/**
 * Interface for basic crud operations.
 *
 * @param <T> - entity type
 */
public interface Dao<T> {

    /**
     * Finds entity in database by id.
     *
     * @param id - entity id in database
     * @return Optional of entity type
     * @throws DaoException
     */
    Optional<T> get(int id) throws DaoException;

    /**
     * Finds every entity in database of type T
     * @return list of entities
     * @throws DaoException
     */
    List<T> getAll() throws DaoException;

    /**
     * Saves an entity to database.
     * @param t - entity
     * @throws DaoException
     */
    void save(T t) throws DaoException;

    /**
     * Updates an entity from database.
     * @param t - entity
     * @throws DaoException
     */
    void update(T t) throws DaoException;

    /**
     * Deletes an entity form database.
     * @param t - entity
     * @throws DaoException
     */
    void delete(T t) throws DaoException;
}
