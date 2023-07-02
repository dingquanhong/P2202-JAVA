package GUI;

import classlib.*;
import fun.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ReturnGUI {
    int current = 1;
    private JPanel returnpanel;
    private JButton B1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel name1;
    private JLabel detail1;
    private JLabel name2;
    private JLabel detail2;
    private JLabel name3;
    private JLabel detail3;
    private JLabel name4;
    private JLabel detail5;
    private JLabel name5;
    private JLabel detail4;
    private JButton B5;
    private JButton B4;
    private JButton B3;
    private JButton B2;
    private JLabel page;
    private JPanel Book1;
    private JPanel Book2;
    private JPanel Book3;
    private JPanel Book4;
    private JPanel Book5;


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
        page.setText(curentpagenum+"/"+ReturnFun.getMaxPagenum());
        name1.setText(ReturnFun.getbookname(curentpagenum,1));

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
