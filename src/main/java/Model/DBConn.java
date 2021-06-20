package Model;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Convention;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBConn {
    private static DBConn dbConnInstance = null;
    private final MongoDatabase db;

    private DBConn(String host, int port, String dbName) {
        List<Convention> conventionsList = new ArrayList<>();
        conventionsList.add(Conventions.ANNOTATION_CONVENTION);
        conventionsList.add(Conventions.CLASS_AND_PROPERTY_CONVENTION);
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().conventions(conventionsList).automatic(true).build()));
        db = setDBConnectionBy(host, port).getDatabase(dbName).withCodecRegistry(pojoCodecRegistry);
    }

    private static MongoClient setDBConnectionBy(String host, int port) {
        return new MongoClient(host, port);
    }

    public static DBConn getDBBy(String host, int port, String dbName) {
        if (dbConnInstance == null) {
            dbConnInstance = new DBConn(host, port, dbName);
        }
        return dbConnInstance;
    }

    public MongoDatabase getDb() {
        return db;
    }
}
