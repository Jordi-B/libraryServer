package Model.DBEntities;

import org.bson.codecs.pojo.annotations.BsonIgnore;

public abstract class Collection {
    @BsonIgnore
    public final static String ID = "_id";
    @BsonIgnore
    public final static String NAME = "name";
    @BsonIgnore
    private final static String COLLECTION_NAME = "Collection";

    public static String getCollection() {
        return COLLECTION_NAME;
    }
}
