package com.example.courseProject.order;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService  {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order save(Order order) {
        return null;
    }


    public void delete(Order order) {

    }


    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    public List<Order> findAll() {
        return null;
    }
}
