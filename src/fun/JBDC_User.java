package fun;
import classlib.*;


import javax.swing.*;
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
                        rs.getInt(5),//avatar
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
                JBDC_Control.close(null,statement,connection);
                return true;
            } else {
                System.out.println("增加失败");
                JBDC_Control.close(null,statement,connection);
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



    public static boolean editQuestionbyPhone(String phone, String a1,String a2,String a3) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {
            statement = connection.prepareStatement("update user set A1 = ? ,A2 = ? , A3 = ? where phone=?");
            statement.setString(1,a1);
            statement.setString(2, a2);
            statement.setString(3, a3);
            statement.setString(4, phone);
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


    public static void editUserBorrownum(String phone,int borrownum) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {

            statement = connection.prepareStatement("update user set borrownum = ?  where phone=?");
            statement.setString(1, String.valueOf(borrownum));
            statement.setString(2, phone);

            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }

    }

    public static void editUserimg(String phone, int status) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {

            statement = connection.prepareStatement("update user set avatar = ?  where phone=?");
            statement.setInt(1, status);
            statement.setString(2, phone);

            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }
    }

    public static void editUserData(int userid, String phonenum, String username, String password) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {

            statement = connection.prepareStatement("update user set phone = ? , user.user = ? ,pass = ?  where id= ?");
            statement.setString(1, phonenum);
            statement.setString(2, username);
            statement.setString(3,password);
            statement.setInt(4,userid);

            i = statement.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null,"修改成功,请重新登录");
                System.exit(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }
    }
}







