public class VehicleFactory {
    static Vehicle getVehicleObject(String typeOfVehicle){
        if(typeOfVehicle.equalsIgnoreCase("Car")){
            return new Car();
        }
        return new NullVehicle();
    }
}
