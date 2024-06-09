package Observable;

import Observer.NotificationAlertObserver;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StocksObservable{

    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
             observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
         for(NotificationAlertObserver observer : observerList){
             observer.update();
         }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0) {
            notifySubscribers(); // Notify subscribers whenever stockCount changes
        }
            stockCount = newStockCount;
    }


    @Override
    public int getStockCount() {
        return stockCount;
    }
}
