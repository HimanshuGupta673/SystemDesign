import StateDesignVendingMachine.*;
import VendingStates.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try{
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine,Coin.QUARTER);

            System.out.println("|");
            System.out.println("Clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState.clickOnStartProductSelectionButoon(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine,102);

            displayInventory(vendingMachine);
        }catch (Exception e){
            displayInventory(vendingMachine);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item item = slots[i].getItem();
            if (item != null) {
                System.out.println("CodeNumber: " + slots[i].getCode() +
                        " Item: " + item.getType().name() +
                        " Price: " + item.getPrice() +
                        " isAvailable: " + !slots[i].isSoldOut());
            } else {
                System.out.println("CodeNumber: " + slots[i].getCode() +
                        " Item: None" +
                        " Price: N/A" +
                        " isAvailable: " + !slots[i].isSoldOut());
            }
        }
    }


    private static void fillUpInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i=0;i<slots.length;i++){
            Item newItem = new Item();
            if(i>=0 && i<3){
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i>=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i>=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i>=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }

            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }
}