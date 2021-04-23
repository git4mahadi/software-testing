package com.amigoscode.testing.payment;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Optional<Payment> findByPaymentId(Long id);

}
