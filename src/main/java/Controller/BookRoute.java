package Controller;

import Model.DBEntities.Book;
import Model.Functions.*;

import static spark.Spark.*;

public class BookRoute {
    public static void initBookPath() {
        path("/books", () ->
                {
                    get("", (request, response) -> GenericF.getAll(Book.class));

                    get("/:id", (request, response) -> {
                        int id = Integer.parseInt(request.params(":id"));
                        return GenericF.getOneById(Book.class, id);
                    });

                    post("/update", (request, response) -> {
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        String name = request.queryParams("name");
                        GenericF.setById(Book.class, bookId, Book.NAME, name);
                        return GenericF.getAll(Book.class);
                    });

                    post("/deleteFromUserList", (request, response) -> {
                        int userId = Integer.parseInt(request.queryParams("userId"));
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        UserF.deleteBookFromUserList(userId, bookId);
                        BookF.deleteReaderFromBookList(bookId, userId);
                        return GenericF.getAll(Book.class);
                    });

                    post("/delete", (request, response) -> {
                        int bookId = Integer.parseInt(request.queryParams("bookId"));
                        GenericF.deleteById(Book.class, bookId);
                        return GenericF.getAll(Book.class);
                    });
                }
        );
    }
}
