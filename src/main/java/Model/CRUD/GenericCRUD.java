package Model.CRUD;

import Model.DBEntities.Collection;
import Model.DBEntities.CollectionName;
import com.mongodb.client.MongoCollection;

import java.util.List;
import java.util.Optional;

import static Model.MongoOperation.getDb;

public abstract class GenericCRUD<T extends Collection> {
    private final Class<T> collection;

    GenericCRUD(Class<T> collection) {
        this.collection = collection;
    }

    public MongoCollection<T> getCollection() throws Exception {
        return getDb().getCollection(getCollectionNameOfClass(), collection);
    }


    public abstract Optional<T> one() throws Exception;

    public abstract List<T> many() throws Exception;

    private String getCollectionNameOfClass() throws Exception {
        String EMPTY_STRING = "";
        try {
            return collection.getAnnotation(CollectionName.class).name();
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            return EMPTY_STRING;
        }
    }
}
