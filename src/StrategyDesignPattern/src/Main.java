public class Main {
    public static void main(String[] args) {
        // Create a character with initial movement strategy
        Character character = new Character(new WalkStrategy());
        character.move();  // Output: Walking

        // Change strategy to running
        character.setMovementStrategy(new RunStrategy());
        character.move();  // Output: Running

        // Change strategy to flying
        character.setMovementStrategy(new FlyStrategy());
        character.move();  // Output: Flying
    }
}