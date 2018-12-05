public class MainSync {
    private static void printData(String data) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Synchronously printing " + data);
    }

    public static void main(String[] args) {
        long startTime, endTime;
        DataSync dataSync1 = new DataSync(1, 5000);
        DataSync dataSync2 = new DataSync(2, 3000);
        DataSync dataSync3 = new DataSync(3, 6000);

        startTime = System.currentTimeMillis();
        System.out.println("Start");

        String d1 = dataSync1.get();
        printData(d1);

        String d2 = dataSync2.get();
        printData(d2);

        String d3 = dataSync3.get();
        printData(d3);

        System.out.println("Done");
        endTime = System.currentTimeMillis();

        System.out.println("Execution time (ms): " + (endTime - startTime));
    }
}
