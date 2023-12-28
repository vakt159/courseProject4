package com.example.courseProject.order;

import com.example.courseProject.payment.Payment;
import com.example.courseProject.user.User;
import com.example.courseProject.enums.DeliveryType;
import com.example.courseProject.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    private Float priceWithoutDiscount;

    private Byte discount;

    private Float totalPrice;

    private Date dateOfSending;

    private Date dateOfArriving;

    private Date dateOfReceiving;
}
