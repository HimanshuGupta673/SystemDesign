public class Main {
    public static void main(String[] args) {
       PaymentFlow friend = new PayToFriend();
       friend.sendMoney();

       PaymentFlow merchant = new PayToMerchant();
       merchant.sendMoney();
    }
}