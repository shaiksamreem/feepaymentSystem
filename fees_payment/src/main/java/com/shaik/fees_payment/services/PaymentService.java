package com.shaik.fees_payment.services;

import java.util.List;

import com.shaik.fees_payment.dao.PaymentDao;
import com.shaik.fees_payment.entity.Payment;

public class PaymentService {
	private static PaymentDao paymentDAO = new PaymentDao();

    public static void addPayment(Payment payment) {
        paymentDAO.savePayment(payment);
    }

    public List<Payment> getPaymentsByStudentId(Long studentId) {
        return paymentDAO.getPaymentsByStudentId(studentId);
    }
    public static void addPayment1(Payment payment) {
        paymentDAO.savePayment(payment);
    }

    // Get Payment by ID
    public static Payment getPayment(Long id) {
        return paymentDAO.getPayment(id);
    }

    // Update Payment
    public static void updatePayment(Payment payment) {
        paymentDAO.updatePayment(payment);
    }

    // Delete Payment
    public static boolean deletePayment(Long id) {
        paymentDAO.deletePayment(id);
		return true;
    }

    // Get All Payments
    public static List<Payment> getAllPayments() {
        return paymentDAO.getPaymentsByStudentId(null);
    }

	
}



