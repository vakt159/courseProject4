package com.example.courseProject.user;

import com.example.courseProject.cart.Cart;
import com.example.courseProject.comment.Comment;
import com.example.courseProject.item.Item;
import com.example.courseProject.order.Order;
import com.example.courseProject.enums.Role;
import com.example.courseProject.payment.Payment;
import com.example.courseProject.wishlist.Wishlist;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String phone;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    private List<Comment> comments;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
