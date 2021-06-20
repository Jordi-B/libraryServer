package Model.CRUD;

import Model.CRUD.Interfaces.Filterable;

import static Model.CRUD.Interfaces.Filterable.appendAllFilters;

import Model.CRUD.Interfaces.Settable;

import static com.mongodb.client.model.Updates.combine;

import Model.DBEntities.Collection;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Update<T extends Collection> extends GenericCRUD<T> implements Filterable<T, Update<T>>, Settable<T, Update<T>> {
    private final List<Bson> filters;
    private final List<Bson> setters;

    public Update(Class<T> collection) {
        super(collection);
        this.filters = new ArrayList<>();
        this.setters = new ArrayList<>();
    }

    @Override
    public Update<T> filter(Bson query) {
        this.filters.add(query);
        return this;
    }

    @Override
    public <A> Update<T> set(String field, A value) {
        setters.add(Updates.set(field, value));
        return this;
    }

    @Override
    public Update<T> set(Bson query) {
        setters.add(query);
        return this;
    }

    @Override
    public Optional<T> one() throws Exception {
        getCollection().updateOne(appendAllFilters(filters), combine(setters));
        return Optional.empty();
    }

    @Override
    public List<T> many() throws Exception {
        getCollection().updateMany(appendAllFilters(filters), combine(setters));
        return null;
    }
}
