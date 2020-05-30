package com.scaleup.notesharing.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;
}
