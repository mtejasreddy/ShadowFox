package com.tejas.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(
        String title,
        String author,
        int year,
        boolean available
    ) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getYear(){
        return year;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    @Override
    public String toString() {
        return """
            ------------------------------
            Book ID   : %d
            Title     : %s
            Author    : %s
            Year      : %d
            Available : %s
            ------------------------------
            """.formatted(
                id,
                title,
                author,
                year,
                available ? "Yes" : "No"
        );
    }
}
