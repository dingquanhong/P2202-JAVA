package fun;

import classlib.Book;

import java.util.List;

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

}
