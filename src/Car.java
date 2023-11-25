public class Car implements Comparable<Car> {
    private String name;
    private int position;
    private double speed;

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public double getSpeed() {
        return speed;
    }

    public void move() {
        position += speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.position, this.position);
    }
}
