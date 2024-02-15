package java8.lambdaExpr;

public class ThreadUsingLambda {

    public static void main(String[] args) {
        createThread1();
    }

    private static void createThread1() {
        Runnable runnable = ()-> {
            System.out.println("name");
        };

        runnable.run();

        Thread t = new Thread(runnable);
        t.start();
    }
}
