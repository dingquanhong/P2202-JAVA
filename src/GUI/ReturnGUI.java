package GUI;

import fun.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ReturnGUI {
    int current = 1;
    private JPanel returnpanel;
    private JButton B1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel name1;
    private JLabel Date1;
    private JLabel name2;
    private JLabel Date2;
    private JLabel name3;
    private JLabel Date5;
    private JLabel name4;
    private JLabel name5;
    private JButton B5;
    private JButton B4;
    private JButton B3;
    private JButton B2;
    private JLabel page;
    private JPanel JPanel;
    private JPanel Book2;
    private JPanel Book1;
    private JPanel Book3;
    private JPanel Book4;
    private JPanel Book5;
    private JLabel Date3;
    private JLabel Date4;
    private JLabel img2;
    private JLabel img1;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;


    public ReturnGUI() {
        GUIShow(current);
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public  void GUIShow(int curentpagenum){
        Book1.setVisible(true);
        Book2.setVisible(true);
        Book3.setVisible(true);
        Book4.setVisible(true);
        Book5.setVisible(true);
        page.setText(curentpagenum+"/"+ReturnFun.getMaxPagenum());
        name1.setText(ReturnFun.getbookname(curentpagenum,1));
        name2.setText(ReturnFun.getbookname(curentpagenum,2));
        name3.setText(ReturnFun.getbookname(curentpagenum,3));
        name4.setText(ReturnFun.getbookname(curentpagenum,4));
        name5.setText(ReturnFun.getbookname(curentpagenum,5));
        if (name1.getText().equals("")){
            Book1.setVisible(false);
            JOptionPane.showMessageDialog(null,"您没有需要归还的图书");
        }
        if (name2.getText().equals("")){
            Book2.setVisible(false);
        }
        if (name3.getText().equals("")){
            Book3.setVisible(false);
        }
        if (name4.getText().equals("")){
            Book4.setVisible(false);
        }
        if (name5.getText().equals("")){
            Book5.setVisible(false);
        }
        Date1.setText(ReturnFun.getBorrowDate(curentpagenum,1));
        Date2.setText(ReturnFun.getBorrowDate(curentpagenum,2));
        Date3.setText(ReturnFun.getBorrowDate(curentpagenum,3));
        Date4.setText(ReturnFun.getBorrowDate(curentpagenum,4));
        Date5.setText(ReturnFun.getBorrowDate(curentpagenum,5));
        img1.setIcon(new ImageIcon(ReturnFun.getBookIMG(curentpagenum,1)));
        img2.setIcon(new ImageIcon(ReturnFun.getBookIMG(curentpagenum,2)));
        img3.setIcon(new ImageIcon(ReturnFun.getBookIMG(curentpagenum,3)));
        img4.setIcon(new ImageIcon(ReturnFun.getBookIMG(curentpagenum,4)));
        img5.setIcon(new ImageIcon(ReturnFun.getBookIMG(curentpagenum,5)));
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(curentpagenum,1)){
                    GUIShow(current);
                }else{
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (ReturnFun.returnbook(curentpagenum,2)){
                        GUIShow(current);
                    }else{
                        JOptionPane.showMessageDialog(null,"归还失败");
                    }

            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(curentpagenum,3)){
                    GUIShow(current);
                }else{
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(curentpagenum,4)){
                    GUIShow(current);
                }else{
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(curentpagenum,5)){
                    GUIShow(current);
                }else{
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
    }




    public static void show() {

        JFrame frame = new JFrame("ReturnGUI");
        frame.setContentPane(new ReturnGUI().returnpanel);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }

    public static void main(String[] args) {
        show();
    }







}
