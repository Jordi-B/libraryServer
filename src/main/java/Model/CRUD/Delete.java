package Model.CRUD;

import Model.CRUD.Interfaces.Filterable;

import static Model.CRUD.Interfaces.Filterable.appendAllFilters;

import Model.DBEntities.Collection;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Delete<T extends Collection> extends GenericCRUD<T> implements Filterable<T, Delete<T>> {
    private final List<Bson> filters;

    public Delete(Class<T> collection) {
        super(collection);
        this.filters = new ArrayList<>();
    }

    @Override
    public Delete<T> filter(Bson query) {
        this.filters.add(query);
        return this;
    }

    @Override
    public Optional<T> one() throws Exception {
        getCollection().deleteOne(appendAllFilters(filters));
        return Optional.empty();
    }

    @Override
    public List<T> many() throws Exception {
        getCollection().deleteMany(appendAllFilters(filters));
        return null;
    }

}
