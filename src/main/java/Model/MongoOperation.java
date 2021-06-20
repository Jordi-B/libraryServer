package Model;

import static Model.DBConn.*;

import Model.CRUD.*;
import Model.DBEntities.*;
import com.mongodb.client.MongoDatabase;

public class MongoOperation {
    private static DBConn dbConnection;

    public MongoOperation(String host, int port, String DBName) {
        dbConnection = getDBBy(host, port, DBName);
    }

    public static MongoDatabase getDb() {
        return dbConnection.getDb();
    }

    public static boolean isThereAConnectionToDb() {
        return dbConnection != null;
    }

    @SafeVarargs
    public static <T extends Collection> Insert<T> insert(Class<T> entity, T... document) throws Exception {
        return new Insert<T>(entity, document);
    }

    public static <T extends Collection> Find<T> find(Class<T> entity) throws Exception {
        return new Find<T>(entity);
    }

    public static <T extends Collection> Update<T> update(Class<T> entity) throws Exception {
        return new Update<T>(entity);
    }

    public static <T extends Collection> Delete<T> delete(Class<T> entity) throws Exception {
        return new Delete<T>(entity);
    }
}
