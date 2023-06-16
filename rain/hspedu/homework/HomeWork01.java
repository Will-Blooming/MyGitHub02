package rain.hspedu.homework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
        T2 t2 = new T2(t1);
        t2.start();
    }
}

class T1 extends Thread {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        int count = 0;
        while (loop) {
            Random random = new Random();
            int num = random.nextInt(100) + 1;
            System.out.println("num=" + num + " " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("t1线程退出...");
    }
}

class T2 extends Thread {
    private T1 t1;
    private Scanner scanner = new Scanner(System.in);
    public T2(T1 t1){
        this.t1 = t1;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("请输入你的指令（Q）表示退出...");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q'){
                t1.setLoop(false);
                System.out.println("t2线程退出..");
                break;
            }
        }
    }
}
