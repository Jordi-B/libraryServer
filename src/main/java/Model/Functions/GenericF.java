package Model.Functions;

import Model.DBEntities.Collection;
import Model.MongoOperation;
import com.google.gson.Gson;

import static Model.DBEntities.Collection.ID;
import static com.mongodb.client.model.Filters.eq;

public class GenericF {
    public static Gson gson = new Gson();

    public static <T extends Collection> String getAll(Class<T> entity) throws Exception {
        System.out.println("get all: " + gson.toJson(MongoOperation.find(entity).many()));
        return gson.toJson(MongoOperation.find(entity).many());
    }

    public static <T extends Collection> String getOneById(Class<T> entity, int id) throws Exception {
        return gson.toJson(MongoOperation.find(entity)
                .filter(eq(ID, id))
                .one()
                .orElse(null));
    }

    public static <T extends Collection, A> void setById(Class<T> entity, int id, String field, A value) throws Exception {
        MongoOperation.update(entity)
                .filter(eq(ID, id))
                .set(field, value)
                .one();
    }

    public static <T extends Collection> void deleteById(Class<T> entity, int id) throws Exception {
        MongoOperation.delete(entity)
                .filter(eq(ID, id))
                .one();
    }

}
