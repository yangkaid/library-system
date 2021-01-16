package com.controller;

import com.dao.returnBookDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/returnBookServlet")
public class returnBookServlet extends HttpServlet {
    returnBookDao returnBookDao = new returnBookDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        System.out.println(bookid);
        returnBookDao.returnBook(bookid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
