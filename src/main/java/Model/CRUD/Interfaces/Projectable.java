package Model.CRUD.Interfaces;

import Model.CRUD.GenericCRUD;
import Model.DBEntities.Collection;
import org.bson.conversions.Bson;

import java.util.List;

import static Model.DBEntities.Collection.ID;
import static com.mongodb.client.model.Projections.*;

public interface Projectable<A extends Collection, T extends GenericCRUD<A>> {
    T project(String... fieldToShow);

    static Bson getProjection(List<String> fieldsToInclude) {
        return fieldsToInclude.size() > 0 ?
                fieldsToInclude.contains(ID) ?
                        include(fieldsToInclude) :
                        fields(include(fieldsToInclude), excludeId()) :
                null;
    }
}
