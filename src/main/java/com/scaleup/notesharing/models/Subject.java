package com.scaleup.notesharing.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue
	private long id;

	@Column(unique = true)
	@NotBlank
	private String name;

	@NotNull
	@ManyToOne
	private Branch branch;

	
}
