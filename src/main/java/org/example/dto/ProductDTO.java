package org.example.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private String image;
    private String desc;
    private int price;
}
