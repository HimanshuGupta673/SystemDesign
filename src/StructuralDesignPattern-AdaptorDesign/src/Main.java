import Adaptee.WeightMachineForBabies;
import Adapter.WeightMachineAdapter;
import Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
//        client----------
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies(78));
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}