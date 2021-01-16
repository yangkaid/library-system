package com.controller;

import com.common.userBook;
import com.dao.maneAddBookDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/maneAddBookServlet")
public class maneAddBookServlet extends HttpServlet {
    maneAddBookDao maneAddBookDao = new maneAddBookDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取HTML里的book对象
        Map<String, String[]> map = request.getParameterMap();
        userBook userBook = new userBook();
        try {
            BeanUtils.populate(userBook, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(userBook.getBookname());
        maneAddBookDao.addbook(userBook);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
