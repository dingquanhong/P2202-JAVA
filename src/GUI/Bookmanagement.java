package GUI;

import classlib.Borrowrecord;
import fun.*;


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
    private JLabel page;
    private JButton B5;
    private JLabel img1;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;
    private JPanel P1;
    private JPanel P2;
    private JPanel P3;
    private JPanel P4;
    private JPanel P5;
    private JLabel k2;
    private JLabel k4;
    private JLabel k1;
    private JLabel k3;


    public Bookmanagement() {
        GUIShow(current);
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
                if (current==JBDC_Booklib.readBookData().size()){
                    button2.setEnabled(false);
                }
                GUIShow(current);
            }
        });
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JBDC_Booklib.deleteBook(BookmanagementFun.getBookID(current,1));
                GUIShow(current);
            }
        });

        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBDC_Booklib.deleteBook(BookmanagementFun.getBookID(current,1));
                GUIShow(current);
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBDC_Booklib.deleteBook(BookmanagementFun.getBookID(current,1));
                GUIShow(current);
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBDC_Booklib.deleteBook(BookmanagementFun.getBookID(current,1));
                GUIShow(current);
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBDC_Booklib.deleteBook(BookmanagementFun.getBookID(current,1));
                GUIShow(current);
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
        button2.setEnabled(true);
        button1.setEnabled(true);
        P1.setVisible(true);
        P2.setVisible(true);
        P3.setVisible(true);
        P4.setVisible(true);
        P5.setVisible(true);
        page.setText(curentpagenum+"/"+BookmanagementFun.getMaxPagenum());
        img1.setIcon(new ImageIcon(BookmanagementFun.getBookimg(curentpagenum,1)));
        img2.setIcon(new ImageIcon(BookmanagementFun.getBookimg(curentpagenum,2)));
        img3.setIcon(new ImageIcon(BookmanagementFun.getBookimg(curentpagenum,3)));
        img4.setIcon(new ImageIcon(BookmanagementFun.getBookimg(curentpagenum,4)));
        img5.setIcon(new ImageIcon(BookmanagementFun.getBookimg(curentpagenum,5)));
        if (BookmanagementFun.getBookimg(curentpagenum,1).equals("")){
            P1.setVisible(false);
        }
        if (BookmanagementFun.getBookimg(curentpagenum,2).equals("")){
            P2.setVisible(false);
        }
        if (BookmanagementFun.getBookimg(curentpagenum,3).equals("")){
            P3.setVisible(false);
        }
        if (BookmanagementFun.getBookimg(curentpagenum,4).equals("")){
            P4.setVisible(false);
        }
        if (BookmanagementFun.getBookimg(curentpagenum,5).equals("")){
            P5.setVisible(false);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bookmanagement");
        frame.setContentPane(new Bookmanagement().Manage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }
}
