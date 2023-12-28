package com.example.courseProject.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemDAO extends CrudRepository<Item,Long> {

    Item save(Item item);

    void delete(Item entity);

    Optional<Item> findById(Long aLong);

    List<Item> findAll();
}
