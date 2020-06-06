package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
@Getter
@Setter
public class Note extends Auditable{

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private Integer price;

    @ManyToOne
    @NotNull
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JsonIdentityReference
    private Subject subject;

    private String imageUrl;

    public Note(){

    }

    public static final class Builder {
        private @NotBlank String name;
        private String description;
        private @NotNull Integer price;
        private @NotNull Student student;
        private Subject subject;
        private String imageUrl;

        public Builder() {
        }

        public static Builder aNote() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String desc){
            this.description = desc;
            return this;
        }

        public Builder price(Integer price) {
            this.price = price;
            return this;
        }

        public Builder student(Student student) {
            this.student = student;
            return this;
        }

        public Builder subject(Subject subject) {
            this.subject = subject;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Note build() {
            Note note = new Note();
            note.student = this.student;
            note.imageUrl = this.imageUrl;
            note.name = this.name;
            note.description = this.description;
            note.subject = this.subject;
            note.price = this.price;
            return note;
        }
    }
}
