package fun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import GUI.BorrowGUI;
import classlib.*;
public class JBDC_Borrowlib {
    //查询
    public static void selectbyID(int id) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "123";
            conn= DriverManager.getConnection(url,user,pass);
            ps=conn.prepareStatement("select*from borrowlib where id =?");
            ps.setInt(1,id);
            rs= ps.executeQuery();
            while (rs.next()) {
                rs.getInt(id);//根据列的索引取值
                int BorrowBookID = rs.getInt(2);
                int BorrowUserID = rs.getInt(3);
                String BorrowDate = rs.getString(4);
                String ReturnDate = rs.getString(5);
                int status = rs.getInt(6);
                System.out.println(id + "," + BorrowBookID + "," + BorrowUserID + ","+ BorrowDate + ","+ ReturnDate + ","+ status + ",");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null) {
                    rs.close();
                }
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


    //删除
    public static void deletebyID(int id)  {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = system.getMysql_admin();
            String pass = system.getMysql_pass();
            conn=DriverManager.getConnection(url,user,pass);
            ps=conn.prepareStatement("delete from borrowlib where id=?");
            ps.setInt(id,1);
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
    public static boolean insert(int id ,int BorrowBookID, String BorrowUserID, String BorrowDate, String ReturnDate, int status)  {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = system.getMysql_admin();
            String pass = system.getMysql_pass();
            conn=DriverManager.getConnection(url,user,pass);
            ps=conn.prepareStatement("DELETE FROM borrowlib ");
            ps=conn.prepareStatement("insert into borrowlib values(?,?,?,?,?,?)");
            ps.setInt(1,id);
            ps.setInt(2,BorrowBookID);
            ps.setString(3,BorrowUserID);
            ps.setString(4,BorrowDate);
            ps.setString(5,ReturnDate);
            ps.setInt(6,status);
            int i=ps.executeUpdate();
            if (i>0){
                System.out.println("插入成功");
                return true;
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
        return false;
    }

    //更改
    public static void update(int id,int BorrowBookID,int BorrowUserID,String BorrowDate,String ReturnDate,int status) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String pass = "123";
            conn=DriverManager.getConnection(url,user,pass);
            ps=conn.prepareStatement("update borrowlib set BorrowBookID = ?,BorrowUserID=?,BorrowDate=?,ReturnDate=?,status=? where id = ?");
            ps.setInt(6,id);
            ps.setInt(1,BorrowBookID);
            ps.setInt(2,BorrowUserID);
            ps.setString(3,BorrowDate);
            ps.setString(4,ReturnDate);
            ps.setInt(5,status);
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



    public static boolean addBookData( int BorrowBookID, String BorrowUserID, String BorrowDate, String ReturnDate, int status) {

        Connection connection = JBDC_Control.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO borrowlib(BorrowBookID,BorrowUserID,BorrowDate,ReturnDate,status) values ('"+ BorrowBookID +"','"+BorrowUserID+"','"+BorrowDate+"','"+ReturnDate+"','"+status+"')";
            int flag = statement.executeUpdate(sql);
            if (flag>1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static List readBorrowData(){

        List<Borrowrecord> recordList = new ArrayList<>();
        Connection connection = JBDC_Control.getConnection();

        try {
            Statement  statement = connection.createStatement();
            String sql = "SELECT * FROM borrowlib";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                recordList.add(new Borrowrecord(
                        rs.getInt(1),//ID
                        rs.getInt(2), //
                        rs.getString(3),//pass
                        rs.getString(4),//phone
                        rs.getString(5),//avatar
                        rs.getInt(6)
                ));
            }
            JBDC_Control.close(rs,statement,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recordList;

    }
    public static Borrowrecord querryByuserID(String userid){
        List<Borrowrecord> records = JBDC_Borrowlib.readBorrowData();
        for(Borrowrecord record:records){
            if (record.getBorrowUserID().equals(userid)){
                return record;
            }
        }
        return null;
    }
    public static List querryBookbyName(String searchtext) {
        List<Book> BookList =  JBDC_Booklib.readBookData();
        for (Book book:BookList){
            if (book.getbookname().contains(searchtext)){

                BookList.add(book);
            }
        }
        return BookList;
    }
    public static Borrowrecord querryByBookID(int bookid){
        List<Borrowrecord> records = JBDC_Borrowlib.readBorrowData();
        for(Borrowrecord record:records){
            if (record.getBorrowBookID()==(bookid)){
                return record;
            }
        }
        return null;
    }
}
