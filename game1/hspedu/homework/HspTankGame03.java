package game1.hspedu.homework;

import javax.swing.*;

public class HspTankGame03 extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {

        HspTankGame03 hspTankGame03 = new HspTankGame03();

    }
    public HspTankGame03(){
        mp= new MyPanel();//定义一个面板。
        this.add(mp);//JFrame==>窗口添加...
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//到这里会自动调用paint方法。
    }
}
