package com.example.courseProject.cart;

import com.example.courseProject.item.Item;
import com.example.courseProject.item.ItemService;
import com.example.courseProject.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/items/")
    public List<Item> showContent(@RequestBody User user)
    {
        return cartService.getItems(user);
    }

    @PutMapping("/item/")
    public Cart addItem(@RequestBody Cart cart, @RequestBody Item item){
        return cartService.addItem(cart,item);
    }

    @DeleteMapping("/item/")
    public Cart deleteItem(@RequestBody Cart cart, @RequestBody Item item){
        return cartService.removeItem(cart,item);
    }
    @DeleteMapping("/items/")
    public void clear(@RequestBody User user)
    {
        cartService.clear(user);
    }


}
