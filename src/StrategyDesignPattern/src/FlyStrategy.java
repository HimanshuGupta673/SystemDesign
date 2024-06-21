// Concrete strategy for flying
public class FlyStrategy implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Flying");
    }
}
