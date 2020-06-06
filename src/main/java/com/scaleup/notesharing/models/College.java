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
@Table(name = "colleges")
@Getter
@Setter
public class College extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    @JsonIdentityReference
    private City city;

    @ManyToOne
    @JsonIdentityReference
    @NotNull
    private University university;

    public College()
    {

    }

    public static final class Builder {
        private String name;
        private City city;
        private University university;

        public Builder() {
        }

        public static Builder aCollege() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public Builder university(University university) {
            this.university = university;
            return this;
        }

        public College build() {
            College college = new College();
            college.university = this.university;
            college.city = this.city;
            college.name = this.name;
            return college;
        }
    }
}
