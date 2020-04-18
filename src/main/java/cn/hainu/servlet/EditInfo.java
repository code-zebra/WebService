package cn.hainu.servlet;

import cn.hainu.dao.IInfoDao;
import cn.hainu.dao.IUserDao;
import cn.hainu.dao.impl.InfoDaoImpl;
import cn.hainu.dao.impl.UserDaoImpl;
import cn.hainu.domain.PersonalInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更改用户信息
 * @author Ant
 */
@WebServlet("/editInfo")
public class EditInfo extends HttpServlet {
    IInfoDao infoDao = new InfoDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("更改用户信息......");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=utf-8");

        String username = req.getParameter("username");
        int money = Integer.parseInt(req.getParameter("money"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        PersonalInfo person = new PersonalInfo();
        person.setUsername(username);
        person.setMoney(money);
        person.setName(name);
        person.setPhone(phone);
        person.setEmail(email);
        System.out.println(person);
        if (!infoDao.setPersonalInfo(person)) {
            // 设置204错误码与出错信息
            System.out.println("更改用户信息失败");
            resp.sendError(204,"query failed.");
        }
    }
}
