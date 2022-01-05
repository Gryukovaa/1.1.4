package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserDao userDaoHibernateImpl = new UserDaoHibernateImpl();

    public   UserServiceImpl() {

    }

    public void createUsersTable() {
        userDaoHibernateImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernateImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernateImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernateImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernateImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernateImpl.cleanUsersTable();
    }
}
