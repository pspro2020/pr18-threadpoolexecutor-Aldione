package FixedThread;

import ScriptPotencial.Potencial;

import java.util.concurrent.*;

public class FixedThread {

    private final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Thread "+ ++count);
        }
    });


    public void executeFixed(Potencial potencial) {
        fixedThreadPool.execute(potencial);
    }

    public void shutDownFixed () throws InterruptedException {
        fixedThreadPool.shutdown();
        if(fixedThreadPool.awaitTermination(200, TimeUnit.MILLISECONDS)){
            System.out.printf("Finished, we used %d Thread\n", fixedThreadPool.getCompletedTaskCount());
        }else{
            System.out.printf("Await termination timeout. We used %d Thread\n", fixedThreadPool.getCompletedTaskCount());
        }
    }
}
