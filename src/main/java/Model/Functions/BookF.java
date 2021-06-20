package Model.Functions;

import Model.DBEntities.Book;
import Model.MongoOperation;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.pull;
import static com.mongodb.client.model.Updates.push;

public class BookF {

    public static void addReaderToBookList(int bookId, int userId) throws Exception {
        MongoOperation.update(Book.class)
                .filter(eq(Book.ID, bookId))
                .set(push(Book.CURRENT_READER_IDS, userId))
                .one();
    }

    public static void deleteReaderFromBookList(int bookId, int userId) throws Exception {
        MongoOperation.update(Book.class)
                .filter(eq(Book.ID, bookId))
                .set(pull(Book.CURRENT_READER_IDS, userId))
                .one();
    }

    public static void deleteByAuthorId(int authorId) throws Exception {
        MongoOperation.delete(Book.class)
                .filter(eq(Book.AUTHOR_ID, authorId))
                .one();
    }

}
