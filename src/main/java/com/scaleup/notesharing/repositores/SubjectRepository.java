package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
