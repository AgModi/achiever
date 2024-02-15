package mutliThreading;

import java.util.concurrent.*;

public class ThreadConfigManager {

    public static ExecutorService execServ1 = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5), new ThreadFactory1());
    public static ExecutorService execServ2 = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5), new ThreadFactory2());

    public static void runAsync(String lock, Runnable r, ExecutorService tpExec) {
        System.out.println("In ThreadConfigManager.runAsync class");
        Thread newRUnnable = overrideRunnable(lock, r);
        CompletableFuture.runAsync(newRUnnable, tpExec);
        try {
            newRUnnable.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Thread overrideRunnable(String lock, Runnable r) {
        return new Thread() {
            @Override
            public void run() {
                System.out.println("Trying to get lock on-> "+  lock + " <- by thread" + Thread.currentThread().getName());
                synchronized (lock) {
                    System.out.println("Acquired lock on-> "+  lock + " <- by thread" + Thread.currentThread().getName());
                    r.run();
                    lock.notify();
                    //TODO Notify is needed here to wake up waitig threads
                    /*try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Error while calling wait on "+ Thread.currentThread().getName());
                        throw new RuntimeException(e);
                    }*/
                }
            }
        };
    }
}
