package com.scaleup.notesharing.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private College college;

    private Float rating;

    @OneToMany
    private Set<Note> notes;

    public Student()
    {

    }
}
