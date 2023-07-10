package GUI;

import classlib.Borrowrecord;
import fun.*;
import classlib.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class OverduemanageGUI {
    private JTable table1;
    private JButton Urge;
    private JPanel Overduce;
    public OverduemanageGUI(){
        DefaultTableModel tableModel=(DefaultTableModel) this.table1.getModel();
        tableModel.setRowCount(0);    //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"序号","借阅图书","借阅时间","借阅人手机号"});    //设置表头
        List<Borrowrecord> borrowrecords = JBDC_Borrowlib.readBorrowData();
        List<String[]> result = new ArrayList<>();
        int i =1;

        for(Borrowrecord record :borrowrecords){
            if (DateFun.calDate(record.getReturenDate())<0){
                String bookname = JBDC_Booklib.querryBookbyID(record.getBorrowBookID()).getbookname();
                String borrowdata = record.getBorrowDate();
                String borrowuser = record.getBorrowUserID();
                result.add(new String[]{String.valueOf(i),bookname,borrowdata,borrowuser});
                i++;
            }



        }
        for (String[] row :result){
            tableModel.addRow(row);
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("OverduemanageGUI");
        frame.setContentPane(new OverduemanageGUI().Overduce);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }

    public static void show() {
        JFrame frame = new JFrame("OverduemanageGUI");
        frame.setContentPane(new OverduemanageGUI().Overduce);
        Window.tocenter(frame);
        frame.pack();
        frame.setVisible(true);
    }
}
