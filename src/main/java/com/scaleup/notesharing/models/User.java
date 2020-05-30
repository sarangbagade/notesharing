package com.scaleup.notesharing.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable{

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String saltedHashedPassword;

}
