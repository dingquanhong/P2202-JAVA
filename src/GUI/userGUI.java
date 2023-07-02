package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import classlib.*;
import fun.Window;

public class userGUI{

    private JButton exitButton;
    private JPanel user;

    private JLabel avatar;


    private JLabel username;
    private JTabbedPane tabbedPane1;
    private JButton BorrowButton;
    private JButton ReturnButton;
    private JTabbedPane tabbedPane2;
    private JLabel F1;
    private JLabel F2;
    private JLabel F3;
    private JLabel F4;
    private JLabel F5;

    public userGUI(){

        BorrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowGUI.show();
            }
        });
        ReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnGUI.show();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        avatar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MyinforGUI.show(0,system.getUser());
                super.mouseClicked(e);
            }
        });
        String path = system.getDefaultavatar();


        avatar.setIcon(new ImageIcon(path));

        F1.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\1.jpg"));
        F2.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\2.jpg"));
        F3.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\4.jpg"));
        F4.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\5.jpg"));
        F5.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\7.jpg"));

    }




    public static void show() {
        JFrame frame = new JFrame("userGUI");
        frame.setContentPane(new userGUI().user);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);

    }

    public static void main(String[] args) {
        show();
    }


}
