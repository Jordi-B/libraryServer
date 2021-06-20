package Model.Functions;

import Model.DBEntities.User;
import Model.MongoOperation;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.pull;
import static com.mongodb.client.model.Updates.push;

public class UserF {

    static void insertUserByName(String name) throws Exception {
        User user = new User();
        user.setName(name);
        MongoOperation.insert(User.class, user).one();
    }

    public static void addBookToUserList(int userId, int bookId) throws Exception {
        MongoOperation.update(User.class)
                .filter(eq(User.ID, userId))
                .set(push(User.BOOK_IDS, bookId))
                .one();
    }

    public static void deleteBookFromUserList(int userId, int bookId) throws Exception {
        MongoOperation.update(User.class)
                .filter(eq(User.ID, userId))
                .set(pull(User.BOOK_IDS, bookId))
                .one();
    }

    public static void setBookAsFavoriteForUser(int userId, int bookId) throws Exception {
        MongoOperation.update(User.class)
                .filter(eq(User.ID, userId))
                .set(User.FAVORITE_BOOK_ID, bookId)
                .one();
    }
}
