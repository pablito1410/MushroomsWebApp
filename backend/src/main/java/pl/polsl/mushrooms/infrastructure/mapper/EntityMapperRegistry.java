package pl.polsl.mushrooms.infrastructure.mapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Verify.verifyNotNull;


public class EntityMapperRegistry {

    private static Map<Type, Type> objectMapping = new HashMap<>();

    private static Map<Type, Type> collectionMapping = new HashMap<>();

    public <E, D> void registerObject(final Class<E> entityType, final Class<D> objectDtoType) {
        objectMapping.put(entityType, objectDtoType);
    }

    public <E> void registerCollection(final Class<E> entityType, final Type collectionDtoType) {
        collectionMapping.put(entityType, collectionDtoType);
    }

    public Type getForCollection(Class<?> collectionType) {
        verifyNotNull(collectionType);

        final Type type = collectionMapping.get(collectionType);

        if (type == null) {
            throw new RuntimeException("No DTO type registered for collection of type: " + collectionType.getSimpleName());
        } else {
            return type;
        }
    }

    public Type getForObject(Class<?> objectType) {
        verifyNotNull(objectType);

        final Type type = objectMapping.get(objectType);

        if (type == null) {
            throw new RuntimeException("No DTO type registered for type: " + objectType.getSimpleName());
        } else {
            return type;
        }
    }
}
