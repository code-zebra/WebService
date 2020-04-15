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

@WebServlet("/login")
public class Login extends HttpServlet {
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

        System.out.println(name);
        System.out.println(password);
        User user = new User();
        user.setName(user.getName());
        user.setPassword(user.getPassword());

        // 若查询失败
        if(!userDao.query(user))
        {
            // 设置204错误码与出错信息
            resp.sendError(204,"query failed.");
        }

    }
}
