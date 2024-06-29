import MementoDesignPattern.ConfigurationCareTaker;
import MementoDesignPattern.ConfigurationMemento;
import MementoDesignPattern.ConfigurationOriginator;

public class Main {
    public static void main(String[] args) {
        ConfigurationCareTaker careTakerObj = new ConfigurationCareTaker();

        ConfigurationOriginator originatorObj = new ConfigurationOriginator(5,4);

        ConfigurationMemento snapshot1 = originatorObj.createMemento();
        careTakerObj.addMemnento(snapshot1);

        originatorObj.setHeight(7);
        originatorObj.setWidth(2);

        ConfigurationMemento snapshot2 = originatorObj.createMemento();
        careTakerObj.addMemnento(snapshot2);

        originatorObj.setHeight(17);
        originatorObj.setHeight(23);

        ConfigurationMemento restoreStateMementoObj = careTakerObj.undo();
        originatorObj.restoreMemento(restoreStateMementoObj);

        System.out.println("height : " + originatorObj.height+" width : "+ originatorObj.width);

        ConfigurationMemento restoreStateMementoObj2 = careTakerObj.undo();
        originatorObj.restoreMemento(restoreStateMementoObj2);
        System.out.println("height : " + originatorObj.height+" width : "+ originatorObj.width);
    }
}