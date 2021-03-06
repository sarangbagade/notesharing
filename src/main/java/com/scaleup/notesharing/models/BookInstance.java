package com.scaleup.notesharing.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookInstances")
public class BookInstance extends Auditable{

    @ManyToOne
    private Student student;

    @ManyToOne
    private Book book;
    private int quality;
    private int editionYear;
    private int yearsOld;
}
