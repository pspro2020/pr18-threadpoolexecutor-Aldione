package CachedThread;

import ScriptPotencial.Potencial;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CachedThread {

    ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool(new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Thread "+ ++count);
        }
    });

    public void shutDownCached() throws InterruptedException {
        cachedThreadPool.shutdown();
        if(cachedThreadPool.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.printf("Finished, we used %d Thread\n", cachedThreadPool.getCompletedTaskCount());
        }else{
            System.out.printf("Await termination timeout. We used %d Thread\n", cachedThreadPool.getCompletedTaskCount());
        }
    }

    public void executeCached(Potencial potencial){
        cachedThreadPool.execute(potencial);
    }

}
