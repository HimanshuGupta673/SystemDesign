package VendingStates.Impl;

import StateDesignVendingMachine.Coin;
import StateDesignVendingMachine.Item;
import StateDesignVendingMachine.VendingMachine;
import VendingStates.State;

import java.util.ArrayList;
import java.util.List;


public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently vending machine is in IdleState");
    }
    public IdleState(VendingMachine machine){
        System.out.println("Currently vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in idle state")
    }

    @Override
    public void clickOnStartProductSelectionButoon(VendingMachine machine) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You cannot get change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("You cannot get refund in idle state");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item,codeNumber);
    }
}
