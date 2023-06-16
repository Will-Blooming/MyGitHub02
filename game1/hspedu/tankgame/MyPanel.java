package game1.hspedu.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings({"ALL"})
public class MyPanel extends JPanel {
    //坦克大战的一个绘图区域
    //定义我的坦克；
    MyTank myTank = null;
//    private int x = 100;
//    private int y = 100;

    public MyPanel() {
        myTank = new MyTank(100, 100);//坦克的坐标。
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色。作为背景
//        g.setColor(Color.CYAN);
//        g.fillRect(50,50,50,200);
//        g.fillRect(175,50,50,200);
//        g.fillRect(100,75,75,150);
//        g.drawLine(137,25,137,150);
//        g.setColor(Color.blue);
//        g.fillOval(100,100,75,75);
        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);
        drawTank(myTank.getX() + 100, myTank.getY(), g, 1, 0);
        drawTank(myTank.getX() + 200, myTank.getY(), g, 2, 0);
        drawTank(myTank.getX() + 300, myTank.getY(), g, 3, 0);
    }

    //画坦克-封装到方法里。

    /**
     * @param x         : 坦克的左上角x坐标
     * @param y         ：坦克的左上角y坐标
     * @param g         ：画笔
     * @param direction ： 坦克方向(四个方向)
     * @param type      ： 类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        switch (type) {//类型
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人坦克
                g.setColor(Color.yellow);
        }

        //根据坦克方向，绘制坦克
        switch (direction) {//0上 1右 2下 3左
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//左轮子。
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子。
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间的矩形==>盖子。
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖子。
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//左轮子。
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮子。
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的矩形==>盖子。
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖子。
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//左轮子。
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子。
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间的矩形==>盖子。
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖子。
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//左轮子。
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮子。
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间的矩形==>盖子。
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖子。
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
                break;
            default:
                System.out.println("暂时不处理~");
        }
    }


//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }

//    @Override
//    public void keyPressed(KeyEvent e) {
//        if (!(x <= 0 || y < 0 || x >= 1000 || y >= 750)) {
//            if (e.getKeyCode() == KeyEvent.VK_DOWN) { //KeyEvent.VK_DOWN就是向下的箭头对应的code
//                //注意：在java中，会给每一个键，分配一个(int)值
//                y += 5;
//            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
//                y -= 5;
//            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//                x -= 5;
//            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                x += 5;
//            }
//            this.repaint();
//        }
//    }

//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
}
