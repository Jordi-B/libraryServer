package Controller;

import Model.DBEntities.Author;
import Model.Functions.BookF;
import Model.Functions.GenericF;

import static spark.Spark.*;

public class AuthorRoute {
    public static void initAuthorPath() {
        path("/authors", () ->
                {
                    get("", (request, response) -> GenericF.getAll(Author.class));

                    get("/:id", (request, response) -> {
                        int id = Integer.parseInt(request.params(":id"));
                        return GenericF.getOneById(Author.class, id);
                    });

                    post("/update", (request, response) -> {
                        int authorId = Integer.parseInt(request.queryParams("authorId"));
                        String name = request.queryParams("name");
                        GenericF.setById(Author.class, authorId, Author.NAME, name);
                        return GenericF.getAll(Author.class);
                    });

                    post("/delete", (request, response) -> {
                        int authorId = Integer.parseInt(request.queryParams("authorId"));
                        GenericF.deleteById(Author.class, authorId);
                        BookF.deleteByAuthorId(authorId);
                        return GenericF.getAll(Author.class);
                    });
                }
        );
    }
}
