package rain.hspedu.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        //插队
        //boolean loop = true;
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();
        int num = 0;
        while (true) {
            Thread.sleep(1000);
            ++num;
            System.out.println("hi...");
            if (num == 5){
                thread.join();
            }
        }
    }
}

class T1 implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello...");
        }
    }
}