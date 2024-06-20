package SingletonDesignPattern.SynchronizedMethod;

public class DBConnection {
    private static DBConnection canObject;

    private DBConnection(){}

    //    solve problem of lazy but expensive due to locking on each process
    synchronized public static DBConnection getInstance(){
        if(canObject==null){
            canObject = new DBConnection();
        }
        return canObject;
    }
}
