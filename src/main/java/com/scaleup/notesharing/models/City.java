package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cities")
public class City extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;


}
