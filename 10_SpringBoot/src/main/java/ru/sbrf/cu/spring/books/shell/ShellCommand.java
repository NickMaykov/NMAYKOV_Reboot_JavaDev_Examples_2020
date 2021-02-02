package ru.sbrf.cu.spring.books.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.sbrf.cu.spring.books.model.Books;
import ru.sbrf.cu.spring.books.service.BooksService;
import ru.sbrf.cu.spring.books.service.impl.BooksServiceImpl;

import java.util.List;
import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ShellCommand {
    private BooksService service = new BooksServiceImpl();

    @ShellMethod(value = "Show books", key = {"show", "showAll", "all"})
    public List<Books> getAllBooks() {
        return service.getAllBooks();
    }

    @ShellMethod(value = "Add book", key = {"add", "addbook"})
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
    public String getBook() {
        Scanner s = new Scanner(System.in);
        System.out.println("Поиск книги: ");
        System.out.println("Введите номер: ");
        int id = s.nextInt();
        return service.getBook(id);
    }
}
