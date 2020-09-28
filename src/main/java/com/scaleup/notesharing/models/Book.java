package com.scaleup.notesharing.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
	@GeneratedValue
	private long id;
	private String name;
	private String author;
	@ManyToOne
	private Subject subject;
}
