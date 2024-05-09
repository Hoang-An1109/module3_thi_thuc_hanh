package org.example.module3_thi_thuc_hanh.controller;

import org.example.module3_thi_thuc_hanh.HelloServlet;
import org.example.module3_thi_thuc_hanh.model.Book;
import org.example.module3_thi_thuc_hanh.service.book.BookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/book")
public class BookController extends HelloServlet {
    private BookService bookService=new BookService();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                listBooks(req, resp);
                break;
        }
    }

    private void listBooks(HttpServletRequest req, HttpServletResponse resp) {
        List<Book> bookList = bookService.selectAll();
        req.setAttribute("listBook", bookList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
