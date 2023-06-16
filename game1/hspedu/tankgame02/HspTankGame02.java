package game1.hspedu.tankgame02;

import javax.swing.*;

public class HspTankGame02 extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame02 hspTankGame01 = new HspTankGame02();

    }
    public HspTankGame02(){
        mp= new MyPanel();//定义一个面板。
        this.add(mp);//JFrame==>窗口添加...
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//到这里会自动调用paint方法。
    }
}
