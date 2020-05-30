package com.scaleup.notesharing.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Note extends Auditable{

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private Integer price;

    @ManyToOne
    @NotNull
    private Student student;

    @ManyToOne
    private Subject subject;

    private String imageUrl;
}
