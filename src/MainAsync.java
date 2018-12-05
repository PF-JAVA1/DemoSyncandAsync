import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class MainAsync {
    private static void printData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Synchronously printing " +data);
    }

    public static void main(String[] args) {
        long startTime, endTime;
        CountDownLatch latch = new CountDownLatch(3);
        DataAsync dataAsync1 = new DataAsync(1, 5000);
        DataAsync dataAsync2 = new DataAsync(2, 3000);
        DataAsync dataAsync3 = new DataAsync(3, 6000);
        startTime = System.currentTimeMillis();
        System.out.println("Start");



        try {
            CompletableFuture.supplyAsync(dataAsync1).thenAccept(d1 ->{printData(d1.toString());
                latch.countDown();});

            CompletableFuture.supplyAsync(dataAsync2).thenAccept(d2 ->{printData(d2.toString());
                latch.countDown();});

            CompletableFuture.supplyAsync(dataAsync3).thenAccept(d3 ->{printData(d3.toString());
                latch.countDown();});

            latch.await();

            System.out.println("Done");
            endTime = System.currentTimeMillis();
            System.out.println("Excution time (ms): " + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
