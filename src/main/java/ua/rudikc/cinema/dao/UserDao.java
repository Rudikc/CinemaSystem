package ua.rudikc.cinema.dao;

import ua.rudikc.cinema.model.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDao {
    User getUserById(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    void changeUserRole(User user);
    boolean isRegistered(String email);
    boolean userIsExist(User user);
    User findByEmailAndPassword(String email, String password);
    User extractFromResultSet(ResultSet resultSet);
}
