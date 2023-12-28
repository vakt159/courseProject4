package com.example.courseProject.user;

import com.example.courseProject.cart.Cart;
import com.example.courseProject.cart.CartDAO;
import com.example.courseProject.wishlist.Wishlist;
import com.example.courseProject.wishlist.WishlistDAO;
import com.example.courseProject.wishlist.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final CartDAO cartDAO;
    private final WishlistDAO wishlistDAO;

    public UserService(UserDAO userDAO, CartDAO cartDAO, WishlistDAO wishlistDAO) {
        this.userDAO = userDAO;
        this.cartDAO = cartDAO;
        this.wishlistDAO = wishlistDAO;
    }

    public User save(User user) {
        Cart cart =new Cart();
        cart.setUser(user);
        cartDAO.save(cart);
        Wishlist wishlist= new Wishlist();
        wishlist.setUser(user);
        wishlistDAO.save(wishlist);
        return userDAO.save(user);
    }

    public void delete(User entity) {
        Cart cart=entity.getCart();
        cartDAO.delete(cart);
        Wishlist wishlist=entity.getWishlist();
        wishlistDAO.delete(wishlist);
        userDAO.delete(entity);
    }

    public Optional<User> findById(Long aLong) {
        return userDAO.findById(aLong);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

}
