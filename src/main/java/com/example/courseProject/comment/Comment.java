package com.example.courseProject.comment;

import com.example.courseProject.item.Item;
import com.example.courseProject.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String value;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    private Date dateOfCreation;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item item;


}
