package com.charuniverse.invoice.repository;

import com.charuniverse.invoice.entity.InvoiceType;
import com.charuniverse.invoice.entity.RecordStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@SpringBootTest
@Sql(scripts = {
        "/sql/delete-invoice-type.sql",
        "/sql/insert-invoice-type.sql"
})
public class InvoiceTypeRepositoryTests {

    @Autowired
    InvoiceTypeRepository invoiceTypeRepository;

    @Test
    public void testInsertInvoiceType() {
        InvoiceType type = new InvoiceType();
        type.setCode("IT-001");
        type.setName("Invoice Type Test");

        Assertions.assertNull(type.getId());

        invoiceTypeRepository.save(type);

        Assertions.assertNotNull(type.getId());
        Assertions.assertNotNull(type.getCreatedBy());
        Assertions.assertNotNull(type.getCreatedAt());
        Assertions.assertNotNull(type.getUpdatedBy());
        Assertions.assertNotNull(type.getUpdatedAt());
        Assertions.assertEquals(type.getRecordStatus(), RecordStatus.ACTIVE);
    }

    @Test
    public void testUpdateInvoiceType() {
        InvoiceType type = new InvoiceType();
        type.setCode("IT-001");
        type.setName("Invoice Type Test");

        Assertions.assertNull(type.getId());
        invoiceTypeRepository.save(type);
        Assertions.assertNotNull(type.getId());

        type.setName("Updated Invoice Name");
        type.setCode("Updated-Invoice-Code");
        type = invoiceTypeRepository.save(type);

        Assertions.assertNotEquals(type.getCreatedAt(), type.getUpdatedAt());
    }

    @Test
    public void testQuery() {
        Iterable<InvoiceType> allInvoices = invoiceTypeRepository.findAll();
        allInvoices.forEach(invoiceType -> Assertions.assertEquals(invoiceType.getRecordStatus(), RecordStatus.ACTIVE));
    }

    @Test
    public void testSoftDelete() {
        InvoiceType type = new InvoiceType();
        type.setCode("IT-001");
        type.setName("Invoice Type Test");

        Assertions.assertNull(type.getId());
        invoiceTypeRepository.save(type);
        Assertions.assertNotNull(type.getId());

        invoiceTypeRepository.delete(type);
        Optional<InvoiceType> query = invoiceTypeRepository.findById(type.getId());
        Assertions.assertTrue(query.isEmpty());
    }
}