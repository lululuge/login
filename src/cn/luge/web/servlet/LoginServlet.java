package cn.luge.web.servlet;

import cn.luge.dao.UserDao;
import cn.luge.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码方式
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        // 调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user == null) {
            // 登录失败，跳转FailServlet
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }
        else {
            // 登录成功
            // 存储数据
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
            // 跳转SuccessServlet


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
