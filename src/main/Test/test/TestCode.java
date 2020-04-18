package test;

import cn.hainu.dao.IInfoDao;
import cn.hainu.dao.impl.InfoDaoImpl;
import cn.hainu.domain.PersonalInfo;
import org.junit.Test;


/**
 * @Author Ant
 * 测试类
 */
public class TestCode {
    IInfoDao infoDao = new InfoDaoImpl();
    @Test
    public void TestFindPersonalInfo() {
        PersonalInfo personalInfo = infoDao.findPersonalInfo("张三");
        System.out.println(personalInfo);
    }

    @Test
    public void TestSetPersonalInfo() {
        PersonalInfo info = new PersonalInfo();
        info.setUsername("张三");
        info.setName("张四风");
        info.setPhone("654321");
        info.setEmail("233@qq.com");
        info.setMoney(500);
        infoDao.setPersonalInfo(info);
    }
}
