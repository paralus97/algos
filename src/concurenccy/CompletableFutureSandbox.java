package concurenccy;

import java.util.concurrent.*;

public class CompletableFutureSandbox {


    public static class AsynchronousTask {

        public static int compute(int x, int y) {
            return x * y;
        }
    }



    static void main() throws ExecutionException, InterruptedException {
        // Create basic future with lambda, note generic matches return type
        CompletableFuture<Integer> integerFuture = CompletableFuture.supplyAsync(() -> 30);
        // Get throws checked exceptions
        System.out.println(integerFuture.get());

        integerFuture = CompletableFuture.supplyAsync(() -> 50);
        // Join throws unchecked exceptions
        System.out.println(integerFuture.get());

        // Declared like this for demo purposes
        // but should use try-with-resoursces as ExecutorService implements AutoCloseable
        ExecutorService singleThreadExc = Executors.newSingleThreadExecutor();
        // only in 21, 25
        ExecutorService threadPerTaskExc = Executors.newThreadPerTaskExecutor(Executors.defaultThreadFactory());

        CompletableFuture<Integer> multiplicationFuture = CompletableFuture.supplyAsync(() ->
                AsynchronousTask.compute(30, 40),
                singleThreadExc
        );
        CompletableFuture<Integer> otherMultiFuture = CompletableFuture.supplyAsync(() ->
                AsynchronousTask.compute(70, 30),
                // only in 21, 25
                Executors.newVirtualThreadPerTaskExecutor()
        );
        CompletableFuture<Integer> anotherOne = CompletableFuture.supplyAsync(() ->
                AsynchronousTask.compute(600, 20),
                threadPerTaskExc
        );
        CompletableFuture<Integer> anotherTwo = CompletableFuture.supplyAsync(() ->
                AsynchronousTask.compute(600, 50),
                threadPerTaskExc
        );

        // Completes all futures successfully or none at all
        CompletableFuture<Void> joinedFutures = CompletableFuture.allOf(multiplicationFuture, otherMultiFuture,
                anotherOne, anotherTwo);
        joinedFutures.get();
        System.out.println(joinedFutures.isDone());

        //Must cleanup executor services, they can hang application otherwise. Services usually just wait for tasks
        // forever.
        singleThreadExc.close();
        threadPerTaskExc.close();
    }
}