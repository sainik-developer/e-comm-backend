package org.example.dto;


import lombok.Data;

@Data
public class CartItemDTO {
    private String id;
    private String name;
    private String image;
    private String desc;
    private double price;
    private int cartQuantity;
}
