package com.shaik.fees_payment.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shaik.fees_payment.entity.Payment;

public class PaymentDao {
	private SessionFactory factory;

    public void PaymentDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void savePayment(Payment payment) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Payment> getPaymentsByStudentId(Long studentId) {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Payment where student.id = :studentId", Payment.class)
                          .setParameter("studentId", studentId)
                          .list();
        }
    }

    public Payment getPayment(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Payment.class, id);
        }
    }

    // Update Payment
    public void updatePayment(Payment payment) {
        Transaction transaction = null;
        try (Session session =factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Delete Payment
    public void deletePayment(Long id) {
        Transaction transaction = null;
        try (Session session =factory.openSession()) {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            if (payment != null) {
                session.delete(payment);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

	
}
