public class AirConditioner{
    boolean isOn;
    int temperature;

    public void turnOnAc(){
        isOn = true;
        System.out.println("AC IS ON");
    }
    public void turnOffAc(){
        isOn = false;
        System.out.println("AC IS OFF");
    }
    public void setTemperature(int temp){
        this.temperature = temp;
        System.out.println("Temperature set to " + temp);
    }
}
