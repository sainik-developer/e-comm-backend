package org.example.dto;


import lombok.Data;

@Data
public class ChargeRequestDTO {

    private String description;
    private int amount;
    private String stripeEmail;
    private String stripeToken;
}
