package rain.hspedu.method;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        //守护线程 : 当主线程退出，子线程也退出。
        //只需要将子线程设成守护线程
        T3 t3 = new T3();
        t3.setDaemon(true);
        t3.start();//先设置，在启动，注意顺序。
        for (int i = 1; i <= 10 ; i++) {
            Thread.sleep(1000);
            System.out.println("我在work~~");
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        for (; ; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我在学习~~");
        }
    }
}