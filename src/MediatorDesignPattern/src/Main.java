import OnlineAuctionSystem.Auction;
import OnlineAuctionSystem.AuctionMediator;
import OnlineAuctionSystem.Bidder;
import OnlineAuctionSystem.Colleague;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediatorObj = new Auction();
        Colleague bidder1 = new Bidder("Ramu",auctionMediatorObj);
        Colleague bidder2 = new Bidder("Shyam",auctionMediatorObj);

        bidder1.placeBid(3000);
        bidder2.placeBid(1000);
        bidder1.placeBid(300);

    }
}