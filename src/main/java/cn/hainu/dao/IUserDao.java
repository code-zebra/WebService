package cn.hainu.dao;

import cn.hainu.domain.User;

/**
 * 用户数据相关接口
 */
public interface IUserDao {
    /**
     * 查询用户
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
}
