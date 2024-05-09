package org.example.module3_thi_thuc_hanh.controller;

import org.example.module3_thi_thuc_hanh.model.Book;
import org.example.module3_thi_thuc_hanh.model.BorrowCard;
import org.example.module3_thi_thuc_hanh.model.Student;
import org.example.module3_thi_thuc_hanh.service.book.BookService;
import org.example.module3_thi_thuc_hanh.service.borrowCard.BorrowCardService;
import org.example.module3_thi_thuc_hanh.service.student.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BorrowCardServlet", urlPatterns = "/borrowCard")
public class BorrowCardController extends HttpServlet {
    private BookService bookService = new BookService();
    private BorrowCardService borrowCardService = new BorrowCardService();
    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            default:
                break;
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.selectById(id);
        List<Student> students = studentService.selectAll();
        req.setAttribute("book", book);
        req.setAttribute("student", students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("borrowCard/create.jsp");

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertBorrowCard(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void insertBorrowCard(HttpServletRequest req, HttpServletResponse resp) {
        int id_book = Integer.parseInt(req.getParameter("id"));
        int id_student = Integer.parseInt(req.getParameter("id_student"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Date borrowDate = null;
        Date returnDate=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            borrowDate = dateFormat.parse(req.getParameter("borrow_date"));
            returnDate=dateFormat.parse(req.getParameter("borrow_date"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Book book = new Book(id_book);
        Student student = new Student(id_student);

        BorrowCard borrowCard = new BorrowCard(book, student,status, borrowDate, returnDate);
        try {
            borrowCardService.insertInto(borrowCard);
            req.setAttribute("message", "New borrow card was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("borrowCard/create.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
