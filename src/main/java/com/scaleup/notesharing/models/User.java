package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public abstract class User extends Auditable{

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String saltedHashedPassword;

}
