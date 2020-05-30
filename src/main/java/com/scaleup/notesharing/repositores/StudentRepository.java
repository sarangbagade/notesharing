package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
