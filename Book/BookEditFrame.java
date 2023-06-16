package Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BookEditFrame extends JFrame {

    private JPanel contentPane;

    private JTextField TFISBN;
    private JTextField TFTitle;
    private JTextField TFAuthor;
    private JTextField TFPrice;
    private BookEditFrame frame;


    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public BookEditFrame() {
        frame=this;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 514, 338);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        TextField textField = new TextField();
        textField.setBounds(136, 21, 283, 22);
        contentPane.add(textField);

        JLabel lblNewLabel = new JLabel("ISBN");
        lblNewLabel.setBounds(69, 21, 61, 16);
        contentPane.add(lblNewLabel);

        TextField textField_1 = new TextField();
        textField_1.setBounds(136, 74, 283, 22);
        contentPane.add(textField_1);

        JLabel lblNewLabel_1 = new JLabel("书名");
        lblNewLabel_1.setBounds(69, 80, 61, 16);
        contentPane.add(lblNewLabel_1);

        TextField textField_2 = new TextField();
        textField_2.setBounds(136, 129, 283, 22);
        contentPane.add(textField_2);

        JLabel lblNewLabel_2 = new JLabel("作者");
        lblNewLabel_2.setBounds(69, 135, 61, 16);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("价格");
        lblNewLabel_3.setBounds(69, 194, 61, 16);
        contentPane.add(lblNewLabel_3);

        TextField textField_3 = new TextField();
        textField_3.setBounds(136, 188, 283, 22);
        contentPane.add(textField_3);

        JButton btnNewButton = new JButton("保存");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String isbn = textField.getText();
                String title = textField_1.getText();
                String author = textField_2.getText();
                String price = textField_3.getText();

                String filename = "D:\\book02.txt";
                List<String> lineList = new LinkedList<>();
                try

                        (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        lineList.add(line);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                try {

                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));

                    for (String line : lineList) {
                        writer.write(line);
                        writer.newLine();
                        ;

                    }
                    String line = isbn + "," + title + "," + author + "," + price;
                    writer.write(line);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                frame.dispose();
            }
        });
        btnNewButton.setBounds(114, 249, 117, 29);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("取消");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //frame.setVisible(false);//第一个方法
                frame.dispose();//第二个方法一样的效果
            }
        });
        btnNewButton_1.setBounds(302, 249, 117, 29);
        contentPane.add(btnNewButton_1);
    }
}
