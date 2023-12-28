package com.example.courseProject.payment;

import com.example.courseProject.payment.Payment;
import com.example.courseProject.payment.PaymentDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentDAO paymentDAO;

    public PaymentService(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public Payment save(Payment payment) {
        return null;
    }


    public void delete(Payment payment) {

    }


    public Optional<Payment> findById(Long id) {
        return Optional.empty();
    }

    public List<Payment> findAll() {
        return null;
    }
}
