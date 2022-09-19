package com.charuniverse.invoice.repository;

import com.charuniverse.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VirtualAccountRepository extends PagingAndSortingRepository<VirtualAccount, String> {
}
