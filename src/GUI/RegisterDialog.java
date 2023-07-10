package GUI;

import javax.swing.*;
import java.awt.event.*;

import fun.*;

public class RegisterDialog extends JDialog {
    private JPanel contentPane;
    private JButton nextButton;
    private JButton cancelButton;
    private JTextField username;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField phone;
    int type;
    String phonenum;
    public RegisterDialog(String phone,int type) {
        this.phonenum = phone;
        this.type=type;
        if (type==1){
            this.username.setText(JBDC_User.querryUserbyPhone(this.phonenum).getUser());
            this.phone.setText(JBDC_User.querryUserbyPhone(this.phonenum).getPhone());
            this.passwordField1.setText(JBDC_User.querryUserbyPhone(this.phonenum).getPass());
            this.passwordField2.setText(JBDC_User.querryUserbyPhone(this.phonenum).getPass());
        }
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(nextButton);
        setLocationRelativeTo(LoginGUI.frame);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
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
    }

    private void onOK() {
        switch (this.type){
            case 0:
                String username = this.username.getText();
                String pass1 = String.valueOf(this.passwordField1.getPassword());
                String pass2 = String.valueOf(this.passwordField2.getPassword());
                String phone = this.phone.getText();
                String haveerro = RegisterFUN.Register(username,pass1,pass2,phone);

                if (haveerro.equals("")){
                    this.setVisible(false);
                    JBDC_User.addUserData(username,pass1,phone);
                    int listnum = RegisterFUN.getlistnum();
                    for(int i = 1;i<=3;i++){
                        JBDC_User_booklist.insert(listnum+i,phone,"");
                    }
                    SetquestionDialog dialog = new SetquestionDialog(phone);
                    dialog.pack();
                    dialog.setVisible(true);
                    System.exit(0);
                }else {
                    JOptionPane.showMessageDialog(this,haveerro);
                }
                break;
            case 1:

                SetquestionDialog dialog = new SetquestionDialog(this.phonenum);
                dialog.pack();
                dialog.setVisible(true);
                System.exit(0);
                break;
        }


    }

    private void onCancel() {
       dispose();
    }


    public RegisterDialog(String username,String pass1,String pass2,String phone){
        this.username.setText(username);
        this.passwordField1.setText(pass1);
        this.passwordField2.setText(pass2);
        this.phone.setText(phone);
    }
}
