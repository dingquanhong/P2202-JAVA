package GUI;

import classlib.system;
import fun.*;
import fun.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyinforGUI {
    String username;
    public JTextPane user;
    public JPasswordField passwordField1;
    public JTextField phone;
    public JButton updataButton;
    public JPanel Myinfor;
    public JLabel avatar;
    public MyinforGUI(int type,String username){
        user.setText(system.getUser());
        phone.setText(system.getPhone());
        passwordField1.setText(system.getPass());
        String path;
        if (system.getAvatar()==0){
            path = system.getDefaultavatar();
        }else {
            path = system.avatarpath();
        }

        avatar.setIcon(new ImageIcon(path));
        avatar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                file.avatarcopy("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\user\\"+system.getPhone()+".jpg");
                JBDC_User.editUserimg(system.getPhone(),1);
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
        updataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=user.getText();
                String phonenum = phone.getText();
                String password = String.valueOf(passwordField1.getPassword());
                JBDC_User.editUserData(system.getUserid(),phonenum,username,password);
            }
        });
    }
    public static void show(int type,String username) {

        JFrame frame = new JFrame("MyinforGUI");
        frame.setContentPane(new MyinforGUI(type,username).Myinfor);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }




}
