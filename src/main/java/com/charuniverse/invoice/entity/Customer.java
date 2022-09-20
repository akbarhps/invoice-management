package com.charuniverse.invoice.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@SQLDelete(sql = "UPDATE customer SET record_status = 'INACTIVE' WHERE id = ?")
@Where(clause = "record_status = 'ACTIVE'")
public class Customer extends BaseEntity {

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String code;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String mobilePhone;

}
