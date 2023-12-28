package com.example.courseProject.wishlist;

import com.example.courseProject.wishlist.Wishlist;
import com.example.courseProject.wishlist.WishlistService;
import com.example.courseProject.item.Item;
import com.example.courseProject.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping
    public List<Item> showContent(@RequestBody User user)
    {
        return wishlistService.getItems(user);
    }

    @PutMapping("/item/")
    public Wishlist addItem(@RequestBody Wishlist wishlist, @RequestBody Item item){
        return wishlistService.addItem(wishlist,item);
    }

    @DeleteMapping("/item/")
    public Wishlist deleteItem(@RequestBody Wishlist wishlist, @RequestBody Item item){
        return wishlistService.removeItem(wishlist,item);
    }
    @DeleteMapping("/items/")
    public void clear(@RequestBody User user)
    {
        wishlistService.clear(user);
    }


}
