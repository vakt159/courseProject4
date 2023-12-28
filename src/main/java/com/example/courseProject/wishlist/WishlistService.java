package com.example.courseProject.wishlist;

import com.example.courseProject.item.Item;
import com.example.courseProject.item.ItemService;
import com.example.courseProject.itemWishlist.ItemWishlist;
import com.example.courseProject.itemWishlist.ItemWishlistService;
import com.example.courseProject.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WishlistService {
    private final WishlistDAO wishlistDAO;
    private final ItemWishlistService itemWishlistService;
    private final ItemService itemService;

    public WishlistService(WishlistDAO wishlistDAO, ItemWishlistService itemWishlistService, ItemService itemService) {
        this.wishlistDAO = wishlistDAO;
        this.itemWishlistService = itemWishlistService;
        this.itemService = itemService;
    }

    public Optional<Wishlist> findById(Long id) {
        if (wishlistDAO.findById(id).isEmpty())
            return Optional.empty();
        return wishlistDAO.findById(id);
    }


    public Wishlist save(Wishlist wishlist) {
        return wishlistDAO.save(wishlist);
    }

    public void clear(User user) {
        wishlistDAO.clear(user.getWishlist());
    }


    public List<Item> getItems(User user) {
        Wishlist usersWishlist=user.getWishlist();
        List<ItemWishlist> itemWishlistList = usersWishlist.getItemWishlists().stream().
                filter(i -> Objects.equals(i.getWishlist().getId(), usersWishlist.getId())).toList();
        return itemWishlistList.stream().map(ItemWishlist::getItem).toList();
    }

    public List<Wishlist> findAll() {
        return wishlistDAO.findAll();
    }

    public Wishlist addItem(Wishlist wishlist, Item item) {
        ItemWishlist itemWishlist = new ItemWishlist();
        itemWishlist.setWishlist(wishlist);
        if (itemWishlistService.findById(item.getId()).isPresent()) {
            ItemWishlist foundItemWishlist = itemWishlistService.findById(item.getId()).get();
            itemWishlistService.save(foundItemWishlist);
        }
        itemWishlist.setItem(item);
        itemWishlistService.save(itemWishlist);
        return wishlist;
    }

    public Wishlist removeItem(Wishlist wishlist, Item item) {
        ItemWishlist itemWishlist = new ItemWishlist();
        itemWishlist.setWishlist(wishlist);
        if (itemWishlistService.findById(item.getId()).isPresent()) {

            ItemWishlist foundItemWishlist = itemWishlistService.findById(item.getId()).get();
            itemWishlistService.delete(foundItemWishlist);

            Item foundItem = itemService.findById(foundItemWishlist.getItem().getId()).get();
            foundItem.getItemWishlists().remove(foundItemWishlist);

            Wishlist foundWishlist = findById(foundItemWishlist.getWishlist().getId()).get();
            foundWishlist.getItemWishlists().remove(foundItemWishlist);

        }
        return wishlist;
    }


}
