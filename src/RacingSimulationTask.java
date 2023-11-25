import java.util.List;

public class RacingSimulationTask implements Runnable {
    private final List<Car> cars;

    public RacingSimulationTask(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void run() {
        for (Car car : cars) {
            // Change the speed randomly every second
            car.setSpeed(Math.random() * 100);
            car.move();
        }
    }
}
