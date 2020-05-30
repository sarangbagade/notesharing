package com.scaleup.notesharing.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
public class Subject extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Branch branch;
}
