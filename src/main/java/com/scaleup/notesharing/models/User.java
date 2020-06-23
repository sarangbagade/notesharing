package com.scaleup.notesharing.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable{

    @Email
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotBlank
    private String saltedHashedPassword;

    public String getSaltedHashedPassword(){
        return this.saltedHashedPassword;
    }
    public void setSaltedHashedPassword(String value)
    {
        this.saltedHashedPassword = new BCryptPasswordEncoder(5).encode(value);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIdentityReference
    @Getter
    @Setter
    private Set<Role> roles;

    public User()
    {

    }
    public User(User user) {
        email = user.getEmail();
        saltedHashedPassword = user.getSaltedHashedPassword();
        roles = user.getRoles();
    }
}
