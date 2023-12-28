package com.example.courseProject.order;

import com.example.courseProject.enums.DeliveryType;
import com.example.courseProject.enums.PaymentType;
import com.example.courseProject.payment.Payment;
import com.example.courseProject.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


public class OrderDTO {


    private Long id;

    private Long userId;

    private String address;

    private Payment payment;

    private PaymentType paymentType;

    private DeliveryType deliveryType;

    private Float priceWithoutDiscount;

    private Byte discount;

    private Float totalPrice;

    private Date dateOfSending;

    private Date dateOfArriving;

    private Date dateOfReceiving;
}
