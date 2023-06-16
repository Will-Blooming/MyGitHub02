package rain.hspedu.state_;

public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {

        //线程状态。
        T t = new T();
        System.out.println(t.getState() + " 的状态：" + t.getState());
        t.start();

        //主线程
        while (Thread.State.TERMINATED != t.getState()){//如果当前的状态不等于结束状态。
            System.out.println(t.getState() + " 的状态：" + t.getState());
            Thread.sleep(1000);
        }

        System.out.println(t.getState() + " 的状态：" + t.getState());
    }
}

class T extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 1; i <= 10; i++) {
                System.out.println("ji..."+ i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName());
            }
            break;
        }
    }
}