package Adaptee;

public class WeightMachineForBabies implements WeightMachine{

   private int weightInPound;

    public WeightMachineForBabies(int weightInPound) {
        this.weightInPound = weightInPound;
    }

    @Override
    public double getWeightInPound() {
        return weightInPound;
    }
}
