package main.controllers;

import lombok.extern.slf4j.Slf4j;
import main.exceptions.NotEnoughMoneyException;
import main.model.ErrorDetails;
import main.model.PaymentDetails;
import main.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDetails paymentDetails) {
        log.info("Received payment {}", paymentDetails.getAmount());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}
