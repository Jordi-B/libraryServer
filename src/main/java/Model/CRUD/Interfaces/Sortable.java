package Model.CRUD.Interfaces;

import Model.CRUD.GenericCRUD;
import Model.DBEntities.Collection;

public interface Sortable<A extends Collection, T extends GenericCRUD<A>> {
    T sort(String fieldToSortBy, boolean isAscending);
    T sort(String fieldToSortBy);
}
