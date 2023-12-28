package com.example.courseProject.comment;

import com.example.courseProject.cart.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentDAO extends CrudRepository<Comment,Long> {

    Optional<Comment> findById(Long id);

    @Override
    List<Comment> findAll();

    Comment save(Comment comment);

    void delete(Comment comment);


}
