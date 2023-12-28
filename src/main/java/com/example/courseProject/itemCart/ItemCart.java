package com.example.courseProject.itemCart;

import com.example.courseProject.cart.Cart;
import com.example.courseProject.item.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ItemCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Integer itemCount;
}
