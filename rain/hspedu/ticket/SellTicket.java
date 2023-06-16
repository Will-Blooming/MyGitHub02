package rain.hspedu.ticket;

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
class Windows02 implements Runnable {
    static Integer num = 100;

    @Override
    public void run() { //同步方法：同一时刻只能有一个线程来执行run方法。
        while (true) {

            if (num <= 0) {
                System.out.println("票数不足了~，不能再卖。");
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