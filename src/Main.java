import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NUM_CARS = 10;
    private static final int DURATION = 20;

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Random random = new Random();

        // Initialize cars with random speeds
        for (int i = 0; i < NUM_CARS; i++) {
            cars.add(new Car("Car" + (i + 1), random.nextDouble() * 10));
        }

        for (int time = 0; time <= DURATION; time++) {
            List<Thread> threads = new ArrayList<>();

            // Create and start threads for each car to move
            for (Car car : cars) {
                Thread thread = new Thread(new RacingSimulationTask(Collections.singletonList(car)));
                threads.add(thread);
                thread.start();
            }

            // Wait for all threads to complete
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Sort cars based on position
            Collections.sort(cars);


            // Display top 3 cars with the highest position for each second
            System.out.println("Second " + time + ":");


            for (int i = 0; i < Math.min(3, cars.size()); i++) {

                Car car = cars.get(i);
                System.out.println("Position " + (i + 1) + ": " + car.getName() +
                        " - Speed: " + car.getSpeed() + " - Position: " + car.getPosition());


            }

            System.out.println();
        }
    }
}
