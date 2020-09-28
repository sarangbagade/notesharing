package com.scaleup.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "branches")
@NoArgsConstructor
public class Branch {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true)
	@NotBlank
	private String name;

	public Branch(String name) {
		this.name = name;
	}
}
