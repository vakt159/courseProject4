package com.example.courseProject.payment;

import com.example.courseProject.enums.OrderStatus;
import com.example.courseProject.order.Order;
import com.example.courseProject.user.User;


public class PaymentDTO {

    private Long id;
    private User user;
    private Order order;
    private OrderStatus orderStatus;
}
