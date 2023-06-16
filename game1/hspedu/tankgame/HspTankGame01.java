package game1.hspedu.tankgame;

import javax.swing.*;

public class HspTankGame01 extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame01 hspTankGame01 = new HspTankGame01();

    }
    public HspTankGame01(){
        mp= new MyPanel();//定义一个面板。
        this.add(mp);//JFrame==>窗口添加...
        this.setSize(1000,750);
        //this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//到这里会自动调用paint方法。
    }
}
