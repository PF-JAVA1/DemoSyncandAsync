import java.util.function.Supplier;

public class DataAsync implements Supplier {
    private int id;
    private long simulationDuration;

    public DataAsync(int id, long simulationDuration) {
        this.id = id;
        this.simulationDuration = simulationDuration;
    }

    @Override
    public String get() {
        try {
            Thread.sleep(simulationDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data" + id;
    }
}
