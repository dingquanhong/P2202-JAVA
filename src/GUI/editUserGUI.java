package GUI;

import classlib.*;
import fun.JBDC_User;

import javax.swing.*;
import java.awt.event.*;

public class editUserGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField phone;
    private JButton editButton;
    private JTextField username;
    private JPasswordField passwordField1;

    public editUserGUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phonenum = phone.getText();
                User user = JBDC_User.querryUserbyPhone(phonenum);
                username.setText(user.getUser());
                passwordField1.setText(user.getPass());
            }
        });
    }

    private void onOK() {
        // 在此处添加您的代码
        String phonenum = phone.getText();
        User user =JBDC_User.querryUserbyPhone(phonenum);
        user.setUser(username.getText());
        user.setPass(String.valueOf(passwordField1.getPassword()));
        JBDC_User.editUserbyPhone(phonenum,user);
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args) {
        editUserGUI dialog = new editUserGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
