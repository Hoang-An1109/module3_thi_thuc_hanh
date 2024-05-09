package org.example.module3_thi_thuc_hanh.service.borrowCard;

import org.example.module3_thi_thuc_hanh.model.BorrowCard;
import org.example.module3_thi_thuc_hanh.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BorrowCardService implements IBorrowCardService {
    private Connection connection = ConnectionDB.getConnection();
    private static final String INSERT_BORROW_CARD_SQL = "insert into borrow_card(id_book,id_student,status,borrow_date,return_date) values ( ?, ?, ?, ?, ?);";
    private static final String UPDATE_BOOK_SQL = "update book set quanlity = quanlity - 1 where id = ?;";
    private static final String SELECT_ALL_BORROW_CARD = "select * from book;";

    @Override
    public void insertInto(BorrowCard borrowCard) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_BORROW_CARD_SQL);
        statement.setInt(1, borrowCard.getId_book().getId());
        statement.setInt(2, borrowCard.getId_student().getId());
        statement.setBoolean(3, borrowCard.isStatus());
        java.util.Date borrowDate = borrowCard.getBorrowDate();
        java.sql.Date dateBorrow = new java.sql.Date(borrowDate.getTime());
        statement.setDate(4, dateBorrow);
        java.util.Date returnDate = borrowCard.getReturnDate();
        java.sql.Date dateReturn = new java.sql.Date(returnDate.getTime());
        statement.setDate(5, dateReturn);
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(UPDATE_BOOK_SQL);
        statement1.setInt(1, borrowCard.getId_book().getId());
        statement1.executeUpdate();
    }

    @Override
    public BorrowCard selectById(int id) {
        return null;
    }

    @Override
    public List<BorrowCard> selectAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BorrowCard borrowCard) throws SQLException {
        return false;
    }
}
