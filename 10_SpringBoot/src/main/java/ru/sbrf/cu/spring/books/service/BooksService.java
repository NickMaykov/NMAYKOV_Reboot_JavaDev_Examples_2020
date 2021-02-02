package ru.sbrf.cu.spring.books.service;

import java.util.List;
import ru.sbrf.cu.spring.books.model.Books;

public interface BooksService {
    List<Books> getAllBooks();
    String getBook(Integer id);
    Books addBook(Books book);
}
