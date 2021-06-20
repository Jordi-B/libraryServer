package Model.CRUD;

import Model.CRUD.Interfaces.Filterable;

import static Model.CRUD.Interfaces.Filterable.appendAllFilters;

import Model.CRUD.Interfaces.Projectable;

import static Model.CRUD.Interfaces.Projectable.getProjection;

import Model.CRUD.Interfaces.Sortable;
import Model.DBEntities.Collection;
import com.mongodb.client.FindIterable;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.mongodb.client.model.Sorts.*;

public class Find<T extends Collection> extends GenericCRUD<T>
        implements Filterable<T, Find<T>>, Projectable<T, Find<T>>, Sortable<T, Find<T>> {
    private final List<Bson> filters;
    private final List<String> fieldsToInclude;
    private final List<Bson> sorts;

    public Find(Class<T> collection) {
        super(collection);
        this.filters = new ArrayList<>();
        this.fieldsToInclude = new ArrayList<>();
        this.sorts = new ArrayList<>();
    }

    @Override
    public Find<T> filter(Bson query) {
        this.filters.add(query);
        return this;
    }

    @Override
    public Find<T> project(String... fieldToInclude) {
        fieldsToInclude.addAll(Arrays.asList(fieldToInclude));
        return this;
    }

    @Override
    public Find<T> sort(String fieldToSortBy, boolean isAscending) {
        sorts.add(isAscending ? ascending(fieldToSortBy) : descending(fieldToSortBy));
        return this;
    }

    @Override
    public Find<T> sort(String fieldToSortBy) {
        return sort(fieldToSortBy, true);
    }

    @Override
    public Optional<T> one() throws Exception {
        return Optional.ofNullable(getCollection().find(appendAllFilters(filters))
                .projection(getProjection(fieldsToInclude)).sort(orderBy(sorts)).first());
    }

    @Override
    public List<T> many() throws Exception {
        FindIterable<T> foundIterator = getCollection().find(appendAllFilters(filters))
                .projection(getProjection(fieldsToInclude)).sort(orderBy(sorts));
        return StreamSupport.stream(foundIterator.spliterator(), false).collect(Collectors.toList());
    }
}
