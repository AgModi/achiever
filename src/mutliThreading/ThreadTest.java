package mutliThreading;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadConfigManager.runAsync("lock", () -> ThreadTest.multiply(4,6), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("dock", () -> ThreadTest.multiply(1,2), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("sock", () -> ThreadTest.multiply(4,6), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("bock", () -> ThreadTest.multiply(1,2), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("tock", () -> ThreadTest.multiply(4,6), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("mock", () -> ThreadTest.multiply(1,2), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("rock", () -> ThreadTest.multiply(4,6), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("wock", () -> ThreadTest.multiply(1,2), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("xock", () -> ThreadTest.multiply(4,6), ThreadConfigManager.execServ1);
        ThreadConfigManager.runAsync("pock", () -> ThreadTest.multiply(1,2), ThreadConfigManager.execServ1);

        //ThreadConfigManager.runAsync("dj", () -> ThreadTest.multiply(10,1), ThreadConfigManager.execServ2);
        //ThreadConfigManager.runAsync("dj", () -> ThreadTest.multiply(20,1), ThreadConfigManager.execServ2);
    }

    public static int multiply(int a, int b) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a*b);
        return a*b;
    }
}
