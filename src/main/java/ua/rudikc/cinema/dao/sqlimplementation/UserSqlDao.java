package ua.rudikc.cinema.dao.sqlimplementation;

import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.model.User;

import java.sql.ResultSet;

public class UserSqlDao implements UserDao {


    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void changeUserRole(User user) {

    }

    @Override
    public boolean isRegistered(String email) {
        return false;
    }

    @Override
    public boolean userIsExist(User user) {
        return false;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public User extractFromResultSet(ResultSet resultSet) {
        return null;
    }
}
