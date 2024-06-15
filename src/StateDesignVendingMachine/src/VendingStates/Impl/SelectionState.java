package VendingStates.Impl;

import StateDesignVendingMachine.Coin;
import StateDesignVendingMachine.Item;
import StateDesignVendingMachine.VendingMachine;
import VendingStates.State;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending machine is in Selection state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
       throw new Exception("You cannot click on insert coin button in selection state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in selection state");
    }

    @Override
    public void clickOnStartProductSelectionButoon(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
//        get item of this codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

//        total amount paid by user
          int paidByUser = 0;
          for(Coin coin:machine.getCoinList()){
              paidByUser = paidByUser+coin.value;
          }

//          compare product price and amount paid by user
          if(paidByUser< item.getPrice()){
              System.out.println("Insufficient Amount, Product you selected is for price: "+item.getPrice());
              refundFullMoney(machine);
              throw new Exception("Insufficient amount");
          }else if(paidByUser>=item.getPrice()){
              if(paidByUser>item.getPrice()){
                  getChange(paidByUser-item.getPrice());
              }
              machine.setVendingMachineState(new DispenseState(machine,codeNumber));
          }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
//        actual logic should be to return coin's in the dispense tray , but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the coin dispense tray: "+returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in selection state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount of money back in the coin dispense tray");
        machine.setVendingMachineState(new IdleState());
        return machine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in selection state");
    }
}
