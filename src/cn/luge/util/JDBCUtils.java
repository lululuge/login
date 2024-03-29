package cn.luge.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类,使用druid连接池
 */
public class JDBCUtils {
    private static DataSource ds;
    /**
     * 使用静态代码块，加载配置文件
     */
    static {
        Properties prop = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(is);
            // 初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池对象
     */
    public static DataSource getDataSource() throws Exception {
        return ds;
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
//    public static void close() {
//
//    }
}
