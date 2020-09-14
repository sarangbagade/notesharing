package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "branches")
public class Branch extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    public Branch()
    {

    }

    public Branch(String name)
    {
        this.name = name;
    }
}
