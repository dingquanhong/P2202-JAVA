package GUI;

import classlib.Book;
import classlib.Borrowrecord;
import fun.BookmanagementFun;
import fun.JBDC_Borrowlib;
import fun.Window;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bookmanagement {
    int current = 1;
    private JButton button1;
    private JButton button2;
    private JButton B1;
    private JButton addButton;
    private JPanel Manage;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JLabel k2;
    private JLabel k4;
    private JLabel k1;
    private JLabel k3;


    public Bookmanagement() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewBook.show();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current--;
                GUIShow(current);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current++;
                GUIShow(current);
            }
        });
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrowrecord delrecode =JBDC_Borrowlib.querryByBookID(BookmanagementFun.getBookID(current,1));
                if (delrecode!=null)
                {
                    JBDC_Borrowlib.deletebyID(delrecode.getBorrowBookID());

                    GUIShow(1);
                }else{
                    JOptionPane.showMessageDialog(null,"图书无法归还");
                }
            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrowrecord delrecode =JBDC_Borrowlib.querryByBookID(BookmanagementFun.getBookID(current,1));
                if (delrecode!=null)
                {
                    JBDC_Borrowlib.deletebyID(delrecode.getBorrowBookID());

                    GUIShow(1);
                }else{
                    JOptionPane.showMessageDialog(null,"图书无法归还");
                }
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrowrecord delrecode =JBDC_Borrowlib.querryByBookID(BookmanagementFun.getBookID(current,1));
                if (delrecode!=null)
                {
                    JBDC_Borrowlib.deletebyID(delrecode.getBorrowBookID());

                    GUIShow(1);
                }else{
                    JOptionPane.showMessageDialog(null,"图书无法归还");
                }
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrowrecord delrecode =JBDC_Borrowlib.querryByBookID(BookmanagementFun.getBookID(current,1));
                if (delrecode!=null)
                {
                    JBDC_Borrowlib.deletebyID(delrecode.getBorrowBookID());

                    GUIShow(1);
                }else{
                    JOptionPane.showMessageDialog(null,"图书无法归还");
                }
            }
        });

    }
    public static void show() {
        JFrame frame = new JFrame("Bookmanagement");
        frame.setContentPane(new Bookmanagement().Manage);

        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }
    public void GUIShow(int curentpagenum){
//        this.button1.setText(String.valueOf(curentpagenum)+"/"+ BookmanagementFun.getMaxPagenum());
        k1.setIcon(new ImageIcon("D:\\JAVA\\P2202-JAVA\\P2202-JAVA\\src\\bin\\book\\5.jpg"));
        k2.setIcon(new ImageIcon("D:\\JAVA\\P2202-JAVA\\P2202-JAVA\\src\\bin\\book\\4.jpg"));
        k3.setIcon(new ImageIcon("D:\\JAVA\\P2202-JAVA\\P2202-JAVA\\src\\bin\\book\\3.jpg"));
        k4.setIcon(new ImageIcon("D:\\JAVA\\P2202-JAVA\\P2202-JAVA\\src\\bin\\book\\2.jpg"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bookmanagement");
        frame.setContentPane(new Bookmanagement().Manage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
