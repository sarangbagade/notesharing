package com.scaleup.notesharing.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class City extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    public City()
    {

    }
    public City(String name)
    {
        this.name = name;
    }
}
