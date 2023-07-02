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
                if (ReturnFun.returnbook(current,1)){
                    JOptionPane.showMessageDialog(null,"归还成功");

                }else {
                    JOptionPane.showMessageDialog(null,"归还失败");
                }

            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(current,1)){
                    JOptionPane.showMessageDialog(null,"归还成功");

                }else {
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(current,1)){
                    JOptionPane.showMessageDialog(null,"归还成功");

                }else {
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(current,1)){
                    JOptionPane.showMessageDialog(null,"归还成功");

                }else {
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ReturnFun.returnbook(current,1)){
                    JOptionPane.showMessageDialog(null,"归还成功");

                }else {
                    JOptionPane.showMessageDialog(null,"归还失败");
                }
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
                current  = 1;
                GUIShow(current);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current =current+1;
                GUIShow(current);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current=Integer.parseInt(ReturnFun.getMaxPagenum());
                GUIShow(current);
            }
        });
    }

    public  void GUIShow(int curentpagenum){
        this.page.setText(String.valueOf(curentpagenum)+"/"+ ReturnFun.getMaxPagenum());
        System.out.println(ReturnFun.getBookname(curentpagenum,1));
        this.name1.setText(ReturnFun.getBookname(curentpagenum,1));
        this.name2.setText(ReturnFun.getBookname(curentpagenum,2));
        this.name3.setText(ReturnFun.getBookname(curentpagenum,3));
        this.name4.setText(ReturnFun.getBookname(curentpagenum,4));
        this.name5.setText(ReturnFun.getBookname(curentpagenum,5));

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

        this.detail1.setText(ReturnFun.getBookname(curentpagenum,1));
        this.detail2.setText(ReturnFun.getBookname(curentpagenum,2));
        this.detail3.setText(ReturnFun.getBookname(curentpagenum,3));
        this.detail4.setText(ReturnFun.getBookname(curentpagenum,4));
        this.detail5.setText(ReturnFun.getBookname(curentpagenum,5));


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





   //     Connection connection = JBDC_Control.getConnection();


}
