package com.example.courseProject.cart;

import com.example.courseProject.itemCart.ItemCart;
import com.example.courseProject.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<ItemCart> itemCarts;

}
