package cn.hainu.servlet;

import cn.hainu.dao.IInfoDao;
import cn.hainu.dao.IUserDao;
import cn.hainu.dao.impl.InfoDaoImpl;
import cn.hainu.dao.impl.UserDaoImpl;
import cn.hainu.domain.PersonalInfo;
import cn.hainu.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    IInfoDao infoDao = new InfoDaoImpl();
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

        String username = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name:" + username + "   -password:" + password);

        User user = new User();
        user.setName(username);
        user.setPassword(password);

        // 若查询失败
        if(!userDao.query(user))
        {
            // 设置204错误码与出错信息
            System.out.println("未查找到");
            resp.sendError(204,"query failed.");
        }
        // 查询成功，即登录成功
        else {
            /**
             * 获取对应PersonalInfo对象，写回到response中
             *  从MySQL中查询对象，封装到PersonalInfo对象中？
             *
             */
            PersonalInfo person = infoDao.findPersonalInfo(username);
            ObjectMapper mapper = new ObjectMapper();
            resp.setContentType("application/json;charset=utf-8");
            mapper.writeValue(resp.getOutputStream(), person);
        }

    }
}
