package com.example.courseProject.cart;


import com.example.courseProject.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long id;
    private String userEmail;
    private List<Long> itemCartsIDs;



}
