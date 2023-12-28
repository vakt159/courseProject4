package com.example.courseProject.itemWishlist;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemWishlistService {

    private final ItemWishlistDAO itemWishlistDAO;

    public ItemWishlistService(ItemWishlistDAO itemWishlistDAO) {
        this.itemWishlistDAO = itemWishlistDAO;
    }

    public List<ItemWishlist> findAll() {
        return itemWishlistDAO.findAll();
    }

    public Optional<ItemWishlist> findById(Long aLong) {
        return itemWishlistDAO.findById(aLong);
    }
    public ItemWishlist save(ItemWishlist itemWishlist)
    {
        return itemWishlistDAO.save(itemWishlist);
    }

    public void delete(ItemWishlist item)
    {
        itemWishlistDAO.delete(item);
    }
}
