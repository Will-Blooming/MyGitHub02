package rain.hspedu.syn;

import adamancy.hspedu.modifier.A;

public class DeadLock_ {
    public static void main(String[] args) {

        //线程死锁。
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();//保证多线程共享一个对象。
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        //分析下面代码的业务逻辑:
        /*
            1.如果flag为T，线程A就会得到/持有o1对象锁，然后去尝试获取o2对象锁。
            2.如果得不到o2对象锁，就会产生阻塞。
            3.如果flag为F，线程A就会得到/持有o2对象锁，然后去尝试获取o1对象锁。
            4.如果得不到o1对象锁，就会产生阻塞。
         */
        if (flag) {
            synchronized (o1) { //对象为互斥锁，进来的对象同步下面的代码
                System.out.println(Thread.currentThread().getName() + " 进入1..");

                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2..");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3..");

                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4..");
                }
            }
        }
    }
}