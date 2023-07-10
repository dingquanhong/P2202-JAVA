package GUI;

import classlib.Booklist;
import classlib.*;
import fun.JBDC_Booklib;
import fun.JBDC_User_booklist;
import fun.Window;
import fun.file;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;
import java.util.List;

public class BooklistGUI {
    private JButton shareButton;
    private JPanel listGUI;
    private JTable table1;

    public BooklistGUI(int index) {
        DefaultTableModel tableModel=(DefaultTableModel) this.table1.getModel();
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"序号","书本名称","作者"});    //设置表头
        List<Booklist> booklists = JBDC_User_booklist.ReaduserbookListData();
        List<Booklist> userlist = new ArrayList<>();
        int count=0;
        for (Booklist list :booklists){
            if (list.getUserid().equals(system.getUserphone())){
                userlist.add(list);
                count++;
                if (count==3){
                    break;
                }
            }
        }
        String[] booksid;
        Booklist thislist =userlist.get(index-1);
        if (thislist.getList()==null){
            JOptionPane.showMessageDialog(null,"Error：书单为空");

        }else {
            booksid  = thislist.getList().split(",");
            List<Book> thisbooklist = new ArrayList<>();
            for(String bookid :booksid){
                int bookidnum = Integer.valueOf(bookid);

                thisbooklist.add(JBDC_Booklib.querryBookbyID(bookidnum));
            }
            List<String[]> result = new ArrayList<>();
            int i =1;

            for(Book book:thisbooklist){

                result.add(new String[]{String.valueOf(i),book.getbookname(),book.getauthor()});
                i++;
            }

            for (String[] row :result){
                tableModel.addRow(row);
            }
        }
        shareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Booklist> booklists = JBDC_User_booklist.ReaduserbookListData();
                List<Booklist> userlist = new ArrayList<>();
                int count=0;
                for (Booklist list :booklists){
                    if (list.getUserid().equals(system.getUserphone())){
                        userlist.add(list);
                        count++;
                        if (count==3){
                            break;
                        }
                    }
                }
                String[] booksid;
                Booklist thislist =userlist.get(index-1);
                booksid  = thislist.getList().split(",");
                List<Book> thisbooklist = new ArrayList<>();
                for(String bookid :booksid){
                    int bookidnum = Integer.valueOf(bookid);

                    thisbooklist.add(JBDC_Booklib.querryBookbyID(bookidnum));
                }
                String content="";

                for(Book book:thisbooklist){
                    content += "<table><tr><td>"+book.getbookname()+"</td><td><img src='."+book.getid()+".jpg'" +
                            "alt=\"\"></td><td>"+book.getauthor()+"</td><td>"+book.getdescribe()+"</td></tr></table>";
                }
                file.addHtml(content,system.getUser());
            }
        });
    }

    public static void show(int index) {
        JFrame frame = new JFrame("BooklistGUI");
        frame.setContentPane(new BooklistGUI(index).listGUI);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }
}
