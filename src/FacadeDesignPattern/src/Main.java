//1. Exposing Certain Methods to the Client
//Case: You want to provide a simplified interface to the client by exposing only certain methods of a complex subsystem.
//
//Example:
//Imagine a home automation system with complex subsystems for lights, thermostat, and security. The client should have a simple way to control these subsystems.
//
//Facade Role: Create a HomeAutomationFacade that exposes simple methods like turnOnAllSystems and turnOffAllSystems.

// Complex subsystems
//class Light {
//    void turnOn() { System.out.println("Lights are on"); }
//    void turnOff() { System.out.println("Lights are off"); }
//}
//
//class Thermostat {
//    void setTemperature(int temp) { System.out.println("Thermostat set to " + temp + " degrees"); }
//}
//
//class Security {
//    void arm() { System.out.println("Security system armed"); }
//    void disarm() { System.out.println("Security system disarmed"); }
//}

// Facade
//class HomeAutomationFacade {
//    private Light light;
//    private Thermostat thermostat;
//    private Security security;
//
//    public HomeAutomationFacade() {
//        this.light = new Light();
//        this.thermostat = new Thermostat();
//        this.security = new Security();
//    }
//
//    public void turnOnAllSystems() {
//        light.turnOn();
//        thermostat.setTemperature(22);
//        security.arm();
//    }
//
//    public void turnOffAllSystems() {
//        light.turnOff();
//        thermostat.setTemperature(18);
//        security.disarm();
//    }
//}
//
//// Client code
//public class Main {
//    public static void main(String[] args) {
//        HomeAutomationFacade homeFacade = new HomeAutomationFacade();
//        homeFacade.turnOnAllSystems();
//        homeFacade.turnOffAllSystems();
//    }
//}


//2. Handling Changes in Order Creation Logic
//Case: When the order creation logic changes, it should not impact the client directly.
//
//Example:
//An e-commerce application where the order creation process involves multiple steps such as validating the order, processing the payment, and updating the inventory.
//
//Facade Role: Create an OrderFacade to handle the order creation process, so any changes in the logic are encapsulated within the facade.

// Subsystems involved in order creation
//class OrderValidator {
//    void validate() { System.out.println("Order validated"); }
//}
//
//class PaymentProcessor {
//    void processPayment() { System.out.println("Payment processed"); }
//}
//
//class InventoryUpdater {
//    void updateInventory() { System.out.println("Inventory updated"); }
//}
//
//// Facade
//class OrderFacade {
//    private OrderValidator validator;
//    private PaymentProcessor paymentProcessor;
//    private InventoryUpdater inventoryUpdater;
//
//    public OrderFacade() {
//        this.validator = new OrderValidator();
//        this.paymentProcessor = new PaymentProcessor();
//        this.inventoryUpdater = new InventoryUpdater();
//    }
//
//    public void createOrder() {
//        validator.validate();
//        paymentProcessor.processPayment();
//        inventoryUpdater.updateInventory();
//    }
//}
//
//// Client code
//public class Main {
//    public static void main(String[] args) {
//        OrderFacade orderFacade = new OrderFacade();
//        orderFacade.createOrder();
//    }
//}

//3. Using One Facade Within Another Facade
//Case: When a subsystem itself is complex and can be divided into further subsystems, another facade can use it.
//
//        Example:
//A car manufacturing system where the assembly process has multiple steps such as engine assembly, body assembly, and painting.
//
//Facade Role: Create an EngineAssemblyFacade, BodyAssemblyFacade, and PaintingFacade, and then use these within a higher-level CarAssemblyFacade.

// Lower-level facades
class EngineAssemblyFacade {
    void assembleEngine() { System.out.println("Engine assembled"); }
}

class BodyAssemblyFacade {
    void assembleBody() { System.out.println("Body assembled"); }
}

class PaintingFacade {
    void paintCar() { System.out.println("Car painted"); }
}

// Higher-level facade
class CarAssemblyFacade {
    private EngineAssemblyFacade engineFacade;
    private BodyAssemblyFacade bodyFacade;
    private PaintingFacade paintingFacade;

    public CarAssemblyFacade() {
        this.engineFacade = new EngineAssemblyFacade();
        this.bodyFacade = new BodyAssemblyFacade();
        this.paintingFacade = new PaintingFacade();
    }

    public void assembleCar() {
        engineFacade.assembleEngine();
        bodyFacade.assembleBody();
        paintingFacade.paintCar();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CarAssemblyFacade carAssemblyFacade = new CarAssemblyFacade();
        carAssemblyFacade.assembleCar();
    }
}

