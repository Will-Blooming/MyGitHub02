package rain.hspedu.threaduse;

public class Thread01 {
    public static void main(String[] args) throws Exception{

        //创建一个Cat对象，可以当作线程使用
        Thread cat = new Cat();
        cat.start();//启动线程。
        //在用start时，会调用run方法。
        /**
         * 源码：
         * 1.public synchronized void start() {
         *      start0();
         *      //往下。
         *      private native void start0();
         *      //start0()是一个本地方法，是由JVM机调用。底层是C/C++实现。
         *      //真正实现多线程的方法是start0()方法，而不是run方法。
         *}
         *
         */
        //为什么时start
        //如果用run方法，则就是一个普通的方法，当执行完该方法。才会指向下面的方法。
        //就是用run方法，没有开一个子线程。
        //产生阻塞。
        //cat.run();

        //当启动一个线程（main主线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行。）
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程i= " + i);
            Thread.sleep(1000);//public static native void sleep(
        }
    }
}

//类继承一个Thread类。该类就可以当作线程使用。
class Cat  extends Thread {
    /*
    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }
    */
    @Override
    public void run() { //这里的run方法，来自于Runnable接口。
        //在这里写自己的业务逻辑工作代码。。
        //需求1.每隔一秒输出一句我是一只小猫咪。
//        int time = 0;
//        while (true) {
//            System.out.println("我是一只小猫咪。" + (++time));
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //需求二：当输出8句，就自动退出。
        int time = 0;
        while (true) {
            System.out.println("我是一只小猫咪。" + (++time) + "线程名称： " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time == 80){
                break;
            }
        }
    }
}