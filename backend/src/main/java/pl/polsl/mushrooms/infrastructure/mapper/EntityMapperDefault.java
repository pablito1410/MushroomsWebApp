package pl.polsl.mushrooms.infrastructure.mapper;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 10.07.2017.
 */
public class EntityMapperDefault implements EntityMapper {

    private final ModelMapper modelMapper;
    private final EntityMapperRegistry registry;

    public EntityMapperDefault(
            final ModelMapper modelMapper,
            final EntityMapperRegistry registry) {

        this.modelMapper = modelMapper;
        this.registry = registry;
    }

    @Override
    public <T, R> Set<R> map(final Collection<T> set) {
        if (set.size() == 0) {
            return new HashSet();
        } else {
            final Class<?> genericType = set.iterator().next().getClass();
            final Type dtoType = registry.getForCollection(genericType);
            return modelMapper.map(set, dtoType);
        }
    }

    @Override
    public <R> R map(final Object obj) {
        final Class<?> genericType = obj.getClass();
        final Type dtoType = registry.getForObject(genericType);
        return modelMapper.map(obj,  dtoType);
    }

}
