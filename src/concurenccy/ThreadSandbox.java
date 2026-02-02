package concurenccy;

import java.util.concurrent.ThreadFactory;

public class ThreadSandbox {

    public static class AsyncTaskThread extends Thread implements Runnable {


        @Override
        public void run() {

            System.out.println("In the thread!!");


            super.run();
        }
    }

    static void main() {
        int number = 20;

        Thread thread = new Thread(() -> {
            System.out.println(20);
        });

        thread.start();


        // Start platform thread
        Thread platformThread = Thread.ofPlatform().start(new AsyncTaskThread());

        Thread virtualThread = AsyncTaskThread.ofVirtual().start(() -> {});


    }
}
