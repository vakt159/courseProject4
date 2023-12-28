package com.example.courseProject.itemWishlist;

import com.example.courseProject.itemCart.ItemCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemWishlistDAO extends CrudRepository<ItemWishlist,Long> {

    @Override
    List<ItemWishlist> findAll();

    @Override
    Optional<ItemWishlist> findById(Long aLong);

    @Override
    void delete(ItemWishlist entity);

    @Override
    ItemWishlist save(ItemWishlist entity);
}
