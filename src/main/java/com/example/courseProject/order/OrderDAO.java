package com.example.courseProject.order;

import com.example.courseProject.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDAO extends CrudRepository<Order,Long> {

    Order save(Order order);

    void delete(Order order);

    Optional<Order> findById(Long id);

    List<Order> findAll();
}
