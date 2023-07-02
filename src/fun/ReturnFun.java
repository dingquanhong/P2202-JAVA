package fun;

import classlib.*;
import classlib.Borrowrecord;

import java.util.ArrayList;
import java.util.List;

public class ReturnFun {
    public static List getUserdata(){
        List<Borrowrecord> borrowrecords = JBDC_Borrowlib.readBorrowData();
        List<Borrowrecord> userrecords= new ArrayList<>();
        for (Borrowrecord record:borrowrecords){
            if (record.getBorrowUserID().equals(system.getPhone())){
                userrecords.add(record);
            }

        }
        return userrecords;
    }

    public static int getMaxPagenum() {
        List userrecords = getUserdata();
        float Maxpagef =  userrecords.size()/5;
        int Maxpagenum = userrecords.size()/5;
        if (Maxpagef!=Maxpagenum){
            return Maxpagenum;
        }else {
            return Maxpagenum+1;
        }
    }


    public static String getbookname(int curentpagenum, int index) {
        List<Borrowrecord> userrecords = getUserdata();

        int line = (curentpagenum-1)*5+index-1;
        if (line>=userrecords.size()||userrecords.size()<0){
            return "";
        }
        Borrowrecord thisrecord = userrecords.get(line);

        Book thisbook = JBDC_Booklib.querryBookbyID(thisrecord.getBorrowBookID());
        return thisbook.getbookname();
    }


    public static String getBorrowDate(int curentpagenum, int index) {
        List<Borrowrecord> userrecords = getUserdata();

        int line = (curentpagenum-1)*5+index-1;
        if (line>=userrecords.size()||userrecords.size()<0){
            return "";
        }
        Borrowrecord thisrecord = userrecords.get(line);
        return "借阅日期："+thisrecord.getBorrowDate();
    }

    public static String getBookIMG(int curentpagenum, int index) {
        List<Borrowrecord> userrecords = getUserdata();

        int line = (curentpagenum-1)*5+index-1;
        if (line>=userrecords.size()||userrecords.size()<0){
            return "";
        }
        Borrowrecord thisrecord = userrecords.get(line);
        String path = "D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+thisrecord.getBorrowBookID()+".jpg";
        return path;
    }
    public static boolean returnbook(int curentpagenum, int index){
        List<Borrowrecord> userrecords = getUserdata();

        int line = (curentpagenum-1)*5+index-1;
        if (line>=userrecords.size()||userrecords.size()<0){
            return false;
        }
        Borrowrecord thisrecord = userrecords.get(line);

        int Bookid = thisrecord.getBorrowBookID();
        int id = thisrecord.getID();
        boolean flag1=JBDC_Borrowlib.deletebyID(id);
        boolean flag2=JBDC_Booklib.Updatestatus(Bookid,0);
        return true;

    }
}

