package com.charuniverse.invoice.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@SQLDelete(sql = "UPDATE invoice SET record_status = 'INACTIVE' WHERE id = ?")
@Where(clause = "record_status = 'ACTIVE'")
public class Invoice extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_invoice_type")
    private InvoiceType invoiceType;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String invoiceNumber;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    @NotNull
    private Boolean isPaid = false;
}
