package cn.luge.dao;

import cn.luge.domain.User;
import cn.luge.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中user表的类
 */
public class UserDao {
    // 创建jdbcTemplated对象
    private JdbcTemplate template;

    {
        try {
            template = new JdbcTemplate(JDBCUtils.getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param loginUser 登录对象，只包含用户名和密码
     * @return  user 返回对象，包含用户在数据库中存储的全部信息，没有查询到返回null
     */
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }

    }
}
