package VendingStates.Impl;

import StateDesignVendingMachine.Coin;
import StateDesignVendingMachine.Item;
import StateDesignVendingMachine.VendingMachine;
import VendingStates.State;

import java.util.List;

public class DispenseState implements State {

    DispenseState(VendingMachine machine,int codeNumber) throws Exception{
        System.out.println("Currently vending maching is in Dispense State");
        dispenseProduct(machine,codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("Insert coin button cannot be clicked in dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Coin cannot be inserted in dispense method");
    }

    @Override
    public void clickOnStartProductSelectionButoon(VendingMachine machine) throws Exception {
        throw new Exception("Product selection button cannot be clicked in dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be chosen in Dispensed method");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Change cannot be returned in dispense method");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Refund cannot be happen in dispense state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in dispense state");
    }
}
