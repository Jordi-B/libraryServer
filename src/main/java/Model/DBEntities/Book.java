package Model.DBEntities;

import org.bson.codecs.pojo.annotations.*;

import java.util.List;

//@BsonDiscriminator
@CollectionName(name = "Book")
public class Book extends Collection {
    @BsonIgnore
    public final static String CURRENT_READER_IDS = "currentReaderIds";
    @BsonIgnore
    public final static String AUTHOR_ID = "authorId";

    @BsonProperty(ID)
    private int id;
    @BsonProperty(NAME)
    private String name;
    @BsonProperty(CURRENT_READER_IDS)
    private List<Integer> currentReaderIds;
    @BsonProperty(AUTHOR_ID)
    private int authorId;

    public Book() {
    }

//    @BsonCreator
//    public Book(@BsonProperty(ID) int id, @BsonProperty(NAME) String name, @BsonProperty(CURRENT_READER_IDS) List<Integer> currentReaderIds, @BsonProperty(AUTHOR_ID) int authorId) {
//        this.id = id;
//        this.name = name;
//        this.currentReaderIds = currentReaderIds;
//        this.authorId = authorId;
//    }

//    @BsonIgnore
    public int getId() {
        return id;
    }

//    @BsonIgnore
    public String getName() {
        return name;
    }

//    @BsonIgnore
    public List<Integer> getCurrentReaderIds() {
        return currentReaderIds;
    }

//    @BsonIgnore
    public int getAuthorId() {
        return authorId;
    }

//    @BsonProperty(ID)
//    @BsonIgnore
    public void setId(int id) {
        this.id = id;
    }

//    @BsonIgnore
    public void setName(String name) {
        this.name = name;
    }

//    @BsonIgnore
    public void setCurrentReaderIds(List<Integer> currentReaderIds) {
        this.currentReaderIds = currentReaderIds;
    }

//    @BsonIgnore
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

//    @BsonIgnore
    @Override
    public String toString() {
        return "Book { " +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", currentReaderIds= " + currentReaderIds +
                ", authorId= " + authorId +
                " }";
    }
}
