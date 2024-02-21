package org.example.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Session checkOut() throws StripeException {
        SessionCreateParams params = SessionCreateParams.builder()
                .setSuccessUrl("http://localhost:3000/")
                .addLineItem(SessionCreateParams.LineItem.builder()
                        .setPrice("price_1Om91TSClqH6NSAjBRSyUKUl").setQuantity(1L).build())
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .build();
        return Session.create(params);
    }
}
