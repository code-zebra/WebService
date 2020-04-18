package cn.hainu.dao;

import cn.hainu.domain.PersonalInfo;

/**
 * @author Ant
 */
public interface IInfoDao {

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 用户信息实体类PersonalInfo
     */
    public PersonalInfo findPersonalInfo(String username);

    /**
     * 更改用户个人信息，用户自行更改时使用
     *
     * @param person
     * @return 是否更改成功
     */
    public boolean setPersonalInfo(PersonalInfo person);

    /**
     * 用户钱包充值
     *
     * @param username 用户名
     * @param extra 充值金额
     * @return 是否充值成功
     */
    public boolean addMoney(String username, int extra);
}
