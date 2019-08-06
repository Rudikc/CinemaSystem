package ua.rudikc.cinema.dao;

import javax.management.relation.Role;

public interface UserRoleDao {
    void createRole(Role role);
    void deleteRole(String name);
}
