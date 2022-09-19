package com.charuniverse.invoice.repository;

import com.charuniverse.invoice.entity.InvoiceType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceTypeRepository extends PagingAndSortingRepository<InvoiceType, String> {
}
