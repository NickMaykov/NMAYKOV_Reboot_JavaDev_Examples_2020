package ru.sbrf.cu.spring.books.model;

public class Books {
    private Integer id;
    private String name;
    private String author;
    private Integer numPages;

    public Books(Integer id, String name, String author, Integer numPages) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.numPages = numPages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }
}
