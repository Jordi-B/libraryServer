import Model.DBEntities.*;
import Model.MongoOperation;

import Controller.RouteUtils;

public class Demo {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private final static String DB_NAME = "libraryDB";

    public static void main(String[] args) throws Exception {
        new MongoOperation(HOST, PORT, DB_NAME);
//        System.out.println(MongoOperation.find(User.class).many());
        RouteUtils.startServer();
    }
}
