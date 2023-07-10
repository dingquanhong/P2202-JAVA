package GUI;

import fun.Adminfun;
import fun.BookmanagementFun;
import fun.Window;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import classlib.*;

public class AdminGUI {
    private JTabbedPane tabbedPane1;

    private JPanel admin;
    private JLabel Myinfor;
    private JLabel BookM;
    private JLabel UserM;
    private JLabel OutM;
    private JLabel img1;
    private JLabel img3;
    private JLabel img2;
    private JLabel borrownum;
    private JLabel booknum;
    private JLabel outrreduce;
    private JLabel avatar;

    public AdminGUI() {
        img1.setIcon(new ImageIcon(BookmanagementFun.getBookimg(1,1)));
        img2.setIcon(new ImageIcon(BookmanagementFun.getBookimg(1,2)));
        img3.setIcon(new ImageIcon(BookmanagementFun.getBookimg(1,3)));
        borrownum.setText(String.valueOf(Adminfun.getborrownum()));
        booknum.setText(String.valueOf(Adminfun.getbooknum()));
        outrreduce.setText(String.valueOf(Adminfun.getreducenum()));
        avatar.setIcon(new ImageIcon(system.getDefaultavatar()));
        Myinfor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MyinforGUI.show(1,system.getUser());
                super.mouseClicked(e);
            }
        });
        BookM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bookmanagement.show();
                super.mouseClicked(e);
            }
        });
        OutM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OverduemanageGUI.show();
                super.mouseClicked(e);
            }
        });
        UserM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UaerManage.show();
                super.mouseClicked(e);
            }
        });

    }

    public static void show() {
        JFrame frame = new JFrame("AdminGUI");
        frame.setContentPane(new AdminGUI().admin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);

    }

}
