package com.controller;


import com.common.ResultInfo;
import com.common.User;
import com.service.UserService;
import com.dao.UserServiceImple;
import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;




@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImple();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        // 此方法返回一个Map类型值（Map(key,value[])，即：key是String型，value是String型数组）。
        // 该返回值存储着着前端所提交请求中的所有请求参数和请求参数值的映射关系。
        Map<String, String[]> map = req.getParameterMap();
        //封装User对象,注意这里的BeanUtils
        User user = new User();

        try {
           /* BeanUtils.populate( Object bean, Map properties )，
            这个方法会遍历map<key, value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。*/
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        User u = service.login(user);

        ResultInfo info = new ResultInfo();

        System.out.println("servlet:"+u.getUsername());
        System.out.println("servlet"+u.getPassword());
        System.out.println("输入框的password"+user.getPassword());
        //判断登陆成功
        if (user.getPassword().equals(u.getPassword())) {
            info.setFlag(true);
            info.setUsername(u.getUsername());

        } else {
            System.out.println("登陆失败");
            info.setFlag(false);
        }


        //响应数据，注意ObjectMapper
        //ObjectMapper类是Jackson库的主要类。
        // 它提供一些功能将转换成Java对象匹配JSON结构，
        //主要是用来把对象转换成为一个json字符串返回到前端
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        /*将对象转为json字符串时可以使用ObjectMapper中的两个方法：
        writeValue（参数，obj）：直接将传入的对象序列化为json，并且返回给客户端
        writeValueAsString（obj）：将传入的对象序列化为json，返回给调用者*/
        mapper.writeValue(resp.getOutputStream(), info);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
