package GUI;

import fun.BorrowFun;
import fun.JBDC_Booklib;
import fun.Window;
import classlib.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BorrowGUI {
    int current = 1;
    String BorrowUserID;
    private JPanel borrow;
    private JTextField search;
    private JButton searchButton;
    private JButton B1;
    private JButton A1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel Book1;
    private JPanel Book2;
    private JPanel Book3;
    private JPanel Book4;
    private JPanel Book5;
    private JLabel name1;
    private JLabel name2;
    private JLabel name3;
    private JLabel name4;
    private JLabel detail1;
    private JLabel detail2;
    private JLabel detail3;
    private JLabel detail4;
    private JLabel page;
    private JButton B2;
    private JLabel name5;
    private JLabel detail5;
    private JButton B5;
    private JButton B4;
    private JButton B3;
    private JLabel img1;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;

    public BorrowGUI(){
        GUIShow(current);
        this.BorrowUserID = system.getUser();


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current++;
                GUIShow(current);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current=current-1;
                GUIShow(current);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current=1;
                GUIShow(current);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current=Integer.parseInt(BorrowFun.getMaxPagenum());
                GUIShow(current);
            }
        });
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int BookID = BorrowFun.getBookID(current,1);
                Data today = null;
                Data returnDtae = null;
                if (BorrowFun.borrowBook(BookID,BorrowUserID)){
                    B1.setEnabled(false);
                    Book newstatus = JBDC_Booklib.querryBookbyID(BookID);
                    newstatus.setState(1);
                    JBDC_Booklib.editBookData(BookID,newstatus);
                    B1.setText("已借阅");
                }else{
                    JOptionPane.showMessageDialog(null,"借阅失败");
                }
            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int BookID = BorrowFun.getBookID(current,1);
                Data today = null;
                Data returnDtae = null;
                if (BorrowFun.borrowBook(BookID,BorrowUserID)){
                    B2.setEnabled(false);
                    Book newstatus = JBDC_Booklib.querryBookbyID(BookID);
                    newstatus.setState(1);
                    JBDC_Booklib.editBookData(BookID,newstatus);
                    B2.setText("已借阅");
                }else{
                    JOptionPane.showMessageDialog(null,"借阅失败");
                }
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int BookID = BorrowFun.getBookID(current,1);
                Data today = null;
                Data returnDtae = null;
                if (BorrowFun.borrowBook(BookID,BorrowUserID)){
                    B3.setEnabled(false);
                    Book newstatus = JBDC_Booklib.querryBookbyID(BookID);
                    newstatus.setState(1);
                    JBDC_Booklib.editBookData(BookID,newstatus);
                    B3.setText("已借阅");
                }else{
                    JOptionPane.showMessageDialog(null,"借阅失败");
                }
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int BookID = BorrowFun.getBookID(current,1);
                Data today = null;
                Data returnDtae = null;
                if (BorrowFun.borrowBook(BookID,BorrowUserID)){
                    B4.setEnabled(false);

                    B4.setText("已借阅");
                }else{
                    JOptionPane.showMessageDialog(null,"借阅失败");
                }
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int BookID = BorrowFun.getBookID(current,1);
                Data today = null;
                Data returnDtae = null;
                if (BorrowFun.borrowBook(BookID,BorrowUserID)){
                    B5.setEnabled(false);

                    B5.setText("已借阅");
                }else{
                    JOptionPane.showMessageDialog(null,"借阅失败");
                }

            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchtext = search.getText();
                List books = JBDC_Booklib.querryBookbyName(searchtext);

            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = 1;
                GUIShow(current);
            }
        });
    }

    public static void show() {
        JFrame frame = new JFrame("BorrowGUI");
        frame.setContentPane(new BorrowGUI().borrow);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }

    public void GUIShow(int curentpagenum){
        this.Book1.setVisible(true);
        this.Book2.setVisible(true);
        this.Book3.setVisible(true);
        this.Book4.setVisible(true);
        this.Book5.setVisible(true);
        this.page.setText(String.valueOf(curentpagenum)+"/"+BorrowFun.getMaxPagenum());

        this.name1.setText(BorrowFun.getBookname(curentpagenum,1));
        this.name2.setText(BorrowFun.getBookname(curentpagenum,2));
        this.name3.setText(BorrowFun.getBookname(curentpagenum,3));
        this.name4.setText(BorrowFun.getBookname(curentpagenum,4));
        this.name5.setText(BorrowFun.getBookname(curentpagenum,5));
        if (this.name1.getText().equals("")){
            this.Book1.setVisible(false);
        }
        if (this.name2.getText().equals("")){
            this.Book2.setVisible(false);
        }
        if (this.name3.getText().equals("")){
            this.Book3.setVisible(false);
        }
        if (this.name4.getText().equals("")){
            this.Book4.setVisible(false);
        }
        if (this.name5.getText().equals("")){
            this.Book5.setVisible(false);
        }
        this.detail1.setText(BorrowFun.getBookdesc(curentpagenum,1));
        this.detail2.setText(BorrowFun.getBookdesc(curentpagenum,2));
        this.detail3.setText(BorrowFun.getBookdesc(curentpagenum,3));
        this.detail4.setText(BorrowFun.getBookdesc(curentpagenum,4));
        this.detail5.setText(BorrowFun.getBookdesc(curentpagenum,5));
        this.B1.setText(getBookState(B1,curentpagenum,1));
        this.B2.setText(getBookState(B2,curentpagenum,2));
        this.B3.setText(getBookState(B3,curentpagenum,3));
        this.B4.setText(getBookState(B4,curentpagenum,4));
        this.B5.setText(getBookState(B5,curentpagenum,5));
        this.img1.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+BorrowFun.getthisBookID(curentpagenum,1)+".jpg"));
        this.img2.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+BorrowFun.getthisBookID(curentpagenum,2)+".jpg"));
        this.img3.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+BorrowFun.getthisBookID(curentpagenum,3)+".jpg"));
        this.img4.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+BorrowFun.getthisBookID(curentpagenum,4)+".jpg"));
        this.img5.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+BorrowFun.getthisBookID(curentpagenum,5)+".jpg"));

    }

    private String getBookState(JButton button, int curentpagenum, int i) {
        int BookID = BorrowFun.getBookID(curentpagenum,i);
        Book book = JBDC_Booklib.querryBookbyID(BookID);
        switch (book.getstate()){
            case 0:
                return "借阅";
            case 1:
                button.setEnabled(false);
                return "已借出";
        }
        return null;
    }

    public static void main(String[] args) {
        show();
    }
}