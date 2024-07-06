public class Main {
    public static void main(String[] args) {
         RoomElement singleRoom = new SingleRoom();
         RoomElement doubleRoom = new DoubleRoom();
         RoomElement deluxeRoom = new DeluxeRoom();

         RoomVisitor pricingVisitor = new RoomPricingVisitor();
         singleRoom.accept(pricingVisitor);
        System.out.println(((SingleRoom)singleRoom).roomPrice);

        doubleRoom.accept(pricingVisitor);
        System.out.println(((DoubleRoom)doubleRoom).roomPrice);


        deluxeRoom.accept(pricingVisitor);
        System.out.println(((DeluxeRoom)deluxeRoom).roomPrice);

        RoomVisitor maintainanceVisitorObj = new RoomMaintainanceVisitor();
        singleRoom.accept(maintainanceVisitorObj);

        doubleRoom.accept(maintainanceVisitorObj);
        deluxeRoom.accept(maintainanceVisitorObj);
    }
}