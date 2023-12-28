package com.example.courseProject.item;

import com.example.courseProject.comment.Comment;
import com.example.courseProject.itemCart.ItemCart;
import com.example.courseProject.itemWishlist.ItemWishlist;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Float price;

    @OneToMany(mappedBy="item")
    private List<ItemCart> itemCarts;

    @OneToMany(mappedBy = "item")
    private List<ItemWishlist> itemWishlists;

    private Float rating;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private Boolean available;

    private Integer quantity;

    private String category;
}
