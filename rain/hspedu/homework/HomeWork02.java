package rain.hspedu.homework;

public class HomeWork02 {
    public static void main(String[] args) {

        //
        T3 t31 = new T3();
        t31.setName("t1");
        T3 t32 = new T3();
        t32.setName("t2");
        t31.start();
        t32.start();
    }
}

class T3 extends Thread {

    static int money = 10000;
    private static Object object = new Object();

//    public synchronized void fetch() {//取钱
//        while (true) {
//            if (money < 1000) {
//                System.out.println("余额不足...");
//                break;
//            }
//            System.out.println(Thread.currentThread().getName() + "取走1000块钱" + "  剩余" + (money -= 1000));
//        }
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void run() {//在这里加syn，门就在这里，所以一个对象就开始循环直到没钱。
        //fetch();
        while (true) {
            synchronized (object) { //每次只能进来一个对象。
                if (money < 1000) {
                    System.out.println("余额不足...");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "取走1000块钱" + "  剩余" + (money -= 1000));
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}