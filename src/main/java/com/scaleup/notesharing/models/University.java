package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "universities")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class University extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @ManyToOne
    @JsonIdentityReference
    private City officeIn;

    public University()
    {

    }
}
