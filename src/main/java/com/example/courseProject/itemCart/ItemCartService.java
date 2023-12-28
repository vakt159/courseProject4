package com.example.courseProject.itemCart;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ItemCartService{

    private final ItemCartDAO itemCartDAO;

    public ItemCartService(ItemCartDAO itemCartDAO) {
        this.itemCartDAO = itemCartDAO;
    }

    public List<ItemCart> findAll() {
        return itemCartDAO.findAll();
    }

    public Optional<ItemCart> findById(Long aLong) {
        return itemCartDAO.findById(aLong);
    }
    public ItemCart save(ItemCart itemCart)
    {
        return itemCartDAO.save(itemCart);
    }

    public void delete(ItemCart item)
    {
        itemCartDAO.delete(item);
    }
}
