package ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {
    private List<DBConnection> freeConnectionInPool = new ArrayList<DBConnection>();
    private List<DBConnection> connectionsCurrentlyInUse = new ArrayList<>();
    private int INITIAL_POOL_SIZE = 3;
    private int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager dbConnectionPoolManagerInstance = null;

    private DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnectionInPool.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if (dbConnectionPoolManagerInstance == null) {
            synchronized (DBConnectionPoolManager.class){
                if(dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManagerInstance;
    }
//    synchronized  is used for thread safety
    public synchronized DBConnection getDBConnection() {
        if(freeConnectionInPool.isEmpty() && connectionsCurrentlyInUse.size()<MAX_POOL_SIZE) {
            freeConnectionInPool.add(new DBConnection());
            System.out.println("creating new connection and putting into the pool, free pool size : "+freeConnectionInPool.size());
        }else if(freeConnectionInPool.isEmpty() && connectionsCurrentlyInUse.size()>=MAX_POOL_SIZE) {
            System.out.println("cannot create new DBConnection , as max limit reached");
            return null;
        }

        DBConnection dbConnection = freeConnectionInPool.remove(freeConnectionInPool.size()-1);
        connectionsCurrentlyInUse.add(dbConnection);
        System.out.println("Adding db connection into use pool, size : "+connectionsCurrentlyInUse.size());
        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if(dbConnection != null) {
            connectionsCurrentlyInUse.remove(dbConnection);
            System.out.println("Removing db connection from use pool , size : "+connectionsCurrentlyInUse.size());
            freeConnectionInPool.add(dbConnection);
            System.out.println("Adding db connection into free pool, size: "+freeConnectionInPool.size());
        }
    }



}
