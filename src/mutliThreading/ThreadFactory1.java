package mutliThreading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactory1 implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "thread1");
    }
}
