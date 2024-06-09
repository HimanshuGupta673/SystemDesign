import Observable.IphoneObservableImpl;
import Observable.StocksObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MobileAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        StocksObservable iphoneObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com",iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com",iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz3@gmail.com",iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        System.out.println(iphoneObservable.getStockCount());
        iphoneObservable.setStockCount(10);
        System.out.println(iphoneObservable.getStockCount());
        iphoneObservable.setStockCount(0);
        System.out.println(iphoneObservable.getStockCount());
        iphoneObservable.setStockCount(10);
    }
}