package fun;

import classlib.Book;

import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookmanagementFun {
    List books = JBDC_Booklib.readBookData();
    public static boolean BorrowbyID(int bookid){

        return false;
    }

    public static int getBookID(int currentpagenum,int index){
        List books = JBDC_Booklib.readBookData();
        int ID = (currentpagenum-1)*4+index;

        return ID;
    }
    public static String getMaxPagenum() {
        List books = JBDC_Booklib.readBookData();
        int Maxpagenum = books.size()/4;
        return String.valueOf(Maxpagenum);
    }

    public static String getBookimg(int current, int index) {
        int line = getBookID(current,index);
        List<Book> books = JBDC_Booklib.readBookData();
        if (line>=books.size()){
            return "";
        }
        Book thisbook = books.get(line);
        String imgpath = "D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+thisbook.getid()+".jpg";
        return imgpath;
    }
}
