import FactoryOfFactoryPattern.AbstractFactory;
import FactoryOfFactoryPattern.AbstractFactoryProducer;
import FactoryOfFactoryPattern.Car;
import FactoryPattern.Shape;
import FactoryPattern.ShapeFactoryPattern;
import ObjectPoolDesignPattern.DBConnection;
import ObjectPoolDesignPattern.DBConnectionPoolManager;
import ProtoTypeDesignPattern.Prototype;
import ProtoTypeDesignPattern.Student;

public class Main {
    public static void main(String[] args) {
//        Prototype----------

//        Student obj = new Student(20,75,"Ram");
//        Student cloneObj = (Student) obj.clone();
//        System.out.println(cloneObj);

//        singleton-----
//        1.eager------
//        DBConnection canObject = DBConnection.getInstance();

//        factory pattern---------
//        ShapeFactoryPattern factoryPattern = new ShapeFactoryPattern();
//        Shape circleObj = factoryPattern.getShapeInstance("Circle");
//        circleObj.computeArea();;

//        FactoryofFactory pattern--------
//        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
//        AbstractFactory abstractFactory = abstractFactoryProducer.getFactoryInstance("Premium");
//        Car car = abstractFactory.getInstance(5000000);
//        System.out.println(car.getTopSpeed());

//        Object Pool design pattern
        DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();
        DBConnection connection1 = poolManager.getDBConnection();
        DBConnection connection2 = poolManager.getDBConnection();
        DBConnection connection3 = poolManager.getDBConnection();
        DBConnection connection4 = poolManager.getDBConnection();
        DBConnection connection5 = poolManager.getDBConnection();
        DBConnection connection6 = poolManager.getDBConnection();
        poolManager.getDBConnection();
        poolManager.releaseDBConnection(connection1);

    }




}