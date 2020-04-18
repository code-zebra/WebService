package cn.hainu.dao.impl;

import cn.hainu.dao.IUserDao;
import cn.hainu.domain.PersonalInfo;
import cn.hainu.domain.User;
import cn.hainu.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ant
 */
public class UserDaoImpl implements IUserDao {


    @Override
    public boolean query(User user) {
        Connection connection = DBUtils.getConnection();
        System.out.println("query......");
        String sql = "SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?";
        try{
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, user.getName());
            prep.setString(2, user.getPassword());
            ResultSet resultSet = prep.executeQuery();
            System.out.println(resultSet.getFetchSize());
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtils.closeConnection();
        }
    }

    @Override
    public boolean findUsername(String username) {
        Connection connection = DBUtils.getConnection();
        System.out.println("findUsername......");
        String sql = "SELECT * FROM USER WHERE NAME = ?";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1,username);
            ResultSet resultSet = prep.executeQuery();
            System.out.println(resultSet.next());
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtils.closeConnection();
        }

    }

    @Override
    public boolean setPersonalInfo(String username) {
        Connection connection = DBUtils.getConnection();
        System.out.println("save userinfo......");
        String sql = "INSERT INTO personal_info(username) VALUES (?)";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, username);
            prep.executeUpdate();
            return prep.getUpdateCount() != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }



    @Override
    public boolean add(User user) {
        Connection connection = DBUtils.getConnection();
        System.out.println("add......");
        String sql = "INSERT INTO USER(name, password) VALUES(?,?)";
        try{
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, user.getName());
            prep.setString(2, user.getPassword());
            prep.executeUpdate();
            return prep.getUpdateCount() != 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtils.closeConnection();
        }

    }

}
