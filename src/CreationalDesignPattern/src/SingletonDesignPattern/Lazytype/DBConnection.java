package SingletonDesignPattern.Lazytype;

public class DBConnection {
    private static DBConnection canObject;

    private DBConnection(){}

//    FAIL WHEN MORE THAN ONE REQUEST COMES SIMULTANEOUSLY
    public static DBConnection getInstance(){
        if(canObject==null){
            canObject = new DBConnection();
        }
        return canObject;
    }
}
