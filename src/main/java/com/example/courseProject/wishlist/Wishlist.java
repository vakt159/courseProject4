package com.example.courseProject.wishlist;


import com.example.courseProject.itemWishlist.ItemWishlist;
import com.example.courseProject.user.User;
import com.example.courseProject.item.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "wishlist",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "wishlist")
    private List<ItemWishlist> itemWishlists;



}
