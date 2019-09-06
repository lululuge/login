package cn.luge.test;

import cn.luge.dao.UserDao;
import cn.luge.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("luzan");
        loginUser.setPassword("000000");
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
    }

}
