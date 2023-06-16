package game1.hspedu.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{
    private MyPanel mp = null;//定义一个面板
    public static void main(String[] args) {
        //在面板上画圆。
        new DrawCircle();//构造器初始化。执行里面的代码。

    }
    public DrawCircle(){//构造器
        mp = new MyPanel();//初始化面板。这里的的面板就是下面这个面板。
        this.add(mp);//把面板放到窗口中。
        this.setSize(400,300);//设置窗口的大小
        //当点击窗口的小叉号，程序就完全退出。
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可见
        //第一次可视化==>自动调用paint方法。
    }
}

//1.定义一个面板(画板)，继承一个JPanel类=>java提供的一个类，画图型就在这个面板上画。
class MyPanel extends JPanel {

    @Override
    public void paint(Graphics g) {//paint==>油漆==>用来绘图的一个方法。
        //Graphics g ==> 绘图==>可以理解成一支画笔。
        //Graphics 提供了很多绘图的方法。
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("===paint方法被调用===");
        g.drawOval(10,10,100,100);//圆


        //绘制不同的图形
        //1.直线
//        g.drawLine(10,10,100,100);//x1 y1为起始点，x2 y2 为终点。

        //2.矩形边框
//        g.drawRect(10,10,100,100);

        //3.填充矩形：
//        g.setColor(Color.CYAN);
//        g.fillRect(10,10,100,100);

        //4.填充椭圆
//        g.setColor(Color.ORANGE);
//        g.fillOval(10,10,100,100);

        //5.画图片。
        //(1)获取图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage("c:\\File\\sun.jpg");
//        g.drawImage(image,10,10,192,144,this);

        //6.画字符串：写字。
        //先给画笔设置颜色和字体。
        g.setColor(Color.RED);
        g.setFont(new Font("楷书",Font.BOLD, 30));//字体，粗体，大小
        g.drawString("乐乐",100,100);//这里的x y时文字的左下角。
    }
}