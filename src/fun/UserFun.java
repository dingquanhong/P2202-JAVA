package fun;

import classlib.Book;
import classlib.Borrowrecord;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class UserFun {

    public static String getfavoriteBookimg(int index) {
        PriorityQueue<Book> books = getSortList();
        int i=1;
        while (!books.isEmpty()&&i!=index){
             books.poll();
             i++;
        }
        String imgpath = "D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+books.poll().getid()+".jpg";
        return imgpath;
    }


    /**
     * 获得从大到小的优先队列，使用时请加上poll()
     * 案例代码：
     * PriorityQueue<Book> queue = getSortList();
     *        while (!queue.isEmpty()){
     *            System.out.println(queue.poll());
     *        }
     * @return {@link PriorityQueue}
     */
    public static PriorityQueue getSortList(){
        List<Book> books = JBDC_Booklib.readBookData();

        PriorityQueue<Book> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getscore().compareTo(o2.getscore())<0){
                return 1;
            }else if (o1.getscore().compareTo(o2.getscore())>0){
                return -1;
            }else {
                return 0;
            }
        });
        for (Book book:books){
            queue.add(book);
        }
        return queue;
    }

    public static int getduetonum() {
        List<Borrowrecord> userlist =ReturnFun.getUserdata();
        int count = 0;
        for(Borrowrecord record : userlist){
            if (DateFun.calDate(record.getReturenDate())<5){
                count++;
            }
        }
        return count;
    }

    public static int getreducenum() {
        List<Borrowrecord> userlist =ReturnFun.getUserdata();
        int count = 0;
        for(Borrowrecord record : userlist){
            if (DateFun.calDate(record.getReturenDate())<0){
                count++;
            }
        }
        return count;
    }
}
