package ru.sbrf.cu.spring.books.dao.impl;

import ru.sbrf.cu.spring.books.dao.BooksDao;
import ru.sbrf.cu.spring.books.model.Books;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class BooksDaoImpl implements BooksDao {

    private final List<Books> books;
    private final Map<Integer, Books> booksMap;

    public BooksDaoImpl() {
        this.books = new ArrayList<>();
        books.add(new Books(1, "Три товарища", "Ремарк",  383));
        books.add(new Books(2, "Золотой теленок", "Ильф, Петров",  366));
        books.add(new Books(3, "О дивный новый мир", "Хаксли",  351));
        books.add(new Books(4, "Р.А.Б.", "Минаев",  541));

        booksMap = books.stream()
                .collect(Collectors.toMap(Books::getId, Function.identity()));
    }

    @Override
    public List<Books> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public Optional<Books> getById(Integer id) {
        Books book = null;
        for (Books item : books){
            if (id.equals(item.getId())){
                book = item;
                break;
            }
        }
        return Optional.ofNullable(book);
    }

    @Override
    public Books addBook(Books book) {
        books.add(book);
        return null;
    }
}
