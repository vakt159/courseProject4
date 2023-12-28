package com.example.courseProject.user;

import com.example.courseProject.cart.Cart;
import com.example.courseProject.comment.Comment;
import com.example.courseProject.enums.Role;
import com.example.courseProject.order.Order;
import com.example.courseProject.payment.Payment;
import com.example.courseProject.wishlist.Wishlist;

import java.util.List;

public class UserDTO {
    private Long id;

    private String email;

    private String password;

    private Role role;

    private String phone;

    private String firstName;

    private String lastName;

    private Long cartId;

    private Long wishlistId;

    private String address;

    private List<Long> paymentsId;

    private List<Long> orderListId;

    private List<Long> commentsId;
}
