package fun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFun {
    public static int calDate(String returndate){
       int dif;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            long todayTime =today.getTime();

            Date Rd = format.parse(returndate);
            long difms = Rd.getTime() -todayTime;
            dif = (int) (difms/3600/24/1000);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return dif;
    }



}


