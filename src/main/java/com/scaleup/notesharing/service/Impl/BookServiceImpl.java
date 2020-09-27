package com.scaleup.notesharing.service.Impl;


import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.Subject;
import com.scaleup.notesharing.repositores.BookRepository;
import com.scaleup.notesharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBySubjectId(Long subjectId) {
        return bookRepository.findBySubjectId(subjectId);
    }

    @Override
    public Book deleteByName(String name) {
        return bookRepository.deleteByName(name);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
