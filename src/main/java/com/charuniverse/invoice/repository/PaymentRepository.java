package com.charuniverse.invoice.repository;

import com.charuniverse.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, String> {
}
