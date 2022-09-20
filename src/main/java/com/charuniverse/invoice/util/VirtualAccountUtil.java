package com.charuniverse.invoice.util;

import com.charuniverse.invoice.entity.PaymentProvider;
import com.charuniverse.invoice.entity.VirtualAccount;
import com.charuniverse.invoice.exception.VirtualAccountNotFoundException;
import com.charuniverse.invoice.repository.VirtualAccountRepository;

public class VirtualAccountUtil {

    public static VirtualAccount checkIfExist(VirtualAccountRepository repository,
                                              PaymentProvider paymentProvider,
                                              String companyId, String accountNumber)
            throws VirtualAccountNotFoundException {

        return repository
                .findByPaymentProviderAndCompanyIdAndAccountNumber(paymentProvider, companyId, accountNumber)
                .orElseThrow(() -> new VirtualAccountNotFoundException(companyId, accountNumber, paymentProvider.getCode()));
    }
}
