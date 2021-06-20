package Model.CRUD.Interfaces;

import Model.CRUD.GenericCRUD;
import Model.DBEntities.Collection;
import org.bson.conversions.Bson;

public interface Settable<A extends Collection, T extends GenericCRUD<A>> {
    <Type> T set(String field, Type value);

    T set(Bson query);

}
