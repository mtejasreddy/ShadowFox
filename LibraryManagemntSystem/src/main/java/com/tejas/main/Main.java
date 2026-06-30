package com.tejas.main;

import com.tejas.dao.BookDAO;
import com.tejas.database.DatabaseConnection;
import com.tejas.database.DatabaseInitializer;
import com.tejas.model.Book;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        BookDAO dao = new BookDAO();

        while(running){
            System.out.println("=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");

            System.out.print("Enter your Choice: ");
            int choice;
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
            }
            else{
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            switch(choice){
                case 1:
                    System.out.println("Enter the book Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter the book Author: ");
                    String author = sc.nextLine();
                    System.out.println("Enter the book year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    boolean available = true;
                    Book book = new Book(
                            title,
                            author,
                            year,
                            available
                    );

                    if(dao.bookExists(title, author)){
                        System.out.println("Book Aleady exists!");
                    } else {
                        dao.addBook(book);
                    }
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    if(books.isEmpty()){
                        System.out.println("No Books found!");
                    } else {
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                        break;

                case 3:
                    System.out.println("Enter the Book Title: ");
                    title = sc.nextLine();
                    Book foundBook = dao.searchByTitle(title);

                    if (foundBook == null){
                        System.out.println("Book not Found!.");
                    } else {
                        System.out.println(foundBook);
                    }
                    break;

                case 4:
                    System.out.println("Enter the book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Book searchBook = dao.searchById(id);

                    if(searchBook == null){
                        System.out.println("Book not found!.");
                    } else {
                        System.out.println("Enter new title:");
                        String newTitle = sc.nextLine();

                        System.out.println("Enter new author:");
                        String newAuthor = sc.nextLine();

                        System.out.println("Enter new year:");
                        int newYear = sc.nextInt();
                        sc.nextLine();

                        searchBook.setTitle(newTitle);
                        searchBook.setAuthor(newAuthor);
                        searchBook.setYear(newYear);
                        dao.updateBook(searchBook);
                    }
                    break;

                case 5:
                    System.out.println("Enter the Book ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Book bookToDelete = dao.searchById(id);

                    if(bookToDelete == null){
                        System.out.println("Book not found!.");
                    } else {
                        dao.deleteBook(bookToDelete.getId());
                    }
                    break;

                case 6:
                    System.out.println("Enter the book Id to borrow: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Book bookToBorrow = dao.searchById(id);

                    if(bookToBorrow == null){
                        System.out.println("Book not Found!");
                    } else {
                        if(!bookToBorrow.isAvailable()){
                            System.out.println("Book is already Borrowed");
                        } else {
                            bookToBorrow.setAvailable(false);
                            dao.updateBook(bookToBorrow);
                            System.out.println("Book is Borrowed Successfully");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Enter the Book Id to return: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    Book bookToReturn = dao.searchById(id);
                    if(bookToReturn == null){
                        System.out.println("Book not Found!");
                    } else if (bookToReturn.isAvailable()) {
                        System.out.println("Book is already present in Library!");
                    }
                    else {
                        bookToReturn.setAvailable(true);
                        dao.updateBook(bookToReturn);
                        System.out.println("Book Returned Successfully!");
                        }
                    break;

                case 8:
                    System.out.println("Thank you for using Library Management System!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}