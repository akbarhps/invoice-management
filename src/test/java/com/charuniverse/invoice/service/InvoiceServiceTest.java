package com.charuniverse.invoice.service;

import com.charuniverse.invoice.entity.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InvoiceServiceTest {

    @Autowired private InvoiceService invoiceService;

    @Test
    public void testInsertInvoice() {
        Invoice invoice = invoiceService.createInvoice();

    }
}
