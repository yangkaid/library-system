package com.controller;

import com.dao.addBookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//在servlet3.0之后，加上webServlet注解可以直接修改servlet的属性
@WebServlet("/addBookServlet")
     /*  1.继承HttpServlet抽象类
        2.重写HttpServlet的部分方法，如doGet()或doPost()方法
        3.获取HTTP请求信息。通过HttpServletRequest对象来检索HTML表单所提交的数据或URL上的查询字符串
        4.生成HTTP响应结果。通过HttpServletResponse对象生成响应结果*/
public class addBookServlet extends HttpServlet {
    addBookDao addbook = new addBookDao();

/*   ①form表单中的action属性和method属性
        A.action属性：值——对应数据要提交到服务器的路径
        B.method属性：有get和post两个取值,表示数据提交的方式
    ②HttpServlet通过name属性获取用户输入的数据
    ③通过请求对象的getParameter()方法可以获取用户提交的数据
    ④由HttpServlet的子类转向页面有重定向和转发两种方式*/

    //form表单是post则调用doPost（）方法，get则调用doGet（）方法，如果不写，默认为doGet方法，所以，一般情况下，doGet（）和doPost（）是有一个要被执行的：
    //如果需要同时实现doGet 和doPost方式的Servlet，通常会只在doGet方法中实现处理过程，二在doPost方法直接调用doGet方法
    //这样写的好处是不论前端用get还是postservlet都能正确执行
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bid = Integer.parseInt(request.getParameter("bookid"));
        String username = request.getParameter("username");
        addbook.setBybookid(bid,username);
    }
}
