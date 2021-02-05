package ru.sbrf.cu.spring.books.service.impl;

import org.springframework.stereotype.Service;
import ru.sbrf.cu.spring.books.dao.BooksDao;
import ru.sbrf.cu.spring.books.dao.impl.BooksDaoImpl;
import ru.sbrf.cu.spring.books.model.Books;
import ru.sbrf.cu.spring.books.service.BooksService;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksDao booksDao;

    public BooksServiceImpl(BooksDao dao) {
        this.booksDao = dao;
    }

    @Override
    public List<Books> getAllBooks() {
        return booksDao.getAllBooks();
    }

    @Override
    public String getBook(Integer id) {
        return booksDao.getById(id)
                       .map(Books::getName)
                       .orElse("Книги нет!");
    }

    @Override
    public Books addBook(Books book) {
        booksDao.addBook(book);
        return null;
    }
}
