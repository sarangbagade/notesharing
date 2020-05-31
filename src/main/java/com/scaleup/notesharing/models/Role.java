package com.scaleup.notesharing.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "roles")
public class Role extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;
}
