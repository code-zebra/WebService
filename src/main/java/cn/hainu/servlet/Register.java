package cn.hainu.servlet;

import cn.hainu.dao.IUserDao;
import cn.hainu.dao.impl.UserDaoImpl;
import cn.hainu.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ant
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    IUserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");

        System.out.println("查询中......");

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        // 此处可能出现同一用户名不同密码情况，需改正
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        if (userDao.add(user)) {
            resp.sendError(204,"query failed.");
        }
    }
}
