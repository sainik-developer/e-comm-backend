package org.example.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import jakarta.annotation.PostConstruct;
import org.example.entity.ProductDO;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    String secretKey;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Session checkOut(List<String> productIds) throws StripeException {
        List<ProductDO> productDOS = productIds.stream().map(productRepository::findById).toList();
        List<SessionCreateParams.LineItem> lineItems = productDOS.stream().map(productDO -> SessionCreateParams.LineItem.builder()
                .setPrice(productDO.getStripPrice()).setQuantity(1L).build()).toList();
        SessionCreateParams params = SessionCreateParams.builder()
                .setSuccessUrl("http://localhost:3000/")
                .addAllLineItem(lineItems)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .build();
        return Session.create(params);
    }
}
