package Model.DBEntities;

import org.bson.codecs.pojo.annotations.*;

import java.util.List;

//@BsonDiscriminator
@CollectionName(name = "Author")
public class Author extends Collection {
    @BsonIgnore
    private final static String COLLECTION_NAME = "Author";
    @BsonIgnore
    public final static String BOOK_IDS = "bookIds";
    @BsonProperty(value = ID)
    private int id;
    private String name;
    private List<Integer> bookIds;

    public Author() {
    }

    public Author(int id, String name, List<Integer> bookIds) {
        this.id = id;
        this.name = name;
        this.bookIds = bookIds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
    }

    @Override
    public String toString() {
        return "Author { " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", bookIds= " + bookIds +
                " }";
    }
}
