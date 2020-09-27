package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student extends User{

    @NotBlank
    private String name;

    @ManyToOne
    @JsonIdentityReference
    private Branch branch;

    @URL
    private String profilePicUrl;

    @ManyToOne
    @JsonIdentityReference
    private College college;

    private Float rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private Set<Note> notes = new HashSet<>();

    public Student()
    {

    }

    private Student(Builder builder)
    {
        this.setName(builder.name);
        setBranch(builder.branch);
        setProfilePicUrl(builder.profilePicUrl);
        setCollege(builder.college);
        setEmail(builder.email);
        setSaltedHashedPassword(builder.saltedHashedPassword);
    }

    public static final class Builder {
        private @NotBlank String name;
        private Branch branch;
        private String profilePicUrl;
        private College college;
        private String email;
        private String saltedHashedPassword;

        public Builder() {
        }

        public static Builder aStudent() {
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

        public Builder profilePicUrl(String profilePicUrl) {
            this.profilePicUrl = profilePicUrl;
            return this;
        }

        public Builder college(College college) {
            this.college = college;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder saltedHashedPassword(String saltedHashedPassword) {
            this.saltedHashedPassword = saltedHashedPassword;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
