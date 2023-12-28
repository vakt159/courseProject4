package com.example.courseProject.user;

import com.example.courseProject.item.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends CrudRepository<User,Long> {

    User save(User user);

    void delete(User user);
    Optional<User> findByEmail(String email);

    List<User> findAll();
}
