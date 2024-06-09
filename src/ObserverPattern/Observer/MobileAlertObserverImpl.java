package Observer;

import Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userName;
    StocksObservable observable;
    public MobileAlertObserverImpl(String userName, StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMessageOnMobile(userName,"product is in stock hurry up!");
    }

    private void sendMessageOnMobile(String userName, String s) {
        System.out.println("message sent to : "+userName+": "+s);
    }
}
