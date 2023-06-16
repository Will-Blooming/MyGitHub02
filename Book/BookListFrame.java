package Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookListFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookListFrame frame = new BookListFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BookListFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 360);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(Color.BLACK);
        setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("文件");
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem = new JMenuItem("删除");
        mntmNewMenuItem.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/删除 (4).png"));
        mnNewMenu_1.add(mntmNewMenuItem);

        JSeparator separator = new JSeparator();
        mnNewMenu_1.add(separator);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("退出");
        mntmNewMenuItem_2.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/退出 (2).png"));
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenu mnNewMenu_2 = new JMenu("编辑");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("新建");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BookEditFrame frame1= new BookEditFrame();
                frame1.setVisible(true);

            }
        });
        mntmNewMenuItem_1.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/新建.png"));
        mnNewMenu_2.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_3 = new JMenu("排序");
        mnNewMenu_3.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/分期－热度排序.png"));
        mnNewMenu_2.add(mnNewMenu_3);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("按书名");
        mntmNewMenuItem_3.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/书.png"));
        mnNewMenu_3.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("按作者");
        mntmNewMenuItem_4.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/稿件-作者.png"));
        mnNewMenu_3.add(mntmNewMenuItem_4);

        JSeparator separator_1 = new JSeparator();
        mnNewMenu_3.add(separator_1);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("升序");
        mntmNewMenuItem_5.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/升序排序.png"));
        mnNewMenu_3.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("降序");
        mntmNewMenuItem_6.setIcon(new ImageIcon("/Users/panyonghui/Desktop/JavaEclipse图标/降序排序.png"));
        mnNewMenu_3.add(mntmNewMenuItem_6);

        JMenu mnNewMenu = new JMenu("帮助");
        menuBar.add(mnNewMenu);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
}