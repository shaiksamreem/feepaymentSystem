package com.shaik.fees_payment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shaik.fees_payment.entity.User;

public class UserDao {
	private static SessionFactory factory;

    public void UserDAO() {
        factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    }
    
    public User login(String username, String password) {
        User user = null;
        try (Session session = factory.openSession()) {
            String hql = "FROM User WHERE username = :username AND password = :password";
            user = session.createQuery(hql, User.class)
                          .setParameter("username", username)
                          .setParameter("password", password)
                          .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public static void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public User getUserById(int id) {
        User user = null;
        try (Session session = factory.openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Read (Get all Users)
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> users = null;
        try (Session session = factory.openSession()) {
            users = session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
	public void registerUser(String username, String password) {
		// TODO Auto-generated method stub
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Consider hashing the password before saving
        UserDao.saveUser(user);

	}
	
}

	

