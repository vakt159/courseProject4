package com.example.courseProject.itemWishlist;

import com.example.courseProject.item.Item;
import com.example.courseProject.wishlist.Wishlist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class ItemWishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;
}
