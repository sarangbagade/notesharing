package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.Auditable;
import com.scaleup.notesharing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
