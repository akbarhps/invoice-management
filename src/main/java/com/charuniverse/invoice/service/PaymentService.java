package com.charuniverse.invoice.service;

import com.charuniverse.invoice.entity.PaymentProvider;
import com.charuniverse.invoice.entity.VirtualAccount;
import com.charuniverse.invoice.exception.VirtualAccountAlreadyPaidException;
import com.charuniverse.invoice.exception.VirtualAccountNotFoundException;
import com.charuniverse.invoice.repository.VirtualAccountRepository;
import com.charuniverse.invoice.util.VirtualAccountUtil;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class PaymentService {

    private VirtualAccountRepository virtualAccountRepository;

    public void pay(PaymentProvider paymentProvider,
                    String companyId, String accountNumber,
                    BigDecimal amount, String reference)
            throws VirtualAccountNotFoundException, VirtualAccountAlreadyPaidException {

        // 1. cek apakah va ada?
        VirtualAccount virtualAccount = VirtualAccountUtil
                .checkIfExist(virtualAccountRepository, paymentProvider, companyId, accountNumber);

        // 2. cek apakah va sudah lunas?
        if (virtualAccount.getInvoice().getIsPaid()) {
            throw new VirtualAccountAlreadyPaidException(companyId, accountNumber, paymentProvider.getCode());
        }

        // 3. cek apakah amount pembayaran valid
    }

}
