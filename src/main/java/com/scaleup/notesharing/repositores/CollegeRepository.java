package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
