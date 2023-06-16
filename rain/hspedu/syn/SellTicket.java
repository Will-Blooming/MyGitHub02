package rain.hspedu.syn;

@SuppressWarnings({"ALL"})
public class SellTicket {
    public static void main(String[] args) {
        //售票系统:模拟三个系统同时售票

//        Windows windows1 = new Windows();
//        Windows windows2 = new Windows();
//        Windows windows3 = new Windows();
//        windows1.start();
//        windows2.start();
//        windows3.start();

        Windows02 windows02 = new Windows02();
        Thread thread1 = new Thread(windows02);
        Thread thread2 = new Thread(windows02);
        Thread thread3 = new Thread(windows02);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

@SuppressWarnings({"ALL"})
class Windows extends Thread {
    static int num = 100;

    public void m1(){
        synchronized (this){//这里不会锁住，因为this所代表的对象不是同一个。new 了三个windows对象。
            System.out.println("m1");
        }
    }
    @Override
    public void run() {
        while (true) {

            if (num <= 0) {
                System.out.println("票数不足~，不能再卖。");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + "卖出一张票 " + "剩余票数为：" + (--num));
        }
    }
}


@SuppressWarnings({"ALL"})
class Windows02 implements Runnable{
    static Integer num = 100;
    private boolean loop = true;
    Object object = new Object();

    //静态同步方法：
    public synchronized static void m1() {
    }//这里的对象锁是Windows02.class对象。

    //同步代码块: 对象锁是类名 + class
    public static void m2() {
        synchronized (Windows02.class) {
            System.out.println("m2");
        }
    }

    public /*synchronized*/ void sell() {//同步方法：同一时刻只能有一个线程来执行run方法。
        synchronized (object /*new Object()*/) {//这里的对象只要是**同一个对象**就可以。
            if (num <= 0) {
                System.out.println("票数不足了~，不能再卖。");
                loop = false;
                return;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + "卖出一张票 " + "剩余票数为：" + (--num));
        }
    }

    @Override
    public void run() {//直接同步run方法，不太合理。
        while (loop) {
            sell();
        }
    }
}