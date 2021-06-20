package Model.DBEntities;

import org.bson.codecs.pojo.annotations.*;

import java.util.ArrayList;
import java.util.List;

@CollectionName(name = "User")
@BsonDiscriminator
public class User extends Collection {
    @BsonIgnore
    public final static String BOOK_IDS = "bookIds";
    @BsonIgnore
    public final static String FAVORITE_BOOK_ID = "favoriteBookId";

    private static int idGenerator = 0;
    private long id;
    private String name;
    private List<Integer> bookIds;
    private int favoriteBookId = -1;

    public User() {
        idGenerator++;
    }

    public User(String name, List<Integer> bookIds, int favoriteBookId) {
        this.id = idGenerator;
        this.name = name;
        this.bookIds = bookIds;
        this.favoriteBookId = favoriteBookId;
        idGenerator++;
    }

    public User(String name, List<Integer> bookIds) {
        this.id = idGenerator;
        this.name = name;
        this.bookIds = bookIds;
        idGenerator++;
    }

    public User(String name) {
        this.id = idGenerator;
        this.name = name;
        this.bookIds = new ArrayList<>();
        idGenerator++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public int getFavoriteBookId() {
        return favoriteBookId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
    }

    public void setFavoriteBookId(int favoriteBookId) {
        this.favoriteBookId = favoriteBookId;
    }

    @Override
    @BsonIgnore
    public String toString() {
        return "User { " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", bookIds= " + bookIds +
                ", favoriteBookId= " + favoriteBookId +
                " }";
    }
}
