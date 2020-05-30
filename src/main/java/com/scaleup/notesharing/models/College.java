package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "colleges")
public class College extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    private City city;

    @ManyToOne
    @NotNull
    private University university;
}
