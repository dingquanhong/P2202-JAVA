package fun;
import java.sql.*;
import classlib.*;


public class JBDC_Control {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");    //1.加载驱动
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**通用连接数据库函数
     *
     * @return {@link Connection}
     */
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/library";
        String user=system.getMysql_admin();
        String pass=system.getMysql_pass();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,pass);    //2.得到连接
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return connection;
    }
    /**
     * 通用数据库关闭函数
     *
     * @param rs         rs
     * @param statement  声明
     * @param connection 连接
     */
    public  static void close(ResultSet rs , Statement statement,Connection connection){

        try {
            if (rs!=null) {
                rs.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}

