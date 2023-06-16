package rain.hspedu.threaduse;

public class Runnable_ {
    public static void main(String[] args) {
        T3 t3 = new T3();
        Thread thread1 = new Thread(t3);
        Thread thread2 = new Thread(t3);
        thread1.start();
        thread2.start();
    }
}

class T3 implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello-world~" + (++count) + "线程的名字" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);//public static native void sleep(
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}