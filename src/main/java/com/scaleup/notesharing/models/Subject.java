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
