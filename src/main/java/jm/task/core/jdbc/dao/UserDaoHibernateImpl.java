package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Util util = new Util();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user.user (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(20)  NOT NULL, " +
                "lastName VARCHAR(20) NOT NULL, " +
                "age INT NOT NULL);";

            try (Session session = util.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                Query query = session.createSQLQuery(sql);
                query.executeUpdate();
                transaction.commit();
                System.out.println("table created");
            }
    }

    @Override
    public void dropUsersTable() {
        try (Session session  = util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS user.user");
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session  = util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session  = util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :userId");
            query.setParameter("userId", id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session  = util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM User");
            return query.getResultList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (Session session  = util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE User");
            query.executeUpdate();
            transaction.commit();
        }
    }
}
