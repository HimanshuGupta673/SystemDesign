// Concrete strategy for running
public class RunStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Running");
    }
}
