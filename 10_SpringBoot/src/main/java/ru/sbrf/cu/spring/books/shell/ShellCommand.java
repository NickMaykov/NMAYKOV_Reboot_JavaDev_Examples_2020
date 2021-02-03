package ru.sbrf.cu.spring.books.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.sbrf.cu.spring.books.dao.BooksDao;
import ru.sbrf.cu.spring.books.dao.impl.BooksDaoImpl;
import ru.sbrf.cu.spring.books.model.Books;
import ru.sbrf.cu.spring.books.service.BooksService;
import ru.sbrf.cu.spring.books.service.impl.BooksServiceImpl;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {
    private final BooksService service;
    private final BooksDaoImpl daoImpl;

    private String isOpen;

    @ShellMethod(value = "Open library", key = {"open"})
    public void Books(){
        daoImpl.BooksDaoImpl();
        isOpen = "Y";
    }


    @ShellMethod(value = "Show books", key = {"show", "showAll", "all"})
    @ShellMethodAvailability(value = "isOpenCommandAvailable")
    public List<Books> getAllBooks() {
        return service.getAllBooks();
    }

    @ShellMethod(value = "Add book", key = {"add", "addbook"})
    @ShellMethodAvailability(value = "isOpenCommandAvailable")
    public Books addBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Добавление книги: ");
        System.out.println("Введите номер: ");
        int id = s.nextInt();
        System.out.println("Введите название: ");
        String name = s.next();
        System.out.println("Введите автора: ");
        String author = s.next();
        System.out.println("Введите кол-во страниц: ");
        int numPages = s.nextInt();
        return service.addBook(new Books(id, name, author, numPages));
    }
    @ShellMethod(value = "Find books", key = {"find", "get"})
    @ShellMethodAvailability(value = "isOpenCommandAvailable")
    public String getBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Поиск книги: ");
        System.out.println("Введите номер: ");
        int id = s.nextInt();
        return service.getBook(id);
    }

    private Availability isOpenCommandAvailable() {
        return isOpen != "Y"? Availability.unavailable("Сначала открой библиотеку командой open !"): Availability.available();
    }
}
