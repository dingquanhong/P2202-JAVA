package GUI;
import fun.JBDC_User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import classlib.*;
public class SetquestionDialog extends JDialog {
    private JPanel contentPane;
    private JButton back;
    private JButton buttonCancel;
    private JTextField A1;
    private JTextField A2;
    private JTextField verify;
    private JLabel V1;
    private JLabel V2;
    private JLabel V3;
    private JLabel V4;
    private JTextField A3;
    String phone;


    public SetquestionDialog(String phone) {
        this.phone = phone;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(back);
        setLocationRelativeTo(LoginGUI.frame);
        verifyShow();
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okButton();
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

    }




    private void onCancel() {
        String a1 = A1.getText();
        String a2 = A2.getText();
        String a3 = A3.getText();
        String verifyinput = verify.getText();
        String systemverify = V1.getText()+V2.getText()+V3.getText()+V4.getText();
        if (a1.equals("")||a2.equals("")||a3.equals("")){
            JOptionPane.showMessageDialog(null,"密保问题不能为空");
        }else if (!systemverify.equals(verifyinput)){
            JOptionPane.showMessageDialog(null,"验证码错误");
            verifyShow();
        }else {
            JBDC_User.editQuestionbyPhone(phone,a1,a2,a3);
            dispose();
        }

    }

    private void okButton() {

        RegisterDialog dialog = new RegisterDialog(this.phone,1);
        dialog.pack();
        dialog.setVisible(true);
        this.setVisible(false);

    }
    public static int GenerateVcode(){
        int Vcode = (int) (Math.random()*11+1);
        return Vcode;
    }
    public static Color GenerateColor(){
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        Color randColor = new Color(r,g,b);
        return randColor;
    }

    public void verifyShow(){
        this.V1.setText(String.valueOf(GenerateVcode()));
        this.V2.setText(String.valueOf(GenerateVcode()));
        this.V3.setText(String.valueOf(GenerateVcode()));
        this.V4.setText(String.valueOf(GenerateVcode()));
        this.V1.setForeground(GenerateColor());
        this.V2.setForeground(GenerateColor());
        this.V3.setForeground(GenerateColor());
        this.V4.setForeground(GenerateColor());

    }

    public static void main(String[] args) {
        SetquestionDialog dialog = new SetquestionDialog("11111111111");
        dialog.pack();
        dialog.setVisible(true);
    }







}