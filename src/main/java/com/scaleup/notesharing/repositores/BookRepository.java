package com.scaleup.notesharing.repositores;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findBySubjectId(Long subject);
    public Book deleteById(long id);
}
