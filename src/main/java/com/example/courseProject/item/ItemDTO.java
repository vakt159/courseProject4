package com.example.courseProject.item;

import com.example.courseProject.comment.Comment;
import com.example.courseProject.itemCart.ItemCart;
import com.example.courseProject.itemWishlist.ItemWishlist;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


public class ItemDTO {

    private Long id;
    private String name;
    private String description;
    private Float price;
    private List<Long> itemCartsId;
    private List<Long> itemWishlistsId;
    private Float rating;
    private List<Long> commentsId;
    private Boolean available;
    private Integer quantity;
    private String category;
}
