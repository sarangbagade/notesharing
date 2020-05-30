package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "universities")
public class University extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    private City officeIn;
}
