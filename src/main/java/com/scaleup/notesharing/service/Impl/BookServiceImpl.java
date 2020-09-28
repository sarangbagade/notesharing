package com.scaleup.notesharing.service.Impl;


import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.Subject;
import com.scaleup.notesharing.repositores.BookRepository;
import com.scaleup.notesharing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Book deleteById(long id) {
        return bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAll(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset, limit, Sort.by("id").descending());
    	return bookRepository.findAll(pageable);
    }
}
