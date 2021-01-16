package com.controller;

import com.common.ResultInfo;
import com.common.manager;
import com.dao.managerDao;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manegerServlet")
public class manegerServlet extends HttpServlet {
    managerDao managerDao = new managerDao();
    manager man = new manager();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码,要注意在html表单上要设置name=username等，否则会有错误
        man.setUsername(request.getParameter("username"));
        man.setPassword(request.getParameter("password"));
        System.out.println(man.getUsername());
        manager manager = managerDao.login(man.getUsername());


        ResultInfo info = new ResultInfo();

        //判断登陆成功
        if (man.getPassword().equals(manager.getPassword())) {
            info.setFlag(true);

        } else {
            System.out.println("登陆失败");
            info.setFlag(false);
        }


        //响应数据，注意ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), info);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
