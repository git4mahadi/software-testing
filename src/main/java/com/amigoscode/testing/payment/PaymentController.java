package com.amigoscode.testing.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping
    public void makePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.chargeCard(paymentRequest.getPayment().getCustomerId(), paymentRequest);
    }

    @GetMapping("/{paymentId}")
    public Payment findPaymentByPaymentId(@PathVariable ("paymentId") Long paymentId) {
        return paymentService.findByPaymentId(paymentId)
                .orElseThrow(()-> new IllegalArgumentException(String.format(
                        "No payment found with id [%s]", paymentId
                )));
    }

}
