package Model.CRUD;

import Model.DBEntities.Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Insert<T extends Collection> extends GenericCRUD<T> {
    private final List<T> documents;

    @SafeVarargs
    public Insert(Class<T> collection, T... documents) {
        super(collection);
        this.documents = Arrays.asList(documents);
    }

    @Override
    public Optional<T> one() throws Exception {
        getCollection().insertOne(documents.get(0));
        return Optional.empty();
    }

    @Override
    public List<T> many() throws Exception {
        getCollection().insertMany(documents);
        return null;
    }
}
