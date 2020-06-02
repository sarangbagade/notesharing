package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Student extends User{

    private String name;

    private Branch branch;

    @ManyToOne
    @JsonIdentityReference
    private College college;

    private Float rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private Set<Note> notes = new HashSet<>();

    public Student()
    {

    }
}
