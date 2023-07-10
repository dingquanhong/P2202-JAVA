package GUI;

import classlib.Booklist;
import fun.JBDC_User_booklist;
import fun.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import classlib.*;

public class BooklistAddGUI {


    private JPanel panel1;
    private JButton List1;
    private JButton List3;
    private JButton List2;

    public static void show( int bookid) {
        JFrame frame = new JFrame("BooklistAddGUI");
        frame.setContentPane(new BooklistAddGUI(bookid).panel1);
        Window.tocenter(frame);
        frame.pack();
        frame.setVisible(true);
    }
    public BooklistAddGUI( int bookid){

        List1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Booklist> booklists = JBDC_User_booklist.ReaduserbookListData();
                List<Booklist> userlist = new ArrayList<>();
                int count=0;
                for (Booklist list:booklists){
                    if (list.getUserid().equals(system.getUserphone())){
                        userlist.add(list);
                        count++;
                        if (count==3){
                            break;
                        }
                    }
                }
                if (userlist.size()==0){
                    int listnum = JBDC_User_booklist.ReaduserbookListData().size();
                    for(int i = 1;i<=3;i++){
                        JBDC_User_booklist.insert(listnum+i,system.getUserphone(),"");
                    }
                    for (Booklist list:booklists){
                        if (list.getUserid().equals(system.getUserphone())){
                            userlist.add(list);
                            count++;
                            if (count==3){
                                break;
                            }
                        }
                    }
                }
                int listid = userlist.get(0).getListid();
                if (userlist.get(0).getList().contains(String.valueOf(bookid))){
                    JOptionPane.showMessageDialog(null,"该书已在书单中！");
                }else {
                    Booklist thislist = JBDC_User_booklist.selectbyListid(listid);
                    String oldlist = thislist.getList();
                    String newlist;
                    if (oldlist==null){
                        newlist = String.valueOf(bookid);
                    }else {
                        newlist = oldlist+","+bookid;
                    }
                    JBDC_User_booklist.update(newlist,listid);
                }

            }
        });
        List2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Booklist> booklists = JBDC_User_booklist.ReaduserbookListData();
                List<Booklist> userlist = new ArrayList<>();
                int count=0;
                for (Booklist list:booklists){
                    if (list.getUserid().equals(system.getUserphone())){
                        userlist.add(list);
                        count++;
                        if (count==3){
                            break;
                        }
                    }
                }
                if (userlist.size()==0){
                    int listnum = JBDC_User_booklist.ReaduserbookListData().size();
                    for(int i = 1;i<=3;i++){
                        JBDC_User_booklist.insert(listnum+i,system.getUserphone(),"");
                    }
                    for (Booklist list:booklists){
                        if (list.getUserid().equals(system.getUserphone())){
                            userlist.add(list);
                            count++;
                            if (count==3){
                                break;
                            }
                        }
                    }
                }
                int listid = userlist.get(1).getListid();
                if (userlist.get(1).getList().contains(String.valueOf(bookid))){
                    JOptionPane.showMessageDialog(null,"该书已在书单中！");
                }else {
                    Booklist thislist = JBDC_User_booklist.selectbyListid(listid);
                    String oldlist = thislist.getList();
                    String newlist;
                    if (oldlist == null) {
                        newlist = String.valueOf(bookid);
                    } else {
                        newlist = oldlist + "," + bookid;
                    }
                    JBDC_User_booklist.update(newlist, listid);
                }
            }
        });
        List3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Booklist> booklists = JBDC_User_booklist.ReaduserbookListData();
                List<Booklist> userlist = new ArrayList<>();
                int count=0;
                for (Booklist list:booklists){
                    if (list.getUserid().equals(system.getUserphone())){
                        userlist.add(list);
                        count++;
                        if (count==3){
                            break;
                        }
                    }
                }
                if (userlist.size()==0){
                    int listnum = JBDC_User_booklist.ReaduserbookListData().size();
                    for(int i = 1;i<=3;i++){
                        JBDC_User_booklist.insert(listnum+i,system.getUserphone(),"");
                    }
                    for (Booklist list:booklists){
                        if (list.getUserid().equals(system.getUserphone())){
                            userlist.add(list);
                            count++;
                            if (count==3){
                                break;
                            }
                        }
                    }
                }
                int listid = userlist.get(3).getListid();
                if (userlist.get(2).getList().contains(String.valueOf(bookid))){
                    JOptionPane.showMessageDialog(null,"该书已在书单中！");
                }else {
                    Booklist thislist = JBDC_User_booklist.selectbyListid(listid);
                    String oldlist = thislist.getList();
                    String newlist;
                    if (oldlist == null) {
                        newlist = String.valueOf(bookid);
                    } else {
                        newlist = oldlist + "," + bookid;
                    }
                    JBDC_User_booklist.update(newlist, listid);
                }
            }
        });
    }


}
