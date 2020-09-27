package com.scaleup.notesharing.service;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.BookInstance;
import com.scaleup.notesharing.models.Subject;

import java.util.List;

public interface BookService {

    public Book save(Book book);
    public List<Book> findBySubjectId(Long subjectIds);
    public Book deleteByName(String name);
    public List<Book> findAll();
}
