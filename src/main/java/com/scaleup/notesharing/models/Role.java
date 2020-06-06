package com.scaleup.notesharing.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends Auditable{

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    public Role()
    {

    }

    public static final class Builder {
        private String name;
        private String description;

        public Builder() {
        }

        public static Builder aRole() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Role build() {
            Role role = new Role();
            role.name = this.name;
            role.description = this.description;
            return role;
        }
    }
}
