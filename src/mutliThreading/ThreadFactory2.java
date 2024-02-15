package mutliThreading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactory2 implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "thread2");
    }
}
