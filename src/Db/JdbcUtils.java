package Db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by yangrb on 17-7-16.
 */
public class JdbcUtils {
    /*
    释放连接
     */
    public static  void ReleaseConnection(Connection connection){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    创建数据源
     */
    private static DataSource dataSource = null;

    static {
        dataSource = new ComboPooledDataSource("customerManagement");
    }

    /*
    获得Connection对象
     */
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}
