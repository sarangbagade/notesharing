package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject extends Auditable{

    @Column(unique = true)
    @NotBlank
    private String name;

    @NotNull
    @ManyToOne
    private Branch branch;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    @JsonIdentityReference
    private Set<Book> books = new HashSet<>();

    public Subject()
    {

    }

    public static final class Builder {
        private String name;
        private Branch branch;

        public Builder() {
        }

        public static Builder aSubject() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder branch(Branch branch) {
            this.branch = branch;
            return this;
        }

        public Subject build() {
            Subject subject = new Subject();
            subject.branch = this.branch;
            subject.name = this.name;
            return subject;
        }
    }
}
