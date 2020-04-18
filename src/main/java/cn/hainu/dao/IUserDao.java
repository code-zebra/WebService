package cn.hainu.dao;

import cn.hainu.domain.PersonalInfo;
import cn.hainu.domain.User;

/**
 * 用户数据相关接口
 */
public interface IUserDao {
    /**
     * 是否查得到用户
     * @param user
     * @return
     */
    public boolean query(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean add(User user);

    /**
     * 查找数据库中是否有有当前用户名
     * @param username
     * @return
     */
    public boolean findUsername(String username);

    /**
     * 默认的保存用户信息方法，注册用户时使用
     * @param username 用户名
     * @return 是否更改成功
     */
    public boolean setPersonalInfo(String username);
}
