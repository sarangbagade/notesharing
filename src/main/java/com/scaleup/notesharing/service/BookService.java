package com.scaleup.notesharing.service;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.BookInstance;
import com.scaleup.notesharing.models.Subject;

import java.util.List;

import org.springframework.data.domain.Page;

public interface BookService {

    public Book save(Book book);
    public List<Book> findBySubjectId(Long subjectIds);
    public Book deleteById(long id);
    public Page<Book> findAll(int offset, int limit);
}
