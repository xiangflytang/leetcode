import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numThreads = 3;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Worker(latch));
            thread.start();
        }

        try {
            // 等待所有线程执行完毕
            latch.await();
            System.out.println("All threads have finished their work.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            // 模拟线程工作
            try {
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has finished its work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 减少计数器
                latch.countDown();
            }
        }
    }
}
