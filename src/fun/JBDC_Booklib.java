package fun;

import classlib.*;

import java.sql.*;
import java.util.*;

public class JBDC_Booklib {
    /**
     * 阅读图书数据
     *
     * @return {@link List}
     */
    public static List readBookData() {             //查看·
        List<Book> BookList = new ArrayList<>();
        Connection connection = JBDC_Control.getConnection("root","123");

        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                BookList.add(new Book(
                        rs.getInt(1),//id
                        rs.getString(2), //bookname
                        rs.getString(3),//author
                        rs.getString(4),//imgsrc
                        rs.getString(5),//describe
                        rs.getString(6),//ISBN
                        rs.getFloat(7),//price
                        rs.getFloat(8),//score
                        rs.getInt(9)//state
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return BookList;
    }

    public static void main(String[] args) {       //打印
        List<Book> BookList = new ArrayList<>();
        BookList = readBookData();
        for (Book book : BookList){
            System.out.println(book);
        }
    }

    /**
     * querry bookby id
     *
     * @param id id
     * @return {@link Book}
     */
    public static Book querryBookbyID(int id) {                 //查询
        List<Book> BookList =  readBookData();
        for (Book book:BookList){
            if (book.getid()==id){

                return book;
            }
        }
        return null;
    }

    /**
     * 删除书
     *
     * @param id id
     * @return boolean
     */
    public static boolean deleteBook(int id){                     //删除
    Connection connection = JBDC_Control.getConnection("root","123");

    try {
        Statement statement = connection.createStatement();
        String sql = "DELETE FROM book WHERE id =" + id;
        int count =statement.executeUpdate(sql);
        if (count>0) {
            System.out.println("id为" + id + " 的图书已经删除");
            return true;
        }

    } catch (SQLException e) {

        throw new RuntimeException(e);
    }
    return false;
}

    /**
     * 编辑图书数据
     *
     * @param bookid bookid
     * @param book   书
     * @return boolean
     */
    public static boolean editBookData(int bookid,Book book) {                     //修改
        Connection connection = JBDC_Control.getConnection("root","123");

        try {
            Statement statement = connection.createStatement();
            String sql = "UPDATE book SET bookname = '" + book.getbookname() + "', author = '" + book.getauthor() + "', describe = '" + book.getdescribe() +
                    "', ISBN = '" + book.getISBN() + "', score = " + book.getscore() + ", price = " + book.getprice() + ", state = " + book.getstate() +
                    " WHERE id = " + book.getid();
            int count =statement.executeUpdate(sql);
            if (count>0) {
                System.out.println("id为" + book.getid() + " 的图书已经修改");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return false;
    }

    /**
     * 添加图书数据
     *
     * @param book 书
     * @return boolean
     */
    public static boolean addBookData(Book book) {                                //添加
        Connection connection = JBDC_Control.getConnection("root","123");

        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO book (bookname, author, describe, ISBN, score, price, state) VALUES ('" +
                    book.getbookname() + "', '" + book.getauthor() + "', '" + book.getdescribe() + "', '" +
                    book.getISBN() + "', " + book.getscore() + ", " + book.getprice() + ", " + book.getstate() + ")";

            int count =statement.executeUpdate(sql);
            if (count>0) {
                System.out.println("图书已添加");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }





}
