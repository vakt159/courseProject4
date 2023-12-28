package com.example.courseProject.payment;

import com.example.courseProject.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentDAO extends CrudRepository<Payment,Long> {

    Payment save(Payment payment);

    void delete(Payment payment);

    Optional<Payment> findById(Long id);

    List<Payment> findAll();
}
