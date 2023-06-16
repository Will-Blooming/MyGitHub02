package rain;

public class CpuNums {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println("可用Cpu=" + i);//可用Cpu=16
    }
}
