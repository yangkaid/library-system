package com.controller;

import com.common.User;
import com.dao.userbookDao;
import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/userbookServlet")
public class userbookServlet extends HttpServlet {
    userbookDao userbook = new userbookDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        Map<String, String[]> map = request.getParameterMap();
        //封装UserBook对象,注意这里的BeanUtils
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.getUsername());


        ArrayList list = new ArrayList();
        try {
            list = (ArrayList) userbook.findByUsername(user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //响应数据，注意ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), list);
    }
}
