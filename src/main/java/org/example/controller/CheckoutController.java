package org.example.controller;

import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.example.dto.CartItemDTO;
import org.example.dto.CheckoutResponseDTO;
import org.example.dto.StripWebhookDTO;
import org.example.services.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class CheckoutController {
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    private final StripeService stripeService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/stripe/create-checkout-session")
    public CheckoutResponseDTO checkout(final Principal principal, @RequestBody StripWebhookDTO stripWebhookDTO) throws StripeException {
//        SessionCreateParams params = SessionCreateParams.builder()
//                .setSuccessUrl("http://localhost:3000/")
//                .addLineItem(SessionCreateParams.LineItem.builder()
//                        .setPrice("price_1Om91TSClqH6NSAjBRSyUKUl").setQuantity(1L).build())
//                .setMode(SessionCreateParams.Mode.PAYMENT)
//                .build();

        Session session = stripeService.checkOut(stripWebhookDTO.getCartItems().stream().map(CartItemDTO::getId).collect(Collectors.toList()));
        CheckoutResponseDTO responseDTO = new CheckoutResponseDTO();
        responseDTO.setUrl(session.getUrl());
        return responseDTO;
    }
}