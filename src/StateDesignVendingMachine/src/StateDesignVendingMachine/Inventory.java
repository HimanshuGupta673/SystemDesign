package StateDesignVendingMachine;

public class Inventory {
    ItemShelf[] inventory = null;

    Inventory(int itemCount){
        inventory = new ItemShelf[itemCount];
        initialEmptyVentory();
    }

    public ItemShelf[] getInventory(){
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory){
        this.inventory = inventory;
    }

    public void initialEmptyVentory(){
        int startCode = 101;
        for(int i=0;i<inventory.length;i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item,int codeNumber) throws Exception{
      for(ItemShelf itemShelf:inventory){
          if(itemShelf.code == codeNumber){
              if(itemShelf.isSoldOut()){
                  itemShelf.item = item;
                  itemShelf.setSoldOut(false);
              }else{
                  throw new Exception("Already item is present, you cannot add item here");
              }
          }
      }
    }

    public void updateSoldOutItem(int codeNumber) {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
                itemShelf.item = null;
                break;
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.code == codeNumber) {
                if (!itemShelf.isSoldOut()) {
                    Item item = itemShelf.item;
                    updateSoldOutItem(codeNumber); // Mark the item as sold out once it's retrieved
                    return item;
                }
            }
        }
        throw new Exception("Item has been sold out already!");
    }
}
