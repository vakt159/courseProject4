package com.example.courseProject.item;

import com.example.courseProject.cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemDAO itemDAO;

    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public Item save(Item item) {
        return itemDAO.save(item);
    }

//    public Item updateItem(Long id, Item item) {
//        if (itemDAO.findById(id).isEmpty())
//            return null;
//        Item itemToUpdate = itemDAO.findById(id).get();
//        itemToUpdate.setId(item.getId());
//        itemToUpdate.setName(item.getName());
//        itemToUpdate.setItemCarts(item.getItemCarts());
//        itemToUpdate.setItemWishlists(item.getItemWishlists());
//        itemToUpdate.setAvailable(item.getAvailable());
//        itemToUpdate.setCategory(item.getCategory());
//        itemToUpdate.setComments(item.getComments());
//        itemToUpdate.setRating(item.getRating());
//        itemToUpdate.setQuantity(item.getQuantity());
//        itemToUpdate.setDescription(item.getDescription());
//        itemToUpdate.setPrice(item.getPrice());
//        return itemDAO.save(itemToUpdate);
//    }

    public void delete(Item entity) {
        itemDAO.delete(entity);
    }

    public Optional<Item> findById(Long aLong) {
        return itemDAO.findById(aLong);
    }

    public List<Item> findAll() {
        return itemDAO.findAll();
    }


}
