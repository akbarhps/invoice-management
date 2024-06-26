package com.charuniverse.invoice.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@SQLDelete(sql = "UPDATE virtual_account SET record_status = 'INACTIVE' WHERE id = ?")
@Where(clause = "record_status = 'ACTIVE'")
public class VirtualAccount extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_payment_provider")
    private PaymentProvider paymentProvider;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    private String companyId;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    private String accountNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VirtualAccountType virtualAccountType = VirtualAccountType.CLOSED;
}
