package com.example.courseProject.wishlist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistDAO extends CrudRepository<Wishlist,Long> {

    Optional<Wishlist> findById(Long id);

    @Override
    List<Wishlist> findAll();

    Wishlist save(Wishlist wishlist);

    void delete(Wishlist wishlist);
    @Query(value = "TRUNCATE TABLE WISHLIST",nativeQuery = true)
    void clear(Wishlist wishlist);

}
