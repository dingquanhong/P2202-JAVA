package GUI;

import classlib.User;
import fun.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UaerManage {
    private JButton delButton;
    private JPanel UserManage;
    private JButton editButton;
    private  JPanel panel;
    private  JTable table1;



    public UaerManage() {
        DefaultTableModel tableModel=(DefaultTableModel) this.table1.getModel();
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"序号","用户名","手机号"});    //设置表头
        List<User> users = JBDC_User.readUserData();
        List<String[]> result = new ArrayList<>();
        int i =1;

        for(User user :users){

           result.add(new String[]{String.valueOf(i),user.getUser(),user.getPhone()});

            i++;
        }

        for (String[] row :result){
            tableModel.addRow(row);
        }

        this.table1.setRowHeight(30);
        this.table1.setModel(tableModel);
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               String inputPhone =  JOptionPane.showInputDialog("请输入你要删除的用户手机号");
               if (JBDC_User.deleteUserbyPhone(inputPhone)){
                    JOptionPane.showMessageDialog(null,"删除成功");
            }
        }});
        editButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                editUserGUI dialog = new editUserGUI();
                dialog.pack();
                dialog.setVisible(true);
                System.exit(0);
            }

        });



    }

    public static void show() {


        JFrame frame = new JFrame("UaerManage");
        frame.setContentPane(new UaerManage().UserManage);
        Window.tocenter(frame);
        frame.pack();
        frame.setVisible(true);
    }


}


