import FactoryOfFactoryPattern.AbstractFactory;
import FactoryOfFactoryPattern.AbstractFactoryProducer;
import FactoryOfFactoryPattern.Car;
import FactoryPattern.Shape;
import FactoryPattern.ShapeFactoryPattern;
import ProtoTypeDesignPattern.Prototype;
import ProtoTypeDesignPattern.Student;
import SingletonDesignPattern.Eagertype.DBConnection;

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
        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        AbstractFactory abstractFactory = abstractFactoryProducer.getFactoryInstance("Premium");
        Car car = abstractFactory.getInstance(5000000);
        System.out.println(car.getTopSpeed());


    }




}