package Model.CRUD.Interfaces;

import Model.CRUD.GenericCRUD;
import Model.DBEntities.Collection;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import java.util.List;

import static com.mongodb.client.model.Filters.and;

public interface Filterable<A extends Collection, T extends GenericCRUD<A>> {
    T filter(Bson query);

    static Bson appendAllFilters(List<Bson> filters) {
        return filters.size() > 0 ? and(filters) : new BsonDocument();
    }
}
