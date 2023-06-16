package rain.hspedu.threaduse;

import adamancy.hspedu.modifier.A;

public class Thread02 {
    public static void main(String[] args) {
        //通过实现Runnable接口来开发线程
        Runnable dog = new Dog();//多态
        //dog.start();这里不能用start方法

        //下面书创建了Thread对象，把dog对象（实现了Runnable接口的对象）放入到Thread。
        Thread thread = new Thread(dog);
        //public Thread(Runnable target) {
        //        init(null, target, "Thread-" + nextThreadNum(), 0);
        //    }

        thread.start();//和下面模仿的代理模式过程一样。
        //==>start0();
        //==>run();
        //动态绑定。==> 执行dog里的run方法。

//模拟：
//        //过程：
//        Tiger tiger = new Tiger();//实现Runnable接口
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.start();

    }
}

//class Animal{}
//class Tiger extends Animal implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("老虎嗷嗷叫~");
//    }
//}
////静态代理设计模式==>线程代理类==>模拟了一个极简的Thread类
//class ThreadProxy implements Runnable {
//
//    private Runnable target = null;
//
//    @Override
//    public void run() {
//        if (target != null) {
//            target.run();//动态绑定==>tiger.run().==>输出老虎嗷嗷叫~
//        }
//    }
//
//    public ThreadProxy(Runnable target) {
//        this.target = target;
//    }
//
//    public void start() {
//        start0();
//    }
//
//    public void start0() {
//        run();
//    }
//}


class Dog implements Runnable {

    int count = 0;

    @Override
    public void run() {//重写的方法并未抛出异常。所以这里不能抛出异常
        while (true) {
            System.out.println("小狗汪汪叫~ hi" + (++count) + "线程名称 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}
