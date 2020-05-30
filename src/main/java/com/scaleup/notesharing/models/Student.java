package com.scaleup.notesharing.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Auditable{

    private String name;

    private Branch branch;

    @ManyToOne
    private College college;

    private Float rating;

    @OneToMany
    private Set<Note> notes;
}
