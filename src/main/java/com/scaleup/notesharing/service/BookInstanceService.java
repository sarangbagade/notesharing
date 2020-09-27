package com.scaleup.notesharing.service;

import com.scaleup.notesharing.models.Book;
import com.scaleup.notesharing.models.BookInstance;

import java.util.List;

public interface BookInstanceService {

    public Book save(Book book);

    public List<BookInstance> findByBook(long bookId);
}
