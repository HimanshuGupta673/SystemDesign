public class RoomMaintainanceVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Performing maintainance of single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Performing maintainance of double room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Performing maintainance of deluxe room");
    }
}
