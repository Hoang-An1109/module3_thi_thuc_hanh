package org.example.module3_thi_thuc_hanh.service.book;

import org.example.module3_thi_thuc_hanh.model.Book;
import org.example.module3_thi_thuc_hanh.model.Student;
import org.example.module3_thi_thuc_hanh.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private Connection connection = ConnectionDB.getConnection();
    private static final String SELECT_ALL_BOOK = "select * from book;";
    private static final String SELECT_BOOK_BY_ID = "select * from book where id = ?;";

    @Override
    public void insertInto(Book book) throws SQLException {

    }

    @Override
    public Book selectById(int id) {
        Book book = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quanlity = rs.getInt("quanlity");

                book = new Book(id, name, author, description, quanlity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public List<Book> selectAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                int quanlity = rs.getInt("quanlity");
                books.add(new Book(id, name, author, description, quanlity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return false;
    }
}
