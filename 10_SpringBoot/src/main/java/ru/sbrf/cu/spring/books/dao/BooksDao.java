package ru.sbrf.cu.spring.books.dao;

import ru.sbrf.cu.spring.books.model.Books;
import java.util.List;
import java.util.Optional;

public interface BooksDao {
    List<Books> getAllBooks();
    Optional<Books> getById(Integer id);
    Books addBook(Books book);
}
