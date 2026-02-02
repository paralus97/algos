package concurenccy;

import java.util.concurrent.*;

public class FutureTaskSandbox {

    static void main() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool(Executors.defaultThreadFactory());

        Future<String> responseTask = threadPool.submit(() -> String.format("Hello %d", 7));
        String res = responseTask.get();
        System.out.println(res);

        threadPool.close();
    }
}
