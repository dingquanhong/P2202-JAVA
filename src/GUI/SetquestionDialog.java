package GUI;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

public class SetquestionDialog extends JDialog {
    private JPanel contentPane;
    private JButton back;
    private JButton buttonCancel;
    private JTextField A1;
    private JTextField A2;
    private JTextField textField6;
    private JLabel R1;
    private JLabel R2;
    private JLabel R3;
    private JLabel R4;
    private JTextField A3;
    String phone;
    private static final int CODE_LENGTH = 4;

    private static final char[] CODE_CHARACTERS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    public SetquestionDialog(String phone) {
        this.phone = phone;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(back);
        setLocationRelativeTo(LoginGUI.frame);
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

    public static boolean judgePass(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(input);
            return true; // 格式正确
        } catch (ParseException e) {
            return false; // 格式错误
        }
    }


//    public static boolean borrowBook(int bookID, String borrowUserID) {
//        Date today = new Date();
//
//        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
//        String borrowData = Format.format(today);
//        Calendar returnDate = Calendar.getInstance();
//        returnDate.add(Calendar.DATE, 15);
//        String returndate = Format.format(returnDate.getTime());
//        Book BorrowBook = JBDC_Booklib.querryBookbyID(bookID);
//        boolean flag =  JBDC_Borrowlib.addBookData(BorrowBook.getid(),borrowUserID,borrowData,returndate,1);
//        return true;
//    }


    private void onCancel() {
        // 必要时在此处添加您的代码
        JLabel R1 = new JLabel();
        JLabel R2 = new JLabel();
        JLabel R3 = new JLabel();
        JLabel R4 = new JLabel();

        String code1 = generateCode();        // 生成第一个随机验证码并设置标签样式
        R1.setText(code1);
        R1.setForeground(generateRandomColor());
        R1.setFont(generateRandomFont());

        String code2 = generateCode();        // 生成第二个随机验证码并设置标签样式
        R2.setText(code2);
        R2.setForeground(generateRandomColor());
        R2.setFont(generateRandomFont());

        String code3 = generateCode();        // 生成第三个随机验证码并设置标签样式
        R3.setText(code3);
        R3.setForeground(generateRandomColor());
        R3.setFont(generateRandomFont());

        String code4 = generateCode();        // 生成第四个随机验证码并设置标签样式
        R4.setText(code4);
        R4.setForeground(generateRandomColor());
        R4.setFont(generateRandomFont());
        dispose();
    }

    private void okButton() {
        RegisterDialog dialog = new RegisterDialog(this.phone, 1);
        dialog.pack();
        dialog.setVisible(true);
        this.setVisible(false);

        String userInput = A3.getText();                          // 获取用户输入的生日字符串
        boolean isFormatCorrect = judgePass(userInput);
        if (isFormatCorrect) {
            System.out.println("生日格式正确！");
        } else {
            System.out.println("生日格式错误！");
        }

    }

    public static void main(String[] args) {
//        JLabel R1 = new JLabel();
//        JLabel R2 = new JLabel();
//        JLabel R3 = new JLabel();
//        JLabel R4 = new JLabel();
//
//        String code1 = generateCode();        // 生成第一个随机验证码并设置标签样式
//        R1.setText(code1);
//        R1.setForeground(generateRandomColor());
//        R1.setFont(generateRandomFont());
//
//        String code2 = generateCode();        // 生成第二个随机验证码并设置标签样式
//        R2.setText(code2);
//        R2.setForeground(generateRandomColor());
//        R2.setFont(generateRandomFont());
//
//        String code3 = generateCode();        // 生成第三个随机验证码并设置标签样式
//        R3.setText(code3);
//        R3.setForeground(generateRandomColor());
//        R3.setFont(generateRandomFont());
//
//        String code4 = generateCode();        // 生成第四个随机验证码并设置标签样式
//        R4.setText(code4);
//        R4.setForeground(generateRandomColor());
//        R4.setFont(generateRandomFont());
        SetquestionDialog dialog = new SetquestionDialog("11111111111");
        dialog.pack();
        dialog.setVisible(true);

    }



    public static String generateCode() {
        StringBuilder code = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CODE_CHARACTERS.length);
            code.append(CODE_CHARACTERS[index]);
        }

        return code.toString();
    }
    private static Color generateRandomColor() {            //设置随机字体颜色
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

    private static Font generateRandomFont() {            //设置随机字体风格
        Random random = new Random();
        int style = random.nextInt(4); // 随机字体风格：PLAIN, BOLD, ITALIC, or BOLD+ITALIC
        int size = random.nextInt(10) + 18;            // 字体大小范围：18-27
        return new Font(Font.SANS_SERIF, style, size);
    }
}