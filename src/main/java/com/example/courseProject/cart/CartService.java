package com.example.courseProject.cart;

import com.example.courseProject.item.Item;
import com.example.courseProject.item.ItemService;
import com.example.courseProject.itemCart.ItemCart;
import com.example.courseProject.itemCart.ItemCartService;
import com.example.courseProject.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartService {
    private final CartDAO cartDAO;
    private final ItemCartService itemCartService;
    private final ItemService itemService;

    public CartService(CartDAO cartDAO, ItemCartService itemCartService, ItemService itemService) {
        this.cartDAO = cartDAO;
        this.itemCartService = itemCartService;
        this.itemService = itemService;
    }

    public Optional<Cart> findById(Long id) {
        if (cartDAO.findById(id).isEmpty())
            return Optional.empty();
        return cartDAO.findById(id);
    }

    public Optional<Cart> findByUser(User user) {
        return null;
    }

    public Cart save(Cart cart) {
        return cartDAO.save(cart);
    }

    public void clear(User user) {
        cartDAO.clear(user.getCart());
    }


    public List<Item> getItems(User user) {
        Cart usersCart=user.getCart();
        if(usersCart==null)
            return null;
        List<ItemCart> itemCartList = usersCart.getItemCarts().stream().
                filter(i -> Objects.equals(i.getCart().getId(), usersCart.getId())).toList();
        return itemCartList.stream().map(ItemCart::getItem).toList();
    }

    public List<Cart> findAll() {
        return cartDAO.findAll();
    }

    public Cart addItem(Cart cart, Item item) {
        ItemCart itemCart = new ItemCart();
        itemCart.setCart(cart);
        if (itemCartService.findById(item.getId()).isPresent()) {
            ItemCart foundItemCart = itemCartService.findById(item.getId()).get();
            foundItemCart.setItemCount(foundItemCart.getItemCount() + 1);
            itemCartService.save(foundItemCart);
        }
        itemCart.setItem(item);
        itemCart.setItemCount(1);
        itemCartService.save(itemCart);
        return cart;
    }

    public Cart removeItem(Cart cart, Item item) {
        ItemCart itemCart = new ItemCart();
        itemCart.setCart(cart);
        if (itemCartService.findById(item.getId()).isPresent()) {

            ItemCart foundItemCart = itemCartService.findById(item.getId()).get();
            itemCartService.delete(foundItemCart);

            Item foundItem = itemService.findById(foundItemCart.getItem().getId()).get();
            foundItem.getItemCarts().remove(foundItemCart);

            Cart foundCart = findById(foundItemCart.getCart().getId()).get();
            foundCart.getItemCarts().remove(foundItemCart);

        }
        return cart;
    }


}
