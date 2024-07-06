public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Pricing computation of single room");
        singleRoom.roomPrice = 1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Pricing computation of double room");
        doubleRoom.roomPrice = 2000;
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Pricing computation of deluxe room");
        deluxeRoom.roomPrice = 3000;
    }
}
