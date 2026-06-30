package com.tejas.dao;

import com.tejas.database.DatabaseConnection;
import com.tejas.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public void addBook(Book book) {
        String sql = """
            INSERT INTO books(title, author, year, available)
            VALUES (?, ?, ?, ?)
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.setBoolean(4, book.isAvailable());
            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Book added successfully!");
            }
            else{
                System.out.println("Failed to add book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        String sql = """
                SELECT * FROM books
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                boolean available = rs.getBoolean("available");

                Book book = new Book(
                        title,
                        author,
                        year,
                        available
                );
                book.setId(id);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void updateBook(Book book) {
        String sql = """
                UPDATE books SET
                    title = ?,
                    author = ?,
                    year = ?,
                    available = ?
                    WHERE id = ?;
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getYear());
            ps.setBoolean(4, book.isAvailable());
            ps.setInt(5, book.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) {
        String sql = """
                DELETE FROM books
                    WHERE id = ?;
            """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book searchByTitle(String title){
        String sql = """
                SELECT * FROM books WHERE title = ?;
                """;
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                boolean available = rs.getBoolean("available");

                Book book = new Book(bookTitle, author, year, available);
                book.setId(id);

                return book;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Book searchById(int id){
        String sql = """
                SELECT * FROM books WHERE id = ?;
                """;

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int bookId = rs.getInt("id");
                String bookTitle = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                boolean available = rs.getBoolean("available");

                Book book = new Book(bookTitle, author, year, available);
                book.setId(bookId);

                return book;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean bookExists(
            String title,
            String author
    ){
        String sql = """
                SELECT * FROM books
                WHERE title = ?
                AND author = ?
                """;

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, title);
            ps.setString(2, author);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
