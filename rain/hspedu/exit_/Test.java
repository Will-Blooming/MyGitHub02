package rain.hspedu.exit_;

public class Test {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 开启发送线程

        // 开启重发线程
        send s = new send();
        s.start();
        // 监听服务器的反馈
        receive r = new receive(s);
        r.start();
    }

}

class send extends Thread {

    //重发计数
    int r = 0;

    public void run() {

        while (r < 3) {
            try {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                r++;
                sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("1111111111");
    }
}


// 业务主线程，负责接收服务器端的消息
class receive extends Thread {
    private Thread subThread;

    public receive(Thread thread) {
        subThread = thread;
    }

    public void run() {

        // 使SEND线程结束
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        subThread.suspend();

        System.out.println("关闭");

    }
}


