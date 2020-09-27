package com.scaleup.notesharing.service.Impl;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.BookInstance;
import com.scaleup.notesharing.service.BookInstanceService;
import com.scaleup.notesharing.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInstanceServiceImpl implements BookInstanceService {

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<BookInstance> findByBook(long bookId) {
        return null;
    }
}
