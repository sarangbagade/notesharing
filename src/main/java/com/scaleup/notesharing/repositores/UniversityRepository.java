package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
