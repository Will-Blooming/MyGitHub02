package game1.hspedu.event;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {
    //事件==>演示小球，通过键盘控制上下左右移动==>java的事件控制
    private MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();

    }

    private BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.addKeyListener(mp);//JFrame窗口对象可以监听我们的键盘事件==>即可以监听到面板上发生的时间。
        //addKeyListener(KeyListener l)==>MyPanel mp 实现了接口KeyListener，所以能把mp传入。
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//实现移动==>KeyListener==>监听器，可以监听键盘事件。
class MyPanel extends JPanel implements KeyListener {
    //为了方便移动，把x y设为变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);//填充的小球，默认为黑色
    }

    @Override
    public void keyTyped(KeyEvent e) {//监听字符的输入，有字符输出，就会触发该方法。

    }

    @Override
    public void keyPressed(KeyEvent e) {//当某个键摁下，会触发该方法
        //System.out.println((char) e.getKeyCode() + "被摁下");
        //根据用户摁下不同键，来处理小球的移动（上下左右）
        if (!(x <= 0 || y < 0 || x >= 400 || y >= 300)) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) { //KeyEvent.VK_DOWN就是向下的箭头对应的code
                //注意：在java中，会给每一个键，分配一个(int)值
                y += 5;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                y -= 5;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                x -= 5;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                x += 5;
            }
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {//当某个键松开，该方法触发。

    }
}