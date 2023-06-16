package rain.hspedu.threaduse;

public class Thread_ {
    public static void main(String[] args) {

        T4 t40 = new T4();
        T4 t41 = new T4();
        t40.start();
        t41.start();
    }
}
class T4 extends Thread{

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello~world~" + (++count) + "线程的名字" + Thread.currentThread().getName());
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