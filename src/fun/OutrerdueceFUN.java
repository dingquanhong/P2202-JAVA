package fun;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutrerdueceFUN {
    public static long isOutrudece(String Date) throws ParseException {
        long differ;
        Date today = new Date();
        DateFormat A = DateFormat.getDateInstance();
        Date date = A.parse(Date);
        System.out.println(date);
        Date day = A.parse("2023-07-20");
        long s = day.getTime()-today.getTime();
        differ = s/86400000;
        return differ;
    }


    public static void main(String[] args) throws ParseException {

        System.out.println(isOutrudece(""));
    }
}