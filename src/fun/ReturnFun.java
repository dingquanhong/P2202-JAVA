package fun;

import classlib.*;
import classlib.Borrowrecord;

import java.util.ArrayList;
import java.util.List;

public class ReturnFun {
    public static List getUserlist(){
        List<Borrowrecord> borrowrecords = JBDC_Borrowlib.readBorrowData();

        List<Borrowrecord> userrecords= new ArrayList<>();
        for (Borrowrecord record:borrowrecords){
            System.out.println(record.getBorrowUserID());
            String userID = record.getBorrowUserID();
            if (userID.equals(system.getPhone())){
                userrecords.add(record);
            }
        }
        return userrecords;
    }

    public static int getMaxPagenum() {
        List userlist = ReturnFun.getUserlist();
        float Maxpagef =  userlist.size()/5;
        int Maxpagenum = userlist.size()/5;
        if (Maxpagef!=Maxpagenum){
            return Maxpagenum;
        }else {
            return Maxpagenum+1;
        }
    }


    public static String getbookname(int curentpagenum, int index) {
        List<Borrowrecord> userlist = ReturnFun.getUserlist();
        System.out.println(userlist);
        int line = (curentpagenum-1)*5+index-1;
        Borrowrecord thisrecord=userlist.get(line);
        int bookid = thisrecord.getId();
        String bookname = JBDC_Booklib.querryBookbyID(bookid).getbookname();

        return bookname;

    }


}

