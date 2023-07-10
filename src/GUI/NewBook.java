package GUI;


import fun.*;
import fun.Window;
import classlib.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class NewBook {
    public JTextField bookname;
    public JTextField author;
    public JTextArea describe;
    public JTextField ISBN;
    public JTextField price;
    public JButton addbookButton;

    public NewBook() {
        img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                file.uploadbook("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+getbookid()+".jpg");
                img.setIcon(new ImageIcon("D:\\Project\\Project practice\\P2202\\P2202-JAVA\\src\\bin\\book\\"+getbookid()+".jpg"));
                super.mouseClicked(e);
            }
        });

        addbookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book =bookname.getText();
                String authorinput = author.getText();
                String des = describe.getText();
                float pricenum =Integer.parseInt(price.getText());
                String ISBNinput =ISBN.getText();
                float SCORE = Float.parseFloat(score.getText());
                Book newbook = new Book(getbookid(),book,authorinput,"",des,ISBNinput,pricenum,SCORE,0);
                JBDC_Booklib.addBookData(newbook);
            }
        });
    }

    private JPanel Newbook;
    private JLabel img;
    private JTextField score;

    public static void show() {
        JFrame frame = new JFrame("NewBook");
        frame.setContentPane(new NewBook().Newbook);

        frame.pack();
        frame.setVisible(true);
        Window.tocenter(frame);
    }
    public int getbookid(){
        List<Book> books = JBDC_Booklib.readBookData();
        Book lastbook =books.get(books.size()-1);
        int bookid = lastbook.getid()+1;
        return bookid;
    }
}
