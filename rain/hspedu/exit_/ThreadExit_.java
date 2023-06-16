package rain.hspedu.exit_;

public class ThreadExit_ { //出口
    public static void main(String[] args) throws InterruptedException {

        T t = new T();//这里的t和下面的t1不是同一个线程。
        t.start();

        //再主线程中控制子线程的起止。
        System.out.println("主线程等待1s...");
        Thread.sleep(1000); //通知方式
        t.setLoop(false);//让t退出run方法，从而终止该线程。

//        T2 t2 = new T2();
//        t2.start();
    }
}

//class T2 extends Thread {
//
//    @Override
//    public void run() {
//        T t1 = new T();
//        t1.interrupt();
//
//    }
//
//}

class T extends Thread {
    int count = 0;

    boolean loop = true;//控制变量。

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T正在运行..." + (++count));
        }
    }
}