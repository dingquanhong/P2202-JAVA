package fun;
import classlib.*;


import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JBDC_User {

    /**
     * 读取学生数据
     *
     * @return {@link List}
     */
    public static List readUserData() {
        List<User> userList = new ArrayList<>();
        Connection connection = JBDC_Control.getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                userList.add(new User(
                        rs.getInt(1),//ID
                        rs.getString(2), //user
                        rs.getString(3),//pass
                        rs.getString(4),//phone
                        rs.getString(5),//avatar
                        rs.getInt(6),//borrownum
                        rs.getString(7),//borrowbooklist
                        rs.getInt(7),//booklistnum
                        rs.getString(8),//a1
                        rs.getString(9),//a2
                        rs.getString(10)//a3
                ));
            }
            JBDC_Control.close(rs, statement, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    /**
     * 通过电话号码在数据库中查找用户
     *
     * @param phone 电话
     * @return {@link User} 若未查询到则返回null
     */
    public static User querryUserbyPhone(String phone) {
        List<User> userList = readUserData();
        for (User user : userList) {
            if (user.getPhone().equals(phone)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 增加用户
     *
     * @param user  用户名
     * @param pass  密码
     * @param phone 手机号
     * @return boolean 返回是否成功
     */
    public static boolean addUserData(String user, String pass, String phone) {
        Connection connection = JBDC_Control.getConnection();
        if (!user.contains("/'")) {
            user = "\"" + user + "\"";
        }

        if (!pass.contains("/'")) {
            pass = "\"" + pass + "\"";
        }

        if (!phone.contains("/'")) {
            phone = "\"" + phone + "\"";
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO user(user,pass,phone) values (" + user + "," + pass + "," + phone + ")";
            int status = statement.executeUpdate(sql);
            if (status > 0) {
                System.out.println("增加成功");
                return true;
            } else {
                System.out.println("增加失败");
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //<--------------------------------------删----------------------------------------->
//删除只要输入名字
    public static boolean deleteUserbyPhone(String phone) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {
            statement = connection.prepareStatement("delete from user where phone=?");
//            if (params != null) {
//                for (i = 0; i < params.length; ++i) {
//                    statement.setObject(i + 1, params[i]);
//                }
//            }
            statement.setString(1, phone);//1代表的是sql语句中的第一个问号“？”

            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }
        return true;

    }
    //<--------------------------------------改----------------------------------------->

    public static boolean editUserbyPhone(String phone, User newuser) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {
            statement = connection.prepareStatement("update user set user = ? ,pass = ? where phone=?");
            statement.setString(1,newuser.getUser());
            statement.setString(2, newuser.getPass());//被改
            statement.setString(3, phone);
            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }
        return true;
    }

//    public static boolean  getUserInformation( ){
//        Connection connection = JBDC_Control.getConnection();
//        Statement statement = null;
//        ResultSet rs=null;
//        String query="SELECT id ,user,pass,phone,borrownum,A1,A2,A3 FROM user";
//        try {
//            statement= connection.createStatement();
//            rs=statement.executeQuery(query);
//            while(rs.next()){
//                Object id=rs.getInt("id");
//                String user=rs.getString("user");
//                String pass=rs.getString("pass");
//                String phone=rs.getString("phone");
//                Object borrownum=rs.getInt("borrownum");
//                String A1=rs.getString("A1");
//                String A2=rs.getString("A2");
//                String A3=rs.getString("A3");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            JBDC_Control.close(rs,statement,connection);
//        }
//       return true;
//    }

    //       public static void main(String[] args) {
////        Object[] obj= {"43543543"};
////        JBDC_User.deleteUserbyPhone(obj);
//  //      JBDC_User.deleteUserbyPhone("12312421");
//            JBDC_User.editUserbyPhone("5654645","1243423");
    //  getUserInformation();
//
    //   }
}




