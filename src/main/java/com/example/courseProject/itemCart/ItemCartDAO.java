package com.example.courseProject.itemCart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCartDAO extends CrudRepository<ItemCart,Long> {

    @Override
    List<ItemCart> findAll();

    @Override
    Optional<ItemCart> findById(Long aLong);

    @Override
    void delete(ItemCart entity);

    @Override
    ItemCart save(ItemCart entity);
}
