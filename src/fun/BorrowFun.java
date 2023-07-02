package fun;

import GUI.BorrowGUI;
import classlib.*;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BorrowFun {
    List books = JBDC_Booklib.readBookData();
    public static boolean BorrowbyID(int bookid){

        return false;
    }
    public static int getBookID(int currentpagenum,int index){
        List<Book> books = JBDC_Booklib.readBookData();
        int ID = (currentpagenum-1)*5+index;

        return ID;
    }
    public static int getBook(int currentpagenum,int index){
        List<Book> books = JBDC_Booklib.readBookData();
        int ID = (currentpagenum-1)*5+index;
        Book thisbook = books.get(ID);
        return thisbook.getid();

    }
    public static String getBookname(int currentpagenum,int index) {
        int cloum = BorrowFun.getBookID(currentpagenum,index);
        List<Book> books=  JBDC_Booklib.readBookData();
        if (cloum>books.size()){
            return "";
        }
        String bookname = books.get(cloum-1).getbookname();
        return bookname;
    }



    public static int getthisBookID(int currentpagenum,int index){
        int cloum = BorrowFun.getBookID(currentpagenum,index);
        List<Book> books=  JBDC_Booklib.readBookData();
        if (cloum>books.size()){
            return -1;
        }
        int bookID = books.get(cloum-1).getid();
        return bookID;
    }


    public static void main(String[] args) {
        System.out.println(getthisBookID(2,1));
    }
    public static String getMaxPagenum() {
        List books = JBDC_Booklib.readBookData();
        int Maxpagenum = books.size()/5+1;
        return String.valueOf(Maxpagenum);
    }

    public static boolean borrowBook(int bookID, String borrowUserID) {
        Date today = new Date();

        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String borrowData = Format.format(today);
        Calendar returnDate = Calendar.getInstance();
        returnDate.add(Calendar.DATE, 15);
        String returndate = Format.format(returnDate.getTime());
        Book BorrowBook = JBDC_Booklib.querryBookbyID(bookID);
        boolean flag =  JBDC_Borrowlib.addBookData(BorrowBook.getid(),borrowUserID,borrowData,returndate,1);
        return true;
    }


    public static String getBookauthor(int currentpagenum, int index) {
        int cloum = BorrowFun.getBookID(currentpagenum,index);
        List<Book> books=  JBDC_Booklib.readBookData();
        if (cloum>books.size()){
            return "";
        }
        String bookdesc = books.get(cloum-1).getauthor();
        return bookdesc;
    }
}
