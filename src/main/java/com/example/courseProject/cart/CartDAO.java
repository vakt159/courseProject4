package com.example.courseProject.cart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartDAO extends CrudRepository<Cart,Long> {

    Optional<Cart> findById(Long id);

    @Override
    List<Cart> findAll();

    Cart save(Cart cart);

    void delete(Cart cart);
    @Query(value = "TRUNCATE TABLE CART",nativeQuery = true)
    void clear(Cart cart);

}
