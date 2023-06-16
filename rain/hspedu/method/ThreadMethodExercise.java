package rain.hspedu.method;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        thread.start();

        int num = 0;
        for (int i = 0; i < 10; i++) {
            ++num;
            Thread.sleep(1000);
            System.out.println("主线程hi..." + (i + 1));

            if (num == 5){
                thread.join();
            }
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程hello..." + i);
        }
    }
}
