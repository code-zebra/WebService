package cn.hainu.dao.impl;

import cn.hainu.dao.IInfoDao;
import cn.hainu.domain.PersonalInfo;
import cn.hainu.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ant
 */
public class InfoDaoImpl implements IInfoDao {
    @Override
    public PersonalInfo findPersonalInfo(String username) {
        Connection connection = DBUtils.getConnection();
        System.out.println("findUserInfo......");
        String sql = "SELECT * FROM personal_info WHERE username = ?";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1,username);
            ResultSet resultSet = prep.executeQuery();
            PersonalInfo info = new PersonalInfo();
            resultSet.next();
            info.setUsername(resultSet.getString("username"));
            info.setMoney(resultSet.getInt("money"));
            info.setEmail(resultSet.getString("email"));
            info.setPhone(resultSet.getString("phone"));
            info.setName(resultSet.getString("name"));
            System.out.println("findUserInfo success");
            return info;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("findUserInfo failure");
            return null;
        }finally {
            DBUtils.closeConnection();
        }
    }

    @Override
    public boolean setPersonalInfo(PersonalInfo person) {
        Connection connection = DBUtils.getConnection();
        System.out.println("setPersonalInfo......");
        String sql = " update personal_info set money = ?, name = ?, phone = ?, email = ? where username = ?;";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setInt(1, person.getMoney());
            prep.setString(2, person.getName());
            prep.setString(3, person.getPhone());
            prep.setString(4, person.getEmail());
            prep.setString(5, person.getUsername());
            prep.executeUpdate();
            return prep.getUpdateCount() != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtils.closeConnection();
        }
    }

    @Override
    public boolean addMoney(String username, int extra) {
        Connection connection = DBUtils.getConnection();
        System.out.println("addMoney......");
        String sql = " update personal_info set money = money+? where username = ?;";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setInt(1, extra);
            prep.setString(2, username);
            prep.executeUpdate();
            return prep.getUpdateCount() != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            DBUtils.closeConnection();
        }
    }
}
