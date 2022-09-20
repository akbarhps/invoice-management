package com.charuniverse.invoice.repository;

import com.charuniverse.invoice.entity.PaymentProvider;
import com.charuniverse.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface VirtualAccountRepository extends PagingAndSortingRepository<VirtualAccount, String> {
    Optional<VirtualAccount> findByPaymentProviderAndCompanyIdAndAccountNumber(PaymentProvider paymentProvider, String companyId, String accountNumber);
}
