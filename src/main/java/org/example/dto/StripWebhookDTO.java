package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class StripWebhookDTO {
    private List<CartItemDTO> cartItems;
    private String userId;
}
