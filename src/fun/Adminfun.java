package fun;

import classlib.Book;
import classlib.Borrowrecord;

import java.util.List;

public class Adminfun {
    public static int getborrownum() {
        List<Borrowrecord> borrowrecords = JBDC_Borrowlib.readBorrowData();
        return borrowrecords.size();

    }

    public static int getbooknum() {
        List<Book> books = JBDC_Booklib.readBookData();
        int booknum = books.size()-getborrownum();
        return booknum;
    }

    public static int getreducenum() {
        List<Borrowrecord> borrowrecords = JBDC_Borrowlib.readBorrowData();
        int count=0;
        for (Borrowrecord borrowrecord :borrowrecords){
            if (DateFun.calDate(borrowrecord.getReturenDate())<0){
                count++;
            }
        }
        return count;
    }
}
