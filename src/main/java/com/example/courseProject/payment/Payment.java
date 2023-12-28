package com.example.courseProject.payment;

import com.example.courseProject.order.Order;
import com.example.courseProject.user.User;
import com.example.courseProject.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @OneToOne(mappedBy = "payment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Order order;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
