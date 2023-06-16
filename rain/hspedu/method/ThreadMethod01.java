package rain.hspedu.method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        t.setName("乐乐");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();
        //主线程输出5句hi，就中断子线程。
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi..." + i);
        }

        System.out.println(t.getName() + "的优先级 " + t.getPriority());
        t.interrupt();//这里的*中断*只是结束本次休眠进行下一次循环。

    }
}

class T extends Thread {
    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 吃包子~ " + i);
            }

            try {
                System.out.println(Thread.currentThread().getName() + " 正在休眠中~");
                Thread.sleep(20 * 1000);

            } catch (InterruptedException e) {//当捕获到这个异常的时候，就会阻断睡眠。进行下一次循环(代码往下执行。)。
                System.out.println(Thread.currentThread().getName() + " 被阻断了~");
            }
        }
    }
}