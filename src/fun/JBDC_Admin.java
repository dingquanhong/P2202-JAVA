package fun;

import classlib.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JBDC_Admin {

    /**
     * 添加
     *
     * @param admin 管理
     * @return boolean
     */// <--------------------------------------增----------------------------------------->
    public static boolean add(Admin admin) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        //定义sql语句
        int i;
        try {
            statement = connection.prepareStatement("insert into admin values(?,?,null,?,?,?,?)");
            statement.setObject(1, admin.getUser());
            System.out.println(admin.getUser());
            statement.setObject(2, admin.getPass());

            statement.setObject(3, admin.getPhone());
            statement.setObject(4, admin.getA1());
            statement.setObject(5, admin.getA2());
            statement.setObject(6, admin.getA3());
            i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("输入成功");
            }
            JBDC_Control.close(null,statement,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JBDC_Control.close(null, statement, connection);
        }

        return true;

    }

    /**
     * 删除用户
     *
     * @param params 参数个数
     * @return boolean
     */// <--------------------------------------删----------------------------------------->
//删除只要输入名字
    public boolean deletebyUSER(Object[] params) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {
            statement = connection.prepareStatement("delete from admin where user=?");
            if (params != null) {
                for (i = 0; i < params.length; ++i) {
                    statement.setObject(i + 1, params[i]);
                }
            }
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
// <--------------------------------------改---------------------------------------->

    /**
     * 修改用户
     *
     * @param user1 user1
     * @param user2 user2
     * @return boolean
     */
    public boolean editbyUser(String user1, String user2) {
        Connection connection = JBDC_Control.getConnection();
        PreparedStatement statement = null;
        int i;
        try {
            statement = connection.prepareStatement("update admin set user = ? where user=?");
            statement.setString(1,  user2);
            statement.setString(2, user1);//被改

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

    /**
     * 读取data
     *
     * @return {@link List}<{@link Admin}>
     */// <--------------------------------------读取---------------------------------------->
    public static List<Admin> readAdminDate()  {
        List<Admin> adminList = new ArrayList<>();
        Connection connection = JBDC_Control.getConnection();
        Statement statement = null;
        ResultSet rs=null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM admin";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                adminList.add(new Admin(
                        rs.getString(1),//user
                        rs.getString(2), //pass
                        rs.getString(3),//avatar
                        rs.getString(4),//phone
                        rs.getString(5),//a1
                        rs.getString(6),//a2
                        rs.getString(7)//a3
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JBDC_Control.close(rs,statement,connection);
        }


        return adminList;
    }

    public static void main(String[] args) {
        System.out.println(readAdminDate().get(0).getPhone());
    }
    /**
     * 查询
     *
     * @param phone 电话
     * @return {@link Admin}
     */// <--------------------------------------查----------------------------------------->
    public static Admin queryAdminByPhone(String phone) {
        List<Admin> admins = JBDC_Admin.readAdminDate();
        for(Admin admin:admins){
            if (admin.getPhone().equals(phone)){

                return admin;

            }
        }
        return null;

    }


//        public  static  Admin querybtphone(String phone)  {
//        Connection connection = JBDC_Control.getConnection("root","123");
//        PreparedStatement statement =null;
//        ArrayList adminlist= readerAdminDate();
//        String sql1 = "select * from admin where phone=?"; //从admin表里查询
//        try {
//            statement=connection.prepareStatement(sql1);
//            statement.setString(4,phone);
//
//            ResultSet rs  = null;
//            while (rs.next()){
//                Admin admin = new Admin();
//                admin.setUser(rs.getString("user"));
//                //
//                JBDC_Control.close(rs,statement,connection);
//                return admin;
//            }
//            rs = statement.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    // }


//    public static void main(String[] args) throws SQLException {
//
//       // Admin admin = new Admin("小方","2313","kkk","21333423","撒地方","都为对方",new java.util.Date());
//        JDBC_Admin admin = new JDBC_Admin();
//
////增
//       // add(admin);
//        //
////       删除    admin.deletebyUSER();
//        //修改
//
//        admin.editbyUser("小过","小李");
//        //   读取  readAdminDate();
//
//     // 查找  queryAdminByPhone("21381903");
//
//    }


}
