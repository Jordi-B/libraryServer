package Controller;

import Model.DBEntities.User;
import Model.Functions.*;

import static spark.Spark.*;

public class UserRoute {
    public static void initUserPath() {
        path("/users", () ->
                {
                    get("", (request, response) -> GenericF.getAll(User.class));

                    get("/:id", (request, response) -> {
                        int id = Integer.parseInt(request.params(":id"));
                        return GenericF.getOneById(User.class, id);
                    });

                    post("/update", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        String name = request.queryParams("name");
                        GenericF.setById(User.class, userId, User.NAME, name);
                        return GenericF.getAll(User.class);
                    });

                    post("/addBook", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        UserF.addBookToUserList(userId, bookId);
                        BookF.addReaderToBookList(bookId, userId);
                        return GenericF.getAll(User.class);
                    });

                    post("/deleteBook", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        UserF.deleteBookFromUserList(userId, bookId);
                        BookF.deleteReaderFromBookList(bookId, userId);
                        return GenericF.getAll(User.class);
                    });

                    post("/setBookFavorite", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        UserF.setBookAsFavoriteForUser(userId, bookId);
                        return GenericF.getAll(User.class);
                    });

                    post("/delete", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        GenericF.deleteById(User.class, userId);
                        return GenericF.getAll(User.class);
                    });
                }
        );
    }
}
