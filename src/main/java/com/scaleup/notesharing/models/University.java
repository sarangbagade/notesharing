package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "universities")
@Setter
@Getter
public class University extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @ManyToOne
    @JsonIdentityReference
    private City officeIn;

    public University()
    {

    }

    public static final class Builder {
        private String name;
        private City officeIn;

        public Builder() {
        }

        public static Builder anUniversity() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder officeIn(City officeIn) {
            this.officeIn = officeIn;
            return this;
        }

        public University build() {
            University university = new University();
            university.officeIn = this.officeIn;
            university.name = this.name;
            return university;
        }
    }
}
