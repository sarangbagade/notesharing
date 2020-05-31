package com.scaleup.notesharing.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    //@NotBlank
    private Branch branch;

//    public Subject()
//    {
//
//    }
}
