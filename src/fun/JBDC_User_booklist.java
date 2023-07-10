package fun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import classlib.*;
public class JBDC_User_booklist {
    public static List ReaduserbookListData(){
        List<Booklist> booklists = new ArrayList<>();
        Connection connection = JBDC_Control.getConnection();

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user_booklist";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                booklists.add(new Booklist(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
            JBDC_Control.close(rs, statement, connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return booklists;
    }
    //查询
    public static Booklist selectbyListid(int listid) {
        List<Booklist> booklist = JBDC_User_booklist.ReaduserbookListData();
        for(Booklist list :booklist){
            if (list.getListid()==listid){
                return list;
            }
        }
        return null;
    }


    //删除
    public static void deletebyListid(int listid) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "123";
            conn=DriverManager.getConnection(url,user,pass);
            ps=conn.prepareStatement("delete from user_booklist where userid=?");
            ps.setInt(listid,1);
            int i=ps.executeUpdate();
            if (i>0){
                System.out.println("删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //插入
    public static void insert(int listid, String userid, String list) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            JBDC_Control.getConnection();
            ps=conn.prepareStatement("insert into user_booklist values(?,?,?)");
            ps.setInt(1,listid);
            ps.setString(2,userid);
            ps.setString(3,list);
            int i=ps.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //更改
    public static void update(String list , int listid) {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JBDC_Control.getConnection();
            ps=conn.prepareStatement("update user_booklist set list = ? where listid = ?");
            ps.setString(1,list);
            ps.setInt(2,listid);
            int i=ps.executeUpdate();
            if (i>0){
                System.out.println("修改成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (ps!=null){
                    ps.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//          selectbyListid(1);
//          deletebyListid(1);
//        insert(2,2,"1,3");
//        update();
    }
}
