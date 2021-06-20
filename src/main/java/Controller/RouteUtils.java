package Controller;

import static Controller.AuthorRoute.initAuthorPath;
import static Controller.BookRoute.initBookPath;
import static Controller.UserRoute.initUserPath;
import static spark.Spark.*;

public class RouteUtils {
    public static void addHeadersRoute() {
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,PATCH,POST,DELETE,OPTIONS");
            response.type("application/json");
        });
    }

    public static void startServer() {
        port(3000);
        addHeadersRoute();
        initUserPath();
        initBookPath();
        initAuthorPath();
    }
}
